package com.jalja.org.boot.model;

import java.util.Date;

public class TAssetCarBrand {
    private Long id;

    private String name;

    private String initial;

    private Short isAllowLoan;

    private Date updateTime;

    private Integer isDel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial == null ? null : initial.trim();
    }

    public Short getIsAllowLoan() {
        return isAllowLoan;
    }

    public void setIsAllowLoan(Short isAllowLoan) {
        this.isAllowLoan = isAllowLoan;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}