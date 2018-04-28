package com.jalja.main.service;

import org.springframework.stereotype.Service;

@Service
public class TestUserService {
  
	public String getUsetList(String userName) {
		return userName==null?"zs":userName;	
	}
}
