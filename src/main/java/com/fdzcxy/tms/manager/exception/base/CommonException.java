/*
 * Copyright (c) 2014 FDZCXY Teaching Management System. All rights
 * reserved.
 * For more information, please see http://www.fdzcxy.com/
 */
package com.fdzcxy.tms.manager.exception.base;

/**
 * 异常公共类
 * 
 * @author zhongf
 * @date 2014-9-19
 * @version 1.0
 */
public class CommonException extends Exception implements Traceable,
		Describable {

	private static final long serialVersionUID = 1L;

	private final String code;

	private final long timestamp;

	private transient final Traceable parent;

	private String traceId;

	public CommonException(String code, String msg) {
		super(msg);
		this.code = code;
		timestamp = System.currentTimeMillis();
		parent = null;
	}

	public CommonException(String code, String msg, Throwable e) {
		super(msg, e);
		this.code = code;
		if (e instanceof Traceable) {
			parent = (Traceable) e;
			timestamp = ((Traceable) e).getTimestamp();
		} else {
			parent = null;
			timestamp = System.currentTimeMillis();
		}
	}

	public String getCode() {
		return code;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public String getTraceID() {
		if (traceId != null)
			return traceId;
		if (parent != null) {
			traceId = parent.getTraceID();
			return traceId;
		}
		try {
			traceId = ExceptionTraceIdGenerator.getInstance().getTraceId();
		} catch (Exception e) {
			traceId = null;
		}
		return traceId;
	}

	@Override
	public String toString() {
		String name = getClass().getName();
		String traceId = getTraceID();
		String code = getCode();
		String msg = getLocalizedMessage();

		StringBuilder sb = new StringBuilder();
		sb.append(name + ":");
		sb.append(traceId == null ? "" : "trace[" + traceId + "],");
		sb.append(code == null ? "" : "code[" + code + "],");
		sb.append(msg == null ? "" : "msg[" + msg + "]");

		return sb.toString();
	}
}
