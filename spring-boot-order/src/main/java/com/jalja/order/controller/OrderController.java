package com.jalja.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jalja.order.zookeeper.ServerClient;


@RestController
@RequestMapping(value="/order")
public class OrderController {
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ServerClient serverClient;
	
	@GetMapping(value="getOrderById")
	public String getOrderById(Integer orderId) throws Exception {
		String url=serverClient.getServer("/springMain")+"/user/getUserName";
		System.out.println(url);
		String str=restTemplate.getForObject(url, String.class);
		return str;
	}

}
