package com.example.infra.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticConfig {


    @Value("${apikey}")
    private String apiKey;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    @Value("${host}")
    private String esHost;


    @Bean
    public RestClient restClient() {
        return RestClient.builder(HttpHost.create(esHost))
                .setDefaultHeaders(new Header[]{
                        new BasicHeader("Authorization", "ApiKey " + apiKey)
                })
                .setRequestConfigCallback(requestConfigBuilder ->
                        requestConfigBuilder
                                .setConnectTimeout(50000)  // 연결 타임아웃 설정 (5초)
                                .setSocketTimeout(50000))  // 읽기 타임아웃 설정 (5초)
                .build();
    }

    // ElasticsearchTransport 설정
    @Bean
    public ElasticsearchTransport elasticsearchTransport(RestClient restClient) {
        return new RestClientTransport(restClient, new JacksonJsonpMapper());
    }

    // ElasticsearchClient 설정
    @Bean
    public ElasticsearchClient elasticsearchClient(ElasticsearchTransport elasticsearchTransport) {
        return new ElasticsearchClient(elasticsearchTransport);

    }


}