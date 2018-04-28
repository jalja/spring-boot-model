package com.jalja.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jalja.main.model.JaljaUser;
import com.jalja.main.service.UserService;

@RestController
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	private UserService userService;
	@GetMapping(value="getUserName")
	public String getUserName(String userName) {
		return userService.getUsetList(userName);
	}
	
	@GetMapping("/getListById")
	public List<JaljaUser> getListById(Long id) {
		return userService.getListById(id);
	}

	@GetMapping("/addUser")
	public boolean addUser(JaljaUser user) {
		return userService.addUser(user);
	}
	
}
