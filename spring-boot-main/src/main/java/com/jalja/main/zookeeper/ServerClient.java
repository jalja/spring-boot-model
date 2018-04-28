package com.jalja.main.zookeeper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.jalja.main.utils.ServerRoute;

@Component
public class ServerClient {
	
	@Value(value="${zookeeper.addRess}")
	private String addRess;
	
	private ServiceDiscovery<Object> discovery=null;
	
	@PostConstruct
	public void init() throws InterruptedException {
		CuratorFramework client=CuratorFrameworkFactory.newClient(addRess, new RetryOneTime(100));
		client.start();
		client.blockUntilConnected();
		discovery=ServiceDiscoveryBuilder.builder(Object.class).client(client).basePath("/main").build();
	}
	
	public String getServer(String serverName) throws Exception {
		Collection<ServiceInstance<Object>> list=discovery.queryForInstances(serverName);
		final List<String> servers=new ArrayList<>();
		list.forEach((in)->{
			servers.add("http://"+in.getAddress()+":"+in.getPort());
		});
		ServerRoute.addMap(serverName, servers);
		return ServerRoute.getServer(serverName);
	}
}
