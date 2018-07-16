package com.jalja.org.quartz.mapper;

import com.jalja.org.quartz.model.JaljaUser;
import com.jalja.org.quartz.model.JaljaUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JaljaUserMapper {
    long countByExample(JaljaUserExample example);

    int deleteByExample(JaljaUserExample example);

    int insert(JaljaUser record);

    int insertSelective(JaljaUser record);

    List<JaljaUser> selectByExample(JaljaUserExample example);

    int updateByExampleSelective(@Param("record") JaljaUser record, @Param("example") JaljaUserExample example);

    int updateByExample(@Param("record") JaljaUser record, @Param("example") JaljaUserExample example);
}