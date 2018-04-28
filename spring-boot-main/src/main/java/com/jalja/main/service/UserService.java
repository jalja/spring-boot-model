package com.jalja.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jalja.main.mapper.JaljaUserMapper;
import com.jalja.main.model.JaljaUser;
import com.jalja.main.model.JaljaUserExample;
import com.jalja.main.model.JaljaUserExample.Criteria;

@Service
public class UserService {
	@Autowired
	private JaljaUserMapper jaljaUserMapper;
  
	public String getUsetList(String userName) {
		return userName==null?"zs":userName;	
	}
	public List<JaljaUser> getListById(Long id) {
		List<JaljaUser> list=getList(id);
		return list;
	}
	private List<JaljaUser> getList(Long id){
		JaljaUserExample example=new JaljaUserExample();
		if(id!=null) {
			Criteria criteria =example.createCriteria();
			criteria.andIdEqualTo(id.intValue());
		}
		List<JaljaUser> list=jaljaUserMapper.selectByExample(example);
		jaljaUserMapper.countByExample(example);
		JaljaUser user=list.get(0);
		user.setNickName("JALJA");
		jaljaUserMapper.updateByExample(user,example);
		return list;
	}
	/**
	 * 使用事务  开启 写库
	 * @param user
	 * @return
	 */
	@Transactional
	public boolean addUser(JaljaUser user) {
		JaljaUserExample example=new JaljaUserExample();
		if(user.getId()!=null) {
			Criteria criteria =example.createCriteria();
			criteria.andIdEqualTo(user.getId().intValue());
		}
		List<JaljaUser> list=jaljaUserMapper.selectByExample(example);
		System.out.println("["+list.get(0).getUserName()+"]");
		int result=jaljaUserMapper.insert(user);
		int m=1/0;
		return result>0;
	}
}
