package com.jalja.org.boot.model.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class TransferAccount implements Serializable{
	//logger.info("账户：["+accountNo+"] 转入账户["+incAccountNo+"] 金额：["+money+"]");
	private String accountNo;
	private String incAccountNo;
	private BigDecimal money;
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getIncAccountNo() {
		return incAccountNo;
	}
	public void setIncAccountNo(String incAccountNo) {
		this.incAccountNo = incAccountNo;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	

}
