package com.jalja.org.boot.mapper;

import com.jalja.org.boot.model.TbArticle;
import com.jalja.org.boot.model.TbArticleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbArticleMapper {
    long countByExample(TbArticleExample example);

    int deleteByExample(TbArticleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbArticle record);

    int insertSelective(TbArticle record);

    List<TbArticle> selectByExampleWithBLOBs(TbArticleExample example);

    List<TbArticle> selectByExample(TbArticleExample example);

    TbArticle selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbArticle record, @Param("example") TbArticleExample example);

    int updateByExampleWithBLOBs(@Param("record") TbArticle record, @Param("example") TbArticleExample example);

    int updateByExample(@Param("record") TbArticle record, @Param("example") TbArticleExample example);

    int updateByPrimaryKeySelective(TbArticle record);

    int updateByPrimaryKeyWithBLOBs(TbArticle record);

    int updateByPrimaryKey(TbArticle record);
}