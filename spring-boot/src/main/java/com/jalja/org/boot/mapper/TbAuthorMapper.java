package com.jalja.org.boot.mapper;

import com.jalja.org.boot.model.TbAuthor;
import com.jalja.org.boot.model.TbAuthorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbAuthorMapper {
    long countByExample(TbAuthorExample example);

    int deleteByExample(TbAuthorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbAuthor record);

    int insertSelective(TbAuthor record);

    List<TbAuthor> selectByExample(TbAuthorExample example);

    TbAuthor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbAuthor record, @Param("example") TbAuthorExample example);

    int updateByExample(@Param("record") TbAuthor record, @Param("example") TbAuthorExample example);

    int updateByPrimaryKeySelective(TbAuthor record);

    int updateByPrimaryKey(TbAuthor record);
}