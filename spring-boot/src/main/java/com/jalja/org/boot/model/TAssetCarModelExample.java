package com.jalja.org.boot.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TAssetCarModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TAssetCarModelExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSeriesIdIsNull() {
            addCriterion("series_id is null");
            return (Criteria) this;
        }

        public Criteria andSeriesIdIsNotNull() {
            addCriterion("series_id is not null");
            return (Criteria) this;
        }

        public Criteria andSeriesIdEqualTo(Long value) {
            addCriterion("series_id =", value, "seriesId");
            return (Criteria) this;
        }

        public Criteria andSeriesIdNotEqualTo(Long value) {
            addCriterion("series_id <>", value, "seriesId");
            return (Criteria) this;
        }

        public Criteria andSeriesIdGreaterThan(Long value) {
            addCriterion("series_id >", value, "seriesId");
            return (Criteria) this;
        }

        public Criteria andSeriesIdGreaterThanOrEqualTo(Long value) {
            addCriterion("series_id >=", value, "seriesId");
            return (Criteria) this;
        }

        public Criteria andSeriesIdLessThan(Long value) {
            addCriterion("series_id <", value, "seriesId");
            return (Criteria) this;
        }

        public Criteria andSeriesIdLessThanOrEqualTo(Long value) {
            addCriterion("series_id <=", value, "seriesId");
            return (Criteria) this;
        }

        public Criteria andSeriesIdIn(List<Long> values) {
            addCriterion("series_id in", values, "seriesId");
            return (Criteria) this;
        }

        public Criteria andSeriesIdNotIn(List<Long> values) {
            addCriterion("series_id not in", values, "seriesId");
            return (Criteria) this;
        }

        public Criteria andSeriesIdBetween(Long value1, Long value2) {
            addCriterion("series_id between", value1, value2, "seriesId");
            return (Criteria) this;
        }

        public Criteria andSeriesIdNotBetween(Long value1, Long value2) {
            addCriterion("series_id not between", value1, value2, "seriesId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNull() {
            addCriterion("short_name is null");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNotNull() {
            addCriterion("short_name is not null");
            return (Criteria) this;
        }

        public Criteria andShortNameEqualTo(String value) {
            addCriterion("short_name =", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotEqualTo(String value) {
            addCriterion("short_name <>", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThan(String value) {
            addCriterion("short_name >", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("short_name >=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThan(String value) {
            addCriterion("short_name <", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThanOrEqualTo(String value) {
            addCriterion("short_name <=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLike(String value) {
            addCriterion("short_name like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotLike(String value) {
            addCriterion("short_name not like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameIn(List<String> values) {
            addCriterion("short_name in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotIn(List<String> values) {
            addCriterion("short_name not in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameBetween(String value1, String value2) {
            addCriterion("short_name between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotBetween(String value1, String value2) {
            addCriterion("short_name not between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(String value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(String value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(String value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(String value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(String value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(String value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLike(String value) {
            addCriterion("year like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotLike(String value) {
            addCriterion("year not like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<String> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<String> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(String value1, String value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(String value1, String value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andMinRegYearIsNull() {
            addCriterion("min_reg_year is null");
            return (Criteria) this;
        }

        public Criteria andMinRegYearIsNotNull() {
            addCriterion("min_reg_year is not null");
            return (Criteria) this;
        }

        public Criteria andMinRegYearEqualTo(String value) {
            addCriterion("min_reg_year =", value, "minRegYear");
            return (Criteria) this;
        }

        public Criteria andMinRegYearNotEqualTo(String value) {
            addCriterion("min_reg_year <>", value, "minRegYear");
            return (Criteria) this;
        }

        public Criteria andMinRegYearGreaterThan(String value) {
            addCriterion("min_reg_year >", value, "minRegYear");
            return (Criteria) this;
        }

        public Criteria andMinRegYearGreaterThanOrEqualTo(String value) {
            addCriterion("min_reg_year >=", value, "minRegYear");
            return (Criteria) this;
        }

        public Criteria andMinRegYearLessThan(String value) {
            addCriterion("min_reg_year <", value, "minRegYear");
            return (Criteria) this;
        }

        public Criteria andMinRegYearLessThanOrEqualTo(String value) {
            addCriterion("min_reg_year <=", value, "minRegYear");
            return (Criteria) this;
        }

        public Criteria andMinRegYearLike(String value) {
            addCriterion("min_reg_year like", value, "minRegYear");
            return (Criteria) this;
        }

        public Criteria andMinRegYearNotLike(String value) {
            addCriterion("min_reg_year not like", value, "minRegYear");
            return (Criteria) this;
        }

        public Criteria andMinRegYearIn(List<String> values) {
            addCriterion("min_reg_year in", values, "minRegYear");
            return (Criteria) this;
        }

        public Criteria andMinRegYearNotIn(List<String> values) {
            addCriterion("min_reg_year not in", values, "minRegYear");
            return (Criteria) this;
        }

        public Criteria andMinRegYearBetween(String value1, String value2) {
            addCriterion("min_reg_year between", value1, value2, "minRegYear");
            return (Criteria) this;
        }

        public Criteria andMinRegYearNotBetween(String value1, String value2) {
            addCriterion("min_reg_year not between", value1, value2, "minRegYear");
            return (Criteria) this;
        }

        public Criteria andMaxRegYearIsNull() {
            addCriterion("max_reg_year is null");
            return (Criteria) this;
        }

        public Criteria andMaxRegYearIsNotNull() {
            addCriterion("max_reg_year is not null");
            return (Criteria) this;
        }

        public Criteria andMaxRegYearEqualTo(String value) {
            addCriterion("max_reg_year =", value, "maxRegYear");
            return (Criteria) this;
        }

        public Criteria andMaxRegYearNotEqualTo(String value) {
            addCriterion("max_reg_year <>", value, "maxRegYear");
            return (Criteria) this;
        }

        public Criteria andMaxRegYearGreaterThan(String value) {
            addCriterion("max_reg_year >", value, "maxRegYear");
            return (Criteria) this;
        }

        public Criteria andMaxRegYearGreaterThanOrEqualTo(String value) {
            addCriterion("max_reg_year >=", value, "maxRegYear");
            return (Criteria) this;
        }

        public Criteria andMaxRegYearLessThan(String value) {
            addCriterion("max_reg_year <", value, "maxRegYear");
            return (Criteria) this;
        }

        public Criteria andMaxRegYearLessThanOrEqualTo(String value) {
            addCriterion("max_reg_year <=", value, "maxRegYear");
            return (Criteria) this;
        }

        public Criteria andMaxRegYearLike(String value) {
            addCriterion("max_reg_year like", value, "maxRegYear");
            return (Criteria) this;
        }

        public Criteria andMaxRegYearNotLike(String value) {
            addCriterion("max_reg_year not like", value, "maxRegYear");
            return (Criteria) this;
        }

        public Criteria andMaxRegYearIn(List<String> values) {
            addCriterion("max_reg_year in", values, "maxRegYear");
            return (Criteria) this;
        }

        public Criteria andMaxRegYearNotIn(List<String> values) {
            addCriterion("max_reg_year not in", values, "maxRegYear");
            return (Criteria) this;
        }

        public Criteria andMaxRegYearBetween(String value1, String value2) {
            addCriterion("max_reg_year between", value1, value2, "maxRegYear");
            return (Criteria) this;
        }

        public Criteria andMaxRegYearNotBetween(String value1, String value2) {
            addCriterion("max_reg_year not between", value1, value2, "maxRegYear");
            return (Criteria) this;
        }

        public Criteria andLiterIsNull() {
            addCriterion("liter is null");
            return (Criteria) this;
        }

        public Criteria andLiterIsNotNull() {
            addCriterion("liter is not null");
            return (Criteria) this;
        }

        public Criteria andLiterEqualTo(String value) {
            addCriterion("liter =", value, "liter");
            return (Criteria) this;
        }

        public Criteria andLiterNotEqualTo(String value) {
            addCriterion("liter <>", value, "liter");
            return (Criteria) this;
        }

        public Criteria andLiterGreaterThan(String value) {
            addCriterion("liter >", value, "liter");
            return (Criteria) this;
        }

        public Criteria andLiterGreaterThanOrEqualTo(String value) {
            addCriterion("liter >=", value, "liter");
            return (Criteria) this;
        }

        public Criteria andLiterLessThan(String value) {
            addCriterion("liter <", value, "liter");
            return (Criteria) this;
        }

        public Criteria andLiterLessThanOrEqualTo(String value) {
            addCriterion("liter <=", value, "liter");
            return (Criteria) this;
        }

        public Criteria andLiterLike(String value) {
            addCriterion("liter like", value, "liter");
            return (Criteria) this;
        }

        public Criteria andLiterNotLike(String value) {
            addCriterion("liter not like", value, "liter");
            return (Criteria) this;
        }

        public Criteria andLiterIn(List<String> values) {
            addCriterion("liter in", values, "liter");
            return (Criteria) this;
        }

        public Criteria andLiterNotIn(List<String> values) {
            addCriterion("liter not in", values, "liter");
            return (Criteria) this;
        }

        public Criteria andLiterBetween(String value1, String value2) {
            addCriterion("liter between", value1, value2, "liter");
            return (Criteria) this;
        }

        public Criteria andLiterNotBetween(String value1, String value2) {
            addCriterion("liter not between", value1, value2, "liter");
            return (Criteria) this;
        }

        public Criteria andGearTypeIsNull() {
            addCriterion("gear_type is null");
            return (Criteria) this;
        }

        public Criteria andGearTypeIsNotNull() {
            addCriterion("gear_type is not null");
            return (Criteria) this;
        }

        public Criteria andGearTypeEqualTo(String value) {
            addCriterion("gear_type =", value, "gearType");
            return (Criteria) this;
        }

        public Criteria andGearTypeNotEqualTo(String value) {
            addCriterion("gear_type <>", value, "gearType");
            return (Criteria) this;
        }

        public Criteria andGearTypeGreaterThan(String value) {
            addCriterion("gear_type >", value, "gearType");
            return (Criteria) this;
        }

        public Criteria andGearTypeGreaterThanOrEqualTo(String value) {
            addCriterion("gear_type >=", value, "gearType");
            return (Criteria) this;
        }

        public Criteria andGearTypeLessThan(String value) {
            addCriterion("gear_type <", value, "gearType");
            return (Criteria) this;
        }

        public Criteria andGearTypeLessThanOrEqualTo(String value) {
            addCriterion("gear_type <=", value, "gearType");
            return (Criteria) this;
        }

        public Criteria andGearTypeLike(String value) {
            addCriterion("gear_type like", value, "gearType");
            return (Criteria) this;
        }

        public Criteria andGearTypeNotLike(String value) {
            addCriterion("gear_type not like", value, "gearType");
            return (Criteria) this;
        }

        public Criteria andGearTypeIn(List<String> values) {
            addCriterion("gear_type in", values, "gearType");
            return (Criteria) this;
        }

        public Criteria andGearTypeNotIn(List<String> values) {
            addCriterion("gear_type not in", values, "gearType");
            return (Criteria) this;
        }

        public Criteria andGearTypeBetween(String value1, String value2) {
            addCriterion("gear_type between", value1, value2, "gearType");
            return (Criteria) this;
        }

        public Criteria andGearTypeNotBetween(String value1, String value2) {
            addCriterion("gear_type not between", value1, value2, "gearType");
            return (Criteria) this;
        }

        public Criteria andDischargeStandardIsNull() {
            addCriterion("discharge_standard is null");
            return (Criteria) this;
        }

        public Criteria andDischargeStandardIsNotNull() {
            addCriterion("discharge_standard is not null");
            return (Criteria) this;
        }

        public Criteria andDischargeStandardEqualTo(String value) {
            addCriterion("discharge_standard =", value, "dischargeStandard");
            return (Criteria) this;
        }

        public Criteria andDischargeStandardNotEqualTo(String value) {
            addCriterion("discharge_standard <>", value, "dischargeStandard");
            return (Criteria) this;
        }

        public Criteria andDischargeStandardGreaterThan(String value) {
            addCriterion("discharge_standard >", value, "dischargeStandard");
            return (Criteria) this;
        }

        public Criteria andDischargeStandardGreaterThanOrEqualTo(String value) {
            addCriterion("discharge_standard >=", value, "dischargeStandard");
            return (Criteria) this;
        }

        public Criteria andDischargeStandardLessThan(String value) {
            addCriterion("discharge_standard <", value, "dischargeStandard");
            return (Criteria) this;
        }

        public Criteria andDischargeStandardLessThanOrEqualTo(String value) {
            addCriterion("discharge_standard <=", value, "dischargeStandard");
            return (Criteria) this;
        }

        public Criteria andDischargeStandardLike(String value) {
            addCriterion("discharge_standard like", value, "dischargeStandard");
            return (Criteria) this;
        }

        public Criteria andDischargeStandardNotLike(String value) {
            addCriterion("discharge_standard not like", value, "dischargeStandard");
            return (Criteria) this;
        }

        public Criteria andDischargeStandardIn(List<String> values) {
            addCriterion("discharge_standard in", values, "dischargeStandard");
            return (Criteria) this;
        }

        public Criteria andDischargeStandardNotIn(List<String> values) {
            addCriterion("discharge_standard not in", values, "dischargeStandard");
            return (Criteria) this;
        }

        public Criteria andDischargeStandardBetween(String value1, String value2) {
            addCriterion("discharge_standard between", value1, value2, "dischargeStandard");
            return (Criteria) this;
        }

        public Criteria andDischargeStandardNotBetween(String value1, String value2) {
            addCriterion("discharge_standard not between", value1, value2, "dischargeStandard");
            return (Criteria) this;
        }

        public Criteria andSeatNumberIsNull() {
            addCriterion("seat_number is null");
            return (Criteria) this;
        }

        public Criteria andSeatNumberIsNotNull() {
            addCriterion("seat_number is not null");
            return (Criteria) this;
        }

        public Criteria andSeatNumberEqualTo(String value) {
            addCriterion("seat_number =", value, "seatNumber");
            return (Criteria) this;
        }

        public Criteria andSeatNumberNotEqualTo(String value) {
            addCriterion("seat_number <>", value, "seatNumber");
            return (Criteria) this;
        }

        public Criteria andSeatNumberGreaterThan(String value) {
            addCriterion("seat_number >", value, "seatNumber");
            return (Criteria) this;
        }

        public Criteria andSeatNumberGreaterThanOrEqualTo(String value) {
            addCriterion("seat_number >=", value, "seatNumber");
            return (Criteria) this;
        }

        public Criteria andSeatNumberLessThan(String value) {
            addCriterion("seat_number <", value, "seatNumber");
            return (Criteria) this;
        }

        public Criteria andSeatNumberLessThanOrEqualTo(String value) {
            addCriterion("seat_number <=", value, "seatNumber");
            return (Criteria) this;
        }

        public Criteria andSeatNumberLike(String value) {
            addCriterion("seat_number like", value, "seatNumber");
            return (Criteria) this;
        }

        public Criteria andSeatNumberNotLike(String value) {
            addCriterion("seat_number not like", value, "seatNumber");
            return (Criteria) this;
        }

        public Criteria andSeatNumberIn(List<String> values) {
            addCriterion("seat_number in", values, "seatNumber");
            return (Criteria) this;
        }

        public Criteria andSeatNumberNotIn(List<String> values) {
            addCriterion("seat_number not in", values, "seatNumber");
            return (Criteria) this;
        }

        public Criteria andSeatNumberBetween(String value1, String value2) {
            addCriterion("seat_number between", value1, value2, "seatNumber");
            return (Criteria) this;
        }

        public Criteria andSeatNumberNotBetween(String value1, String value2) {
            addCriterion("seat_number not between", value1, value2, "seatNumber");
            return (Criteria) this;
        }

        public Criteria andIsAllowLoanIsNull() {
            addCriterion("is_allow_loan is null");
            return (Criteria) this;
        }

        public Criteria andIsAllowLoanIsNotNull() {
            addCriterion("is_allow_loan is not null");
            return (Criteria) this;
        }

        public Criteria andIsAllowLoanEqualTo(Short value) {
            addCriterion("is_allow_loan =", value, "isAllowLoan");
            return (Criteria) this;
        }

        public Criteria andIsAllowLoanNotEqualTo(Short value) {
            addCriterion("is_allow_loan <>", value, "isAllowLoan");
            return (Criteria) this;
        }

        public Criteria andIsAllowLoanGreaterThan(Short value) {
            addCriterion("is_allow_loan >", value, "isAllowLoan");
            return (Criteria) this;
        }

        public Criteria andIsAllowLoanGreaterThanOrEqualTo(Short value) {
            addCriterion("is_allow_loan >=", value, "isAllowLoan");
            return (Criteria) this;
        }

        public Criteria andIsAllowLoanLessThan(Short value) {
            addCriterion("is_allow_loan <", value, "isAllowLoan");
            return (Criteria) this;
        }

        public Criteria andIsAllowLoanLessThanOrEqualTo(Short value) {
            addCriterion("is_allow_loan <=", value, "isAllowLoan");
            return (Criteria) this;
        }

        public Criteria andIsAllowLoanIn(List<Short> values) {
            addCriterion("is_allow_loan in", values, "isAllowLoan");
            return (Criteria) this;
        }

        public Criteria andIsAllowLoanNotIn(List<Short> values) {
            addCriterion("is_allow_loan not in", values, "isAllowLoan");
            return (Criteria) this;
        }

        public Criteria andIsAllowLoanBetween(Short value1, Short value2) {
            addCriterion("is_allow_loan between", value1, value2, "isAllowLoan");
            return (Criteria) this;
        }

        public Criteria andIsAllowLoanNotBetween(Short value1, Short value2) {
            addCriterion("is_allow_loan not between", value1, value2, "isAllowLoan");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNull() {
            addCriterion("is_del is null");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNotNull() {
            addCriterion("is_del is not null");
            return (Criteria) this;
        }

        public Criteria andIsDelEqualTo(Integer value) {
            addCriterion("is_del =", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotEqualTo(Integer value) {
            addCriterion("is_del <>", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThan(Integer value) {
            addCriterion("is_del >", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_del >=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThan(Integer value) {
            addCriterion("is_del <", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThanOrEqualTo(Integer value) {
            addCriterion("is_del <=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelIn(List<Integer> values) {
            addCriterion("is_del in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotIn(List<Integer> values) {
            addCriterion("is_del not in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelBetween(Integer value1, Integer value2) {
            addCriterion("is_del between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotBetween(Integer value1, Integer value2) {
            addCriterion("is_del not between", value1, value2, "isDel");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}