package com.jalja.main.controller;

/**
 * 测试Controller 
 * 
 */
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest2 {
	
	@Autowired
	private MockMvc mvc;
	@Test
	public void test() throws Exception{
		mvc.perform(MockMvcRequestBuilders.get("/user/getUserName").param("userName", "AAA")).andExpect(MockMvcResultMatchers.status().isOk());
		
	}

}
