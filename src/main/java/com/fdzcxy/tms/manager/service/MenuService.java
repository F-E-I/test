/*
 * Copyright (c) 2014 FDZCXY Teaching Management System. All rights
 * reserved.
 * 
 * For more information, please see http://www.fdzcxy.com/
 */
package com.fdzcxy.tms.manager.service;

import java.util.List;

import com.fdzcxy.tms.manager.model.Menu;

/**
 * 菜单服务接口
 *
 * @author fzhong
 * @date 2014年9月20日
 * @version 1.0
 */
public interface MenuService {

	public List<Menu> findAllMenus();

	public List<Menu> findMainMenus();

	public List<Menu> findSubMenuByParentId(Integer parentId);

}
