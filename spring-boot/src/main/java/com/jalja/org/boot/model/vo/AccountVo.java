package com.jalja.org.boot.model.vo;

import java.math.BigDecimal;

import com.jalja.org.boot.model.TbAccount;

public class AccountVo extends TbAccount{
	private Integer type;
	private BigDecimal money;
	
	

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
}
