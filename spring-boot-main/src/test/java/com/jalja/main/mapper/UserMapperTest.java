package com.jalja.main.mapper;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;

/**
 * 测试接口
 * @author XL
 *
 */

@RunWith(SpringRunner.class)
public class UserMapperTest {
    
	@MockBean
	private UserMapper userMapper;
	
	@Test
	public void test() {
		BDDMockito.given(userMapper.getUser("sz")).willReturn("sz");
		Assert.assertEquals(String.valueOf("sz"), userMapper.getUser("sz"));
	}

}
