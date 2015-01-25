/*
 * Copyright (c) 2014 FDZCXY Teaching Management System. All rights
 * reserved.
 * 
 * For more information, please see http://www.fdzcxy.com/
 */
package com.fdzcxy.tms.manager.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.fdzcxy.tms.manager.common.Const;
import com.fdzcxy.tms.manager.dao.MenuDao;
import com.fdzcxy.tms.manager.model.Menu;
import com.fdzcxy.tms.manager.service.MenuService;

/**
 * �˵�����ӿ�ʵ��
 *
 * @author fzhong
 * @date 2014��9��20��
 * @version 1.0
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {

	private static Logger logger = Logger.getLogger(MenuServiceImpl.class);

	@Resource(name = "menuDao")
	private MenuDao menuDao;

	public List<Menu> findAllMenus() {
		List<Menu> list = null;
		try {
			list = menuDao.findAll();
		} catch (Exception e) {
			logger.error("�������в˵�ʧ��", e);
		}
		return list;
	}

	public List<Menu> findMainMenus() {
		return findSubMenuByParentId(Const.MEMU_MAIN_ID);
	}

	public List<Menu> findSubMenuByParentId(Integer parentId) {
		List<Menu> list = null;
		try {
			list = menuDao.findByParent(parentId);
			if (list == null) {
				logger.info("δ�ҵ�[parentId=" + parentId + "]���Ӳ˵�");
			}
		} catch (Exception e) {
			logger.error("����[parentId=" + parentId + "]���Ӳ˵�ʧ��", e);
		}
		return list;
	}
}
