package com.xdclass.search.config;


import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix = "elasticsearch")
public class EsConfig {
    private String host;
    private Integer port;

    @Bean(destroyMethod = "close")
    public RestHighLevelClient client() {
        RestClientBuilder builder = RestClient.builder(
                new HttpHost(host, port, "http"))
                .setRequestConfigCallback(
                        requestConfigBuilder -> requestConfigBuilder
                                .setConnectTimeout(5 * 1000)
                                .setSocketTimeout(60 * 1000));

        return new RestHighLevelClient(builder);
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
