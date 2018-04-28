package com.jalja.org.boot.mapper;

import com.jalja.org.boot.model.TbAccount;
import com.jalja.org.boot.model.TbAccountExample;
import com.jalja.org.boot.model.vo.AccountVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbAccountMapper {
    long countByExample(TbAccountExample example);

    int deleteByExample(TbAccountExample example);

    int insert(TbAccount record);

    int insertSelective(TbAccount record);

    List<TbAccount> selectByExample(TbAccountExample example);

    int updateByExampleSelective(@Param("record") TbAccount record, @Param("example") TbAccountExample example);

    int updateByExample(@Param("record") TbAccount record, @Param("example") TbAccountExample example);

	void updateBalanceByaccountNo(AccountVo account);
}