package com.jalja.org.boot.service;

import com.alibaba.fastjson.JSONObject;
import com.jalja.org.boot.mapper.TbArticleMapper;
import com.jalja.org.boot.mapper.TbAuthorMapper;
import com.jalja.org.boot.mapper.TbTutorialMapper;
import com.jalja.org.boot.model.*;
import com.jalja.org.boot.model.vo.ArticleVO;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private TbArticleMapper tbArticleMapper;
    @Autowired
    private TbAuthorMapper tbAuthorMapper;
    @Autowired
    private TbTutorialMapper tbTutorialMapper;
    @Autowired
    private RocketMqService rocketMqService;
    @Autowired
    private ArticleService articleService;

    private static final Logger logger= LoggerFactory.getLogger(ArticleService.class);

    public List<ArticleVO> getVos(Integer id){


        return null;
    }

    public List<TbArticle> getAll(){
        TbArticleExample example=new TbArticleExample();
        TbArticleExample.Criteria criteria= example.createCriteria();
       return tbArticleMapper.selectByExample(example);
    }
    public boolean addTbArticle(){
        TbArticleExample example=new TbArticleExample();
        TbArticleExample.Criteria criteria= example.createCriteria();
        List<TbArticle> list=tbArticleMapper.selectByExample(example);
        ArticleVO vo=null;
        for (TbArticle article:list){
                vo=new ArticleVO();
                vo.setId(article.getId());
                vo.setClickCount(article.getClickCount());
                vo.setPostTime(article.getPostTime());
                vo.setTitle(article.getTitle());
                vo.setContent(article.getContent());
                vo.setTbAuthor(getTbAuthor(article.getAuthorId()));
                vo.setTbTutorial(getTbTutorial(article.getTutorialId()));
                addEs(vo);
        }
        return true;
    }
    private TbAuthor getTbAuthor(Integer id){
        TbAuthorExample example=new TbAuthorExample();
        TbAuthorExample.Criteria criteria=example.createCriteria();
        criteria.andIdEqualTo(id);
       return tbAuthorMapper.selectByExample(example).get(0);
    }
    private TbTutorial getTbTutorial(Integer id){
        TbTutorialExample example=new TbTutorialExample();
        TbTutorialExample.Criteria criteria=example.createCriteria();
        criteria.andIdEqualTo(id);
        return tbTutorialMapper.selectByExample(example).get(0);
    }
    private void addEs(ArticleVO vo){
       
    }
    @Transactional(propagation= Propagation.REQUIRED)
    public boolean addTbAuthor(TbAuthor author) throws RuntimeException{
        author.setCreateTime(new Date());
        int m=tbAuthorMapper.insert(author);
        m=1/0;
        return m>0;
    }
    
    public boolean sendMsg(String msg) {
    	return rocketMqService.sendMsg(msg);
    }

	public List<TbTutorial> getTbAuthorAll(TbAuthor author) throws RuntimeException{
		TbTutorialExample example=new TbTutorialExample();
        List<TbTutorial> list=tbTutorialMapper.selectByExample(example);
        articleService.addTbAuthor(author);
        return list;
	}
}
