package com.example.domain.crawlingservice;


import com.example.common.model.request.TravelDestination;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CrawlingServiceImpl implements  CrawlingService{
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private static final String TARGET_URL = "https://travelsearch-api.naver.com/graphql";
    @Override
    public List<TravelDestination> fetchPopularDestinations() {
        List<TravelDestination> destinations = new ArrayList<>();

        // GraphQL Query
        String query = """
        {
            "operationName": "GET_FILTERED_SIGHTS",
            "query": "query GET_FILTERED_SIGHTS($rcode: String!, $size: Int, $from: Int, $filterTag: String, $tagSize: Int) { domesticSights(rcode: $rcode, size: $size, from: $from, filterTag: $filterTag, tagSize: $tagSize) { totalCount tags { name tagId } list { title pcUrl moUrl imageUrl ctxTags } moreUrl } }",
            "variables": {
                "rcode": "07",
                "size": 20,
                "from": 0,
                "filterTag": null,
                "tagSize": 7
            }
        }
        """;

        // HTTP 요청 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Referer", "https://travel.naver.com/");
        headers.set("User-Agent", "Mozilla/5.0");

        // 요청 본문 설정
        HttpEntity<String> requestEntity = new HttpEntity<>(query, headers);

        try {
            // GraphQL 요청 실행
            ResponseEntity<String> response = restTemplate.exchange(TARGET_URL, HttpMethod.POST, requestEntity, String.class);
            String responseBody = response.getBody();

            if (responseBody != null) {
                // JSON 파싱
                JsonNode rootNode = objectMapper.readTree(responseBody);
                JsonNode sights = rootNode.path("data").path("domesticSights").path("list");

                // 여행지 목록 처리
                for (JsonNode sight : sights) {
                    String title = sight.path("title").asText();
                    String pcUrl = sight.path("pcUrl").asText();
                    String moUrl = sight.path("moUrl").asText(""); // 모바일 URL (없으면 빈 문자열)
                    String imageUrl = sight.path("imageUrl").asText();

                    destinations.add(new TravelDestination(title, pcUrl, moUrl, imageUrl));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return destinations;
    }
}
