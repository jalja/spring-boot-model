package com.jalja.org.boot.mapper;

import com.jalja.org.boot.model.TAssetCarBrand;
import com.jalja.org.boot.model.TAssetCarBrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TAssetCarBrandMapper {
    long countByExample(TAssetCarBrandExample example);

    int deleteByExample(TAssetCarBrandExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TAssetCarBrand record);

    int insertSelective(TAssetCarBrand record);

    List<TAssetCarBrand> selectByExample(TAssetCarBrandExample example);

    TAssetCarBrand selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TAssetCarBrand record, @Param("example") TAssetCarBrandExample example);

    int updateByExample(@Param("record") TAssetCarBrand record, @Param("example") TAssetCarBrandExample example);

    int updateByPrimaryKeySelective(TAssetCarBrand record);

    int updateByPrimaryKey(TAssetCarBrand record);
}