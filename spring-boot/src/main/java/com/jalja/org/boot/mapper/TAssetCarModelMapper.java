package com.jalja.org.boot.mapper;

import com.jalja.org.boot.model.TAssetCarModel;
import com.jalja.org.boot.model.TAssetCarModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TAssetCarModelMapper {
    long countByExample(TAssetCarModelExample example);

    int deleteByExample(TAssetCarModelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TAssetCarModel record);

    int insertSelective(TAssetCarModel record);

    List<TAssetCarModel> selectByExampleWithBLOBs(TAssetCarModelExample example);

    List<TAssetCarModel> selectByExample(TAssetCarModelExample example);

    TAssetCarModel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TAssetCarModel record, @Param("example") TAssetCarModelExample example);

    int updateByExampleWithBLOBs(@Param("record") TAssetCarModel record, @Param("example") TAssetCarModelExample example);

    int updateByExample(@Param("record") TAssetCarModel record, @Param("example") TAssetCarModelExample example);

    int updateByPrimaryKeySelective(TAssetCarModel record);

    int updateByPrimaryKeyWithBLOBs(TAssetCarModel record);

    int updateByPrimaryKey(TAssetCarModel record);
}