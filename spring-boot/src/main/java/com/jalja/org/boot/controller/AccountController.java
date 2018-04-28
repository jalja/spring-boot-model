package com.jalja.org.boot.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jalja.org.boot.service.AccountService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/account")
public class AccountController {
    @Autowired
	private  AccountService accountService;
    @ApiOperation(value="转账", notes="")
    @GetMapping(value = "/transferAccounts")
    public boolean transferAccounts(String accountNo,String incAccountNo,BigDecimal money){
        return accountService.transferAccounts( accountNo,incAccountNo,money);
    }
}
