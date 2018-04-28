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
public class AssetVehicleService {
    @Autowired
	private JaljaUserMapper jaljaUserMapper;
	
    @Transactional
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
		return list;
	}
    private void add(List<JaljaUser> list) {
    	if(list!=null && !list.isEmpty() ) {
    		for(JaljaUser tv:list) {
    			tv.setId(null);
    			jaljaUserMapper.insert(tv);
    		}
    	}
    }
}
