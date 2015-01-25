/*
 * Copyright (c) 2014 FDZCXY Teaching Management System. All rights
 * reserved.
 * 
 * For more information, please see http://www.fdzcxy.com/
 */
package com.fdzcxy.tms.manager.common;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 公共DAO实现
 *
 * @author fzhong
 * @date 2014年9月20日
 * @version 1.0
 */
public abstract class CommonDaoSupport extends HibernateDaoSupport {

	@Resource(name = "sessionFactory")
	public void setInjectSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	public void save(Object entity) {
		getHibernateTemplate().save(entity);
	}

	public void saveOrUpdate(Object entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	@SuppressWarnings("rawtypes")
	public List find(String queryString, Object... values) {
		return getHibernateTemplate().find(queryString, values);
	}
}
