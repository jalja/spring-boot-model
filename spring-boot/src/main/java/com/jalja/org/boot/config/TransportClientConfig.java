package com.jalja.org.boot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.jalja.org.boot.config"})
public class TransportClientConfig {
    @Value("${elasticsearch.cluster-name}")
    private String clusterName;
    @Value("${elasticsearch.cluster-nodes}")
    private String host;
    @Value("${elasticsearch.port}")
    private int port;
    //bean的id为transportClient  
    @Bean  
    public TransportClientFactory transportClient(){  
        TransportClientFactory transportClientFactory=new TransportClientFactory();  
        transportClientFactory.setClusterName(clusterName);  
        transportClientFactory.setHost(host);  
        transportClientFactory.setPort(port);  
        return transportClientFactory;  
    }  
}
