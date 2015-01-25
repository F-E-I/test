/*
 * Copyright (c) 2014 FDZCXY Teaching Management System. All rights
 * reserved.
 * 
 * For more information, please see http://www.fdzcxy.com/
 */
package com.fdzcxy.tms.manager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 菜单模型
 *
 * @author fzhong
 * @date 2014年9月20日
 * @version 1.0
 */
@Entity
@Table(name = "MENU")
public class Menu {

	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "MENUNAME")
	private String menuName;

	@Column(name = "URL")
	private String url;

	@Column(name = "PARENT_ID")
	private int parentId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

}
