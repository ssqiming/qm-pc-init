package com.qm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qm.dao.BdUserDao;
import com.qm.domain.entity.BdUser;

@Service
public class UserService {

	@Autowired
	private BdUserDao userDao;
	
	/**
	 * 
	* @Description: 添加用户
	* @param user
	* @return
	* @author: qiming
	* @date: 2016年5月18日 下午4:33:42
	* @throws
	 */
	public int insertSelective(BdUser user) {
		return userDao.insertSelective(user);
	}
}
