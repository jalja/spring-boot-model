package com.jalja.org.boot.mapper;

import com.jalja.org.boot.model.TAssetCarSeries;
import com.jalja.org.boot.model.TAssetCarSeriesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TAssetCarSeriesMapper {
    long countByExample(TAssetCarSeriesExample example);

    int deleteByExample(TAssetCarSeriesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TAssetCarSeries record);

    int insertSelective(TAssetCarSeries record);

    List<TAssetCarSeries> selectByExampleWithBLOBs(TAssetCarSeriesExample example);

    List<TAssetCarSeries> selectByExample(TAssetCarSeriesExample example);

    TAssetCarSeries selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TAssetCarSeries record, @Param("example") TAssetCarSeriesExample example);

    int updateByExampleWithBLOBs(@Param("record") TAssetCarSeries record, @Param("example") TAssetCarSeriesExample example);

    int updateByExample(@Param("record") TAssetCarSeries record, @Param("example") TAssetCarSeriesExample example);

    int updateByPrimaryKeySelective(TAssetCarSeries record);

    int updateByPrimaryKeyWithBLOBs(TAssetCarSeries record);

    int updateByPrimaryKey(TAssetCarSeries record);
}