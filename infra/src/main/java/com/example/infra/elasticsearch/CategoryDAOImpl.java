package com.example.infra.elasticsearch;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.example.common.exception.db.EsIoException;
import com.example.domain.document.Food;
import com.example.domain.document.Place;
import com.example.domain.document.dao.CategoryDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;


import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.example.common.exception.db.DBErrorCode.ES_NOT_FOUND;


@Repository
@Slf4j
@RequiredArgsConstructor
public class CategoryDAOImpl implements CategoryDAO {

    private final ElasticsearchClient client;
    @Override
    public List<Place> findAreaPlace(String area,int num)  {
        try {
            SearchResponse<Place> response = client.search(s -> s
                    .index("place")
                    .from((num - 1) * 10)
                    .size(10)
                    .query(q -> q.term(t -> t.value(area)
                            .field("areacode"))), Place.class);
            return  response.hits().hits().stream()
                    .map(hit->hit.source())
                    .collect(Collectors.toList());
        }catch (IOException e){
            log.error("데이터 값이 없습니다");
            throw new EsIoException(ES_NOT_FOUND);
        }}

    @Override
    public List<Place> findTypePlace(String cat,int num)  {
        try {
            SearchResponse<Place> response = client.search(s -> s
                    .index("place")
                    .from((num - 1) * 10)
                    .size(10)
                    .query(q -> q.term(t -> t.value(cat)
                            .field("cat"))), Place.class);
            return  response.hits().hits().stream()
                    .map(hit->hit.source())
                    .collect(Collectors.toList());
        }catch (IOException e){
            log.error("데이터 값이 없습니다");
            throw new EsIoException(ES_NOT_FOUND);
        }
    }

    @Override
    public List<Place> findTypeAndAreaPlace(String cat,String areaCode,int num)  {
        try {
            SearchResponse<Place> response = client.search(s -> s
                            .index("place")
                            .from((num - 1) * 10)
                            .size(10)
                            .query(q -> q.bool(b -> b
                                    .filter(a -> a.term(t -> t.field("cat").value(cat)))
                                    .filter(f -> f.term(t -> t.field("areaCode").value(areaCode)))))
                    ,Place.class);
            return  response.hits().hits().stream()
                    .map(hit->hit.source())
                    .collect(Collectors.toList());
        }catch (IOException e){
            log.error("데이터 값이 없습니다");
            throw new EsIoException(ES_NOT_FOUND);
        }
    }


    @Override
    public List<Place> searchAreaPlace(String place,int num)  {
        try {
            SearchResponse<Place> response = client.search(s -> s
                    .index("place")
                    .from((num - 1) * 10)
                    .size(10)
                    .query(q -> q.match(t ->t.field("addr1")
                            .query(place))), Place.class);
            return  response.hits().hits().stream()
                    .map(hit->hit.source())
                    .collect(Collectors.toList());
        }catch (IOException e){
            log.error("데이터 값이 없습니다");
            throw new EsIoException(ES_NOT_FOUND);
        }}

    @Override
    public void saveAreaPlace(String area,int num) {
        try {
            IndexResponse response = client.index(s -> s
                    .index("places")
                    .id(UUID.randomUUID().toString())
                    .document(area));
        } catch (IOException e) {
            log.error("데이터 값이 없습니다");
            throw new EsIoException(ES_NOT_FOUND);
        }
    }

    @Override
    public List<Food> findAreaFood(int num, String areaCode) throws IOException {
        SearchResponse<Food> response=client.search(s->s
                        .index("food")
                        .from( (num - 1) * 10)
                        .size(10)
                        .query(q->q.term(t->t.value(areaCode)
                                .field("areaCode")))
                , Food.class);
        return  response.hits().hits().stream()
                .map(hit->hit.source())
                .collect(Collectors.toList());
    }
}



