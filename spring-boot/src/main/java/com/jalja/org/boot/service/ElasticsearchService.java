package com.jalja.org.boot.service;

import java.io.IOException;
import java.util.List;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.jalja.org.boot.mapper.TAssetCarBrandMapper;
import com.jalja.org.boot.mapper.TAssetCarModelMapper;
import com.jalja.org.boot.mapper.TAssetCarSeriesMapper;
import com.jalja.org.boot.model.TAssetCarModel;
import com.jalja.org.boot.model.TAssetCarModelExample;
import com.jalja.org.boot.model.TAssetCarModelExample.Criteria;

@Service
public class ElasticsearchService {
	private static Logger logger=LoggerFactory.getLogger(ElasticsearchService.class);
	
	@Autowired
	private TAssetCarModelMapper tAssetCarModelMapper;
	
	@Autowired
	private TAssetCarBrandMapper TAssetCarBrandMapper;
	
	@Autowired
	private TAssetCarSeriesMapper  tAssetCarSeriesMapper;
	
	
	
	@Autowired
	private  TransportClient transportClient;
	
	public List<TAssetCarModel>  addEsData(Long id) throws IOException {
		TAssetCarModelExample example=new TAssetCarModelExample();
		//Criteria criteria=example.createCriteria();
		//criteria.andIdEqualTo(id);
		List<TAssetCarModel> list=tAssetCarModelMapper.selectByExample(example);
	    if(list==null || list.isEmpty()) {
	    	return null;
	    }
	    for(TAssetCarModel model:list) {
	    	addTAssetCarModelEs(model);
	    }
	    /*list.forEach((model)->{
	    	addTAssetCarModelEs(model);
	    });*/
		return list;
	}
	private boolean addTAssetCarModelEs(TAssetCarModel model) throws IOException {
		IndexResponse response = transportClient.prepareIndex("car_index", "car_type", model.getId().toString())
				.setSource(XContentFactory.jsonBuilder()
						.startObject()
						.field("name",model.getName())
						.field("seriesId",model.getSeriesId())
						.field("shortName", model.getShortName())
						.field("price", model.getPrice())
						.field("year", model.getYear())
						.field("minRegYear", model.getMinRegYear())
						.field("maxRegYear", model.getMaxRegYear())
						.field("liter", model.getLiter())
						.field("gearType", model.getGearType())
						.field("dischargeStandard", model.getDischargeStandard())
						.field("seatNumber", model.getSeatNumber())
						.field("isAllowLoan", model.getIsAllowLoan())
						.field("updateTime", model.getUpdateTime())
						.field("isDel", model.getIsDel())
						.field("highLight", model.getHighLight())
						.endObject())
				.get();
		logger.info("结果：["+response+"]");
		 
		return false;
	}
}
