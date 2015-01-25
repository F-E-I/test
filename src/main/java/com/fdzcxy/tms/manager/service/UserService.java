package com.fdzcxy.tms.manager.service;

import com.fdzcxy.tms.manager.model.User;

/**
 * 用户服务接口
 * 
 * @author zhongf
 * @date 2014-8-7
 */
public interface UserService {

	/**
	 * 用户信息校验
	 * 
	 * @param user
	 * @return 错误信息，返回<code>null</code>表示校验成功
	 */
	public String checkUser(User user);
}
