package com.jalja.org.boot.controller;

import com.jalja.org.boot.model.TbArticle;
import com.jalja.org.boot.model.TbAuthor;
import com.jalja.org.boot.model.TbTutorial;
import com.jalja.org.boot.model.vo.ArticleVO;
import com.jalja.org.boot.service.ArticleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @ApiOperation(value="获取课程列表", notes="")
    @GetMapping(value = "/getAll")
    public List<TbArticle> getAll(){
        return articleService.getAll();
    }

    @ApiOperation(value="获取课程列表 根据ID查询", notes="")
    @GetMapping(value = "/getVos")
    public List<ArticleVO> getVos(Integer id){
        return articleService.getVos(id);
    }


    @ApiOperation(value="获取课程列表", notes="")
    @GetMapping(value = "/add")
    public boolean add(){
        return articleService.addTbArticle();
    }


    @ApiOperation(value="添加作者", notes="")
    @GetMapping(value = "/addTbAuthor")
    public boolean addTbAuthor(TbAuthor author){
        return articleService.addTbAuthor(author);
    }

    
    @ApiOperation(value="测试消息发送", notes="")
    @GetMapping(value = "/sendMsg")
    public boolean addTbAuthor(String msg){
        return articleService.sendMsg(msg);
    }
    
    @ApiOperation(value="获取所有作者", notes="")
    @GetMapping(value = "/getTbAuthorAll")
    public List<TbTutorial> getTbAuthorAll(TbAuthor author){
        return articleService.getTbAuthorAll(author);
    }

}
