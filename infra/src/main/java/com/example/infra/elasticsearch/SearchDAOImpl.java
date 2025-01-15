package com.example.infra.elasticsearch;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.example.common.model.request.TouristRequest;
import com.example.domain.document.Search;
import com.example.domain.document.dao.SearchDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;


import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@Repository
@Slf4j
@RequiredArgsConstructor
public class SearchDAOImpl implements SearchDAO {

    private final ElasticsearchClient client;
    @Override
    public List<Search> findTouristAll() throws IOException {
        SearchResponse<Search> response=client.search(s->s
                .index("test")
                .query(q->q.matchAll(t->t))
                ,Search.class);


        return  response.hits().hits().stream()
                .map(hit->hit.source())
                .collect(Collectors.toList());
    }
}
