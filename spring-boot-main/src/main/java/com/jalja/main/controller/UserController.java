package com.jalja.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jalja.main.service.TestUserService;

@RestController
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	private TestUserService testUserService;
	@GetMapping(value="getUserName")
	public String getUserName(String userName) {
		return testUserService.getUsetList(userName);
	}

}
