package com.jalja.main.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ServerRegister implements ApplicationRunner{
	@Value(value="${zookeeper.addRess}")
	private String addRess;
	
	@Value(value="${server.port}")
	private Integer serverPort;
	
	@Value(value="${server.context-path}")
	private String contextPath;
	@Value("${server.ip}")
	private String serverIp;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		CuratorFramework client=CuratorFrameworkFactory.newClient(addRess,new RetryOneTime(100));
		client.start();
		client.blockUntilConnected();
		ServiceInstance<Object> instance =ServiceInstance.builder().name(contextPath).address(serverIp).port(serverPort).build();
		ServiceDiscovery<Object> discovery=ServiceDiscoveryBuilder.builder(Object.class).client(client).basePath("/main").build();
		discovery.registerService(instance);
		discovery.start();
	}

}
