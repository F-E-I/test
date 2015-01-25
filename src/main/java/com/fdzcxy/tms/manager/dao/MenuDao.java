/*
 * Copyright (c) 2014 FDZCXY Teaching Management System. All rights
 * reserved.
 * 
 * For more information, please see http://www.fdzcxy.com/
 */
package com.fdzcxy.tms.manager.dao;

import java.util.List;

import com.fdzcxy.tms.manager.model.Menu;

/**
 * �˵�DAO�ӿ�
 *
 * @author fzhong
 * @date 2014��9��20��
 * @version 1.0
 */
public interface MenuDao {

	public List<Menu> findAll();

	public List<Menu> findByParent(Integer parentId);

}
