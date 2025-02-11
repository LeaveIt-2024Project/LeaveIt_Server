package com.example.infra.elasticsearch;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.FunctionScoreMode;
import co.elastic.clients.elasticsearch.core.BulkRequest;
import co.elastic.clients.elasticsearch.core.BulkResponse;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.example.common.exception.db.EsIoException;
import com.example.domain.document.Place;
import com.example.domain.document.PlaceLog;
import com.example.domain.document.dao.SearchDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

import static com.example.common.exception.db.DBErrorCode.ES_NOT_FOUND;


@Slf4j
@Repository
@RequiredArgsConstructor
public class SearchDAOImpl implements  SearchDAO {

    private final ElasticsearchClient client;

    @Override
    public List<Place> searchPlace(int num, String text) {
        try {
            SearchResponse<Place> response = client.search(s -> s
                    .index("place")
                    .from((num - 1) * 10)
                    .size(10)
                    .query(q -> q.functionScore(fs -> fs
                            .query(q2 -> q2.bool(b -> b
                                    .should(q3 -> q3.match(m -> m
                                            .field("title")
                                            .query(text)
                                            .fuzziness("AUTO")
                                    ))
                                    .should(q4 -> q4.matchPhrase(m -> m
                                            .field("title")
                                            .query(text)
                                    ))

                            ))
                            .functions(fn -> fn
                                    .filter(f -> f.matchPhrase(mp -> mp
                                            .field("title")
                                            .query(text)
                                    ))
                                    .weight(5.0)
                            )
                            .scoreMode(FunctionScoreMode.Multiply)
                    )), Place.class);

            log.info(response.toString());
            return response.hits().hits().stream()
                    .map(hit -> hit.source())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            log.error("데이터 값이 존재하지않습니다");
            throw new EsIoException(ES_NOT_FOUND);
        }
    }

    @Override
    public void saveSearchLog(List<PlaceLog> batchLogs) {
        log.info(batchLogs.toString());
        try {
            BulkRequest.Builder bulkRequest = new BulkRequest.Builder();

            for (PlaceLog log : batchLogs) {
                bulkRequest.operations(op -> op
                        .index(idx -> idx
                                .index("placelog")
                                .document(log)
                        ));

            }
            BulkResponse response = client.bulk(bulkRequest.build());
            if (response.errors()) {
                System.err.println("Bulk insert 실패: " + response.toString());
            }
        } catch (IOException e) {
            log.error("데이터 값이 존재하지않습니다");
            throw new EsIoException(ES_NOT_FOUND);
        }
    }

        @Override
        public List<String> searchPopularPlace() {
            try {
                SearchResponse<PlaceLog> response = client.search(s -> s
                        .index("placelog")
                        .size(0)
                        .aggregations("popularPlace", a -> a
                                .terms(t -> t.field("title").size(10))
                        ), PlaceLog.class);
                return response.aggregations().get("popularPlace").sterms().buckets().array()
                        .stream()
                        .map(bucket -> bucket.key().stringValue())
                        .collect(Collectors.toList());

            } catch (IOException e) {
                log.error("데이터 값이 존재하지 않습니다");
                throw new EsIoException(ES_NOT_FOUND);
            }
        }
    }

