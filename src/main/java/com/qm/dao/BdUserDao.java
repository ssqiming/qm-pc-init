package com.qm.dao;

import com.qm.domain.entity.BdUser;

public interface BdUserDao {
    int deleteByPrimaryKey(Long id);

    int insert(BdUser record);

    int insertSelective(BdUser record);

    BdUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BdUser record);

    int updateByPrimaryKey(BdUser record);
}