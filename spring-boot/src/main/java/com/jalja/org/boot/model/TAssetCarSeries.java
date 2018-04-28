package com.jalja.org.boot.model;

import java.util.Date;

public class TAssetCarSeries {
    private Long id;

    private Long brandId;

    private String name;

    private String groupName;

    private Short isAllowLoan;

    private Date updateTime;

    private Long seriesTypeId;

    private Integer isDel;

    private String seriesColors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
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

    public Long getSeriesTypeId() {
        return seriesTypeId;
    }

    public void setSeriesTypeId(Long seriesTypeId) {
        this.seriesTypeId = seriesTypeId;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public String getSeriesColors() {
        return seriesColors;
    }

    public void setSeriesColors(String seriesColors) {
        this.seriesColors = seriesColors == null ? null : seriesColors.trim();
    }
}