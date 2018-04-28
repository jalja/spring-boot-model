package com.jalja.org.boot.mapper;

import com.jalja.org.boot.model.TbLogs;
import com.jalja.org.boot.model.TbLogsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbLogsMapper {
    long countByExample(TbLogsExample example);

    int deleteByExample(TbLogsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbLogs record);

    int insertSelective(TbLogs record);

    List<TbLogs> selectByExample(TbLogsExample example);

    TbLogs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbLogs record, @Param("example") TbLogsExample example);

    int updateByExample(@Param("record") TbLogs record, @Param("example") TbLogsExample example);

    int updateByPrimaryKeySelective(TbLogs record);

    int updateByPrimaryKey(TbLogs record);
}