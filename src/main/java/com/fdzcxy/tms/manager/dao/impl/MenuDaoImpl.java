/*
 * Copyright (c) 2014 FDZCXY Teaching Management System. All rights
 * reserved.
 * 
 * For more information, please see http://www.fdzcxy.com/
 */
package com.fdzcxy.tms.manager.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fdzcxy.tms.manager.common.CommonDaoSupport;
import com.fdzcxy.tms.manager.dao.MenuDao;
import com.fdzcxy.tms.manager.model.Menu;

/**
 * 菜单DAO实现
 *
 * @author fzhong
 * @date 2014年9月20日
 * @version 1.0
 */
@Service("menuDao")
public class MenuDaoImpl extends CommonDaoSupport implements MenuDao {

	@SuppressWarnings("unchecked")
	public List<Menu> findAll() {
		String hql = " from com.fdzcxy.tms.manager.model.Menu";
		List<Menu> list = this.find(hql);
		if (list.size() <= 0) {
			return null;
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Menu> findByParent(Integer parentId) {
		String hql = " from com.fdzcxy.tms.manager.model.Menu m where m.parentId = ?";
		List<Menu> list = this.find(hql, parentId);
		if (list.size() <= 0) {
			return null;
		}
		return list;
	}
}
