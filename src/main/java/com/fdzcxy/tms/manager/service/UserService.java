package com.fdzcxy.tms.manager.service;

import com.fdzcxy.tms.manager.model.User;

/**
 * �û�����ӿ�
 * 
 * @author zhongf
 * @date 2014-8-7
 */
public interface UserService {

	/**
	 * �û���ϢУ��
	 * 
	 * @param user
	 * @return ������Ϣ������<code>null</code>��ʾУ��ɹ�
	 */
	public String checkUser(User user);
}
