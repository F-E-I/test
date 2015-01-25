/*
 * Copyright (c) 2014 FDZCXY Teaching Management System. All rights
 * reserved.
 * For more information, please see http://www.fdzcxy.com/
 */
package com.fdzcxy.tms.manager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User model
 * 
 * @author fzhong
 * @date 2014Äê7ÔÂ26ÈÕ
 * @version 1.0
 */
@Entity
@Table(name = "USER")
public class User {

	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "USERNAME")
	private String userName;

	@Column(name = "PASSWORD")
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
