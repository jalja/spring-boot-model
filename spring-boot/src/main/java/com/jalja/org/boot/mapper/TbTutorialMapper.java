package com.jalja.org.boot.mapper;

import com.jalja.org.boot.model.TbTutorial;
import com.jalja.org.boot.model.TbTutorialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbTutorialMapper {
    long countByExample(TbTutorialExample example);

    int deleteByExample(TbTutorialExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbTutorial record);

    int insertSelective(TbTutorial record);

    List<TbTutorial> selectByExample(TbTutorialExample example);

    TbTutorial selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbTutorial record, @Param("example") TbTutorialExample example);

    int updateByExample(@Param("record") TbTutorial record, @Param("example") TbTutorialExample example);

    int updateByPrimaryKeySelective(TbTutorial record);

    int updateByPrimaryKey(TbTutorial record);
}