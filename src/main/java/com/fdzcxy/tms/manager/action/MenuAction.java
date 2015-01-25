/*
 * Copyright (c) 2014 FDZCXY Teaching Management System. All rights
 * reserved.
 * 
 * For more information, please see http://www.fdzcxy.com/
 */
package com.fdzcxy.tms.manager.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.fdzcxy.tms.manager.model.Menu;
import com.fdzcxy.tms.manager.service.MenuService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Menu Action
 *
 * @author fzhong
 * @date 2014Äê9ÔÂ21ÈÕ
 * @version 1.0
 */
@ParentPackage("tms-default")
@Namespace("/jsp")
@Action("menu")
@Results({ @Result(name = "json", type = "json"),
		@Result(name = "index", location = "menu/index.jsp") })
public class MenuAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private static final String JSON = "json";
	private static final String INDEX = "index";

	@Resource(name = "menuService")
	private MenuService menuService;

	private Integer parentId;

	private List<Menu> subMenuList;

	private List<Menu> menuList;

	public String findSubMenu() {
		subMenuList = menuService.findSubMenuByParentId(parentId);
		return JSON;
	}

	public String manager() {
		menuList = menuService.findAllMenus();
		return INDEX;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public List<Menu> getSubMenuList() {
		return subMenuList;
	}

	public void setSubMenuList(List<Menu> subMenuList) {
		this.subMenuList = subMenuList;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

}
