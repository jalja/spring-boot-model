package com.jalja.org.boot.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jalja.org.boot.model.TAssetCarModel;
import com.jalja.org.boot.service.ElasticsearchService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/es")
public class ElasticsearchController {
	@Autowired
	private ElasticsearchService elasticsearchService;
    @ApiOperation(value="查询所有汽车模型", notes="")
    @GetMapping(value = "/findAll")
    public List<TAssetCarModel>  addEsData(Long id) throws IOException{
        return elasticsearchService.addEsData(id);
    }
}
