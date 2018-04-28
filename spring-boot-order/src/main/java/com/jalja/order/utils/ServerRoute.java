package com.jalja.order.utils;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class ServerRoute {
	
	
	private static Map<String,List<String>> mapList=new ConcurrentHashMap<String, List<String>>();
	
	private ServerRoute() {
		
	}
	
	public static void addMap(String serverName,List<String> list) {
		mapList.put(serverName, list);
	}
	
	public static String getServer(String serverName) {
		List<String> servers=mapList.get(serverName);
		Integer num=new Random().nextInt(servers.size());
		return servers.get(num);
	}
	
}
