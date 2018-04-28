package com.jalja.main.service;





import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestConfig.class)
public class TestUserServiceTest {
	@Autowired
	private UserService userService;
	
	@Autowired
	private Runnable runnable;
	
	@Autowired
	private ApplicationContext context;
	
	@Test
	public void testGetUsetList() {
		System.out.println(runnable);
		System.out.println(userService.getUsetList("lz"));
	}
}
