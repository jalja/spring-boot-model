package com.jalja.org.boot.config;


import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

@Component
public class TransportClientFactory  implements FactoryBean<TransportClient>,InitializingBean,DisposableBean {
    private String clusterName;
    private String host;
    private int port;
    private TransportClient client;

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public TransportClient getObject() throws Exception {
        return client;
    }
    @Override 
    public Class<?> getObjectType() {
        return TransportClient.class;
    }
    @Override  
    public boolean isSingleton() {
        return false;
    }
    @Override  
    public void destroy() throws Exception {
        if(client!=null)
            client.close();
    }

	@Override
	public void afterPropertiesSet() throws Exception {
		  client = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(new TransportAddress(InetAddress.getByName(this.host), this.port));
		  System.out.println(client);
	}
	
}