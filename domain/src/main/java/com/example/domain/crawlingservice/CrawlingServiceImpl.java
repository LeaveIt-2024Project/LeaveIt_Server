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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class CrawlingServiceImpl implements  CrawlingService{
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private static final String TARGET_URL = "https://travelsearch-api.naver.com/graphql";
//    private static final Map<String, String> REGION_CODES = Map.ofEntries(
//            Map.entry("서울", "09"),
//            Map.entry("부산", "08"),
//            Map.entry("제주", "14"),
//            Map.entry("강원", "01"),
//            Map.entry("경기", "02"),
//            Map.entry("인천", "11"),
//            Map.entry("경북", "04"),
//            Map.entry("경남", "03"),
//            Map.entry("충북", "16"),
//            Map.entry("충남", "15"),
//            Map.entry("전북", "13"),
//            Map.entry("전남", "12")
//    );

    @Override
    public   List<TravelDestination>  fetchPopularDestinations(String regionCode) {

//                List<TravelDestination> allDestinations = new ArrayList<>();
                List<TravelDestination> destinations = fetchDestinations(regionCode);
//                for (TravelDestination destination : destinations) {
//                    allDestinations.add(destination);
//                }
//                log.info(allDestinations.toString());
                return destinations;
        }

        public List<TravelDestination> fetchDestinations(String regionCode) {
            List<TravelDestination> destinations = new ArrayList<>();
            try {
                // GraphQL 요청 생성
                String graphqlQuery = """
                {
                    "operationName": "GET_FILTERED_SIGHTS",
                    "query": "query GET_FILTERED_SIGHTS($rcode: String!, $size: Int, $from: Int, $filterTag: String, $tagSize: Int) { domesticSights(rcode: $rcode, size: $size, from: $from, filterTag: $filterTag, tagSize: $tagSize) { totalCount tags { name tagId } list { title pcUrl moUrl imageUrl ctxTags } moreUrl } }",
                    "variables": {
                        "rcode": "%s",
                        "size": 20,
                        "from": 0,
                        "filterTag": null,
                        "tagSize": 7
                    }
                }
            """.formatted(regionCode);

                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                headers.set("Origin", "https://travel.naver.com");

                HttpEntity<String> entity = new HttpEntity<>(graphqlQuery, headers);
                ResponseEntity<String> response = restTemplate.exchange(TARGET_URL, HttpMethod.POST, entity, String.class);

                if (response.getBody() != null) {
                    JsonNode jsonResponse = objectMapper.readTree(response.getBody());
                    JsonNode sights = jsonResponse.path("data").path("domesticSights").path("list");

                    for (JsonNode sight : sights) {
                        String title = sight.path("title").asText();
                        String pcUrl = sight.path("pcUrl").asText();
                        String moUrl = sight.path("moUrl").asText(""); // 모바일 URL
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
