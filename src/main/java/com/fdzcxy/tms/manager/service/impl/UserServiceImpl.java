package com.fdzcxy.tms.manager.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.fdzcxy.tms.manager.dao.UserDao;
import com.fdzcxy.tms.manager.model.User;
import com.fdzcxy.tms.manager.service.UserService;

/**
 * 用户服务接口实现
 * 
 * @author zhongf
 * @date 2014-8-7
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	private static Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Resource(name = "userDao")
	private UserDao userDao;

	public String checkUser(User user) {
		String pwd = user.getPassword();
		try {
			user = userDao.findByUserName(user.getUserName());
			if (!user.getPassword().equals(pwd)) {
				return "用户名或密码错误";
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return e.getMessage();
		}
		return null;
	}
}
