/*
 * Copyright (c) 2014 FDZCXY Teaching Management System. All rights
 * reserved.
 * For more information, please see http://www.fdzcxy.com/
 */
package com.fdzcxy.tms.manager.exception.base;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

/**
 * 系统变量
 * 
 * @author zhongf
 * @date 2015-1-20
 * @version 1.0
 */
public final class SystemProperty {

	private static Logger logger = LoggerFactory
			.getLogger(SystemProperty.class);

	private static SystemProperty instance;
	private static String RESOURCE_NAME = "system.properties";
	private static String KEY_SYSTEM_NAME = "systname";
	private static String KEY_HOST_NAME = "hostname";
	private static String MACHINE_ID = null;

	private Properties properties;
	private String hostname;

	public SystemProperty() {
		init();
	}

	public static SystemProperty getInstance() {
		if (instance == null) {
			instance = new SystemProperty();
		}
		return instance;
	}

	public String getSysName() {
		return getSystProperty(KEY_SYSTEM_NAME);
	}

	public String getSystProperty(String key) {
		if (properties == null)
			return getInnerSystProperty(key);
		String value = properties.getProperty(key);
		if (value == null) {
			return getInnerSystProperty(key);
		}
		return value;
	}

	public String getMachineID() {
		MACHINE_ID = this.getInnerSystProperty(KEY_HOST_NAME);
		if (MACHINE_ID == null) {
			if (this.hostname == null)
				this.hostname = getHostName();
			if (hostname != null) {
				try {
					MACHINE_ID = hostname
							.substring((hostname.length() < 2) ? 0 : (hostname
									.length() - 2));
				} catch (Exception e) {
					logger.error("get Machineid failed for:", e);
				}
			}
		}
		return MACHINE_ID;
	}

	private void init() {
		this.hostname = this.getHostName();
		if (properties == null) {
			URL url = getClassLoader().getResource(RESOURCE_NAME);
			if (url == null) {
				if (logger.isDebugEnabled())
					logger.debug("try to load syst-property from file:"
							+ RESOURCE_NAME + ",but not exists!");
				return;
			}

			if (logger.isDebugEnabled())
				logger.debug("try to load syst-property from file:"
						+ RESOURCE_NAME);

			try {
				InputStream is = url.openStream();
				properties = new Properties();
				properties.load(is);
			} catch (Exception e) {
				logger.error("load syst-property from file:" + RESOURCE_NAME
						+ " failed!the url is:" + url.toExternalForm(), e);
			}
		}
	}

	private String getHostName() {
		String hn = null;
		try {
			hn = InetAddress.getLocalHost().getHostName();
		} catch (Exception e) {
			logger.error("get Machineid failed for:", e);
		}
		return hn;
	}

	private ClassLoader getClassLoader() {
		try {
			return Thread.currentThread().getContextClassLoader();
		} catch (Exception e) {
		}
		return ResourceUtils.class.getClassLoader();
	}

	private String getInnerSystProperty(String key) {
		String value = System.getProperty(key);
		return value;
	}

}
