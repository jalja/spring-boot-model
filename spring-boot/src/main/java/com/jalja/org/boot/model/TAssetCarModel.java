package com.jalja.org.boot.model;

import java.io.Serializable;
import java.util.Date;

public class TAssetCarModel implements Serializable {
    private Long id;
    
    private Long seriesId;

    private String name;

    private String shortName;

    private Double price;

    private String year;

    private String minRegYear;

    private String maxRegYear;

    private String liter;

    private String gearType;

    private String dischargeStandard;

    private String seatNumber;

    private Short isAllowLoan;

    private Date updateTime;

    private Integer isDel;

    private String highLight;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Long seriesId) {
        this.seriesId = seriesId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getMinRegYear() {
        return minRegYear;
    }

    public void setMinRegYear(String minRegYear) {
        this.minRegYear = minRegYear == null ? null : minRegYear.trim();
    }

    public String getMaxRegYear() {
        return maxRegYear;
    }

    public void setMaxRegYear(String maxRegYear) {
        this.maxRegYear = maxRegYear == null ? null : maxRegYear.trim();
    }

    public String getLiter() {
        return liter;
    }

    public void setLiter(String liter) {
        this.liter = liter == null ? null : liter.trim();
    }

    public String getGearType() {
        return gearType;
    }

    public void setGearType(String gearType) {
        this.gearType = gearType == null ? null : gearType.trim();
    }

    public String getDischargeStandard() {
        return dischargeStandard;
    }

    public void setDischargeStandard(String dischargeStandard) {
        this.dischargeStandard = dischargeStandard == null ? null : dischargeStandard.trim();
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber == null ? null : seatNumber.trim();
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

    public String getHighLight() {
        return highLight;
    }

    public void setHighLight(String highLight) {
        this.highLight = highLight == null ? null : highLight.trim();
    }
}