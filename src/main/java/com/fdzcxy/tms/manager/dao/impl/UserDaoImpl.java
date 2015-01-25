/*
 * Copyright (c) 2014 FDZCXY Teaching Management System. All rights
 * reserved.
 * For more information, please see http://www.fdzcxy.com/
 */
package com.fdzcxy.tms.manager.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fdzcxy.tms.manager.common.CommonDaoSupport;
import com.fdzcxy.tms.manager.dao.UserDao;
import com.fdzcxy.tms.manager.model.User;

/**
 * 用户Dao实现
 * 
 * @author fzhong
 * @date 2014年8月1日
 * @version 1.0
 */
@Service("userDao")
public class UserDaoImpl extends CommonDaoSupport implements UserDao {

	public void addUser(User user) {
		this.save(user);
	}

	@SuppressWarnings("unchecked")
	public User findByUserName(String userName) throws Exception {
		String hql = " from com.fdzcxy.tms.manager.model.User u where u.userName = ?";
		List<User> list = this.find(hql, userName);
		if (list.size() <= 0) {
			throw new Exception("用户不存在");
		}
		return list.get(0);
	}
}
