package com.aoo.withelasticsearch.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InvoiceConfig {
    @Bean
    public RestClient getRestClient(){
        RestClient restClient = RestClient.builder(new HttpHost("localhost",9200)).build();
        return restClient;
    }
    @Bean
    public ElasticsearchTransport getElasticsearchTransport(){
        return new RestClientTransport(getRestClient(),new JacksonJsonpMapper());
    }
    @Bean
    public ElasticsearchClient getElasticsearchClient(){
        ElasticsearchClient client = new ElasticsearchClient(getElasticsearchTransport());
        return client;
    }
    /*
    *
    * Here, getRestClient( ) method is used to configure
    * the URL and port number of the currently running Elasticsearch.

getElasticsearchTransport( ) method returns the Transport Object in order
* to automatically map our Model Class to JSON and integrates them with API Client.

getElasticsearchClient( ) It returns an object of ElasticsearchClient, which is further
* used to perform all query operations with Elasticsearch.
    * */
}
