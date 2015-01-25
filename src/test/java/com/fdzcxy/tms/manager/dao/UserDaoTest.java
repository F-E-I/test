package com.fdzcxy.tms.manager.dao;

import org.junit.Test;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.fdzcxy.tms.manager.BaseTest;
import com.fdzcxy.tms.manager.model.User;

/**
 * TODO description
 * 
 * @author zhongf
 * @date 2014-8-7
 */
public class UserDaoTest extends BaseTest {

	@Test
	public void testUserDao() {
		User user = new User();
		user.setUserName("test");
		user.setPassword("test");
		HibernateTemplate hib = (HibernateTemplate) context
				.getBean("hibernateTemplate");
		hib.save(user);
	}
}
