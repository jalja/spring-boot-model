package com.jalja.org.boot.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @ApiOperation(value="获取用户列表", notes="")
    @GetMapping(value = "/getAll")
    public String getAll(){
        return "hello";
    }
}
