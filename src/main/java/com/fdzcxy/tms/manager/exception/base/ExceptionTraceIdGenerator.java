/*
 * Copyright (c) 2014 FDZCXY Teaching Management System. All rights
 * reserved.
 * For more information, please see http://www.fdzcxy.com/
 */
package com.fdzcxy.tms.manager.exception.base;

import java.util.Calendar;

import org.apache.commons.lang.StringUtils;

import com.fdzcxy.tms.manager.common.SimpleSerialIdGenerator;

/**
 * Òì³£×·×ÙÂëÉú³ÉÆ÷
 * 
 * @author zhongf
 * @date 2014-9-19
 * @version 1.0
 */
public class ExceptionTraceIdGenerator {

	private static final int ROLLSEED = 0xFFF;

	private final Object IDKEY = new Object();

	private SimpleSerialIdGenerator serialIdGenerator;

	private static ExceptionTraceIdGenerator traceIdGenerator;

	private ExceptionTraceIdGenerator() {
		serialIdGenerator = new SimpleSerialIdGenerator(ROLLSEED);
	}

	public static ExceptionTraceIdGenerator getInstance() {
		if (traceIdGenerator == null)
			traceIdGenerator = new ExceptionTraceIdGenerator();

		return traceIdGenerator;
	}

	public String getTraceId() {

		StringBuilder sb = new StringBuilder();

		String systname = SystemProperty.getInstance().getSysName();
		String machineid = SystemProperty.getInstance().getMachineID();

		String unknowndefault = "n/a";

		sb.append((systname == null ? unknowndefault : systname) + "-"
				+ (machineid == null ? unknowndefault : machineid) + "-");

		synchronized (IDKEY) {
			Calendar current = Calendar.getInstance();
			int curDate = current.get(Calendar.DAY_OF_YEAR);

			int curHour = current.get(Calendar.HOUR_OF_DAY);
			int _curHourLength = 5;

			int curMin = current.get(Calendar.MINUTE);
			int _curMinLength = 6;

			curDate <<= _curHourLength + _curMinLength;
			curHour <<= _curMinLength;

			int curStamp = curDate + curHour + curMin;

			String curStampHEX = Integer.toHexString(curStamp);
			curStampHEX = StringUtils.leftPad(curStampHEX, 5, "0");

			int result = (serialIdGenerator.getId(IDKEY)).intValue();
			String strSerial = Integer.toHexString(result);
			strSerial = StringUtils.leftPad(strSerial, 3, "0");

			sb.append(curStampHEX + "-" + strSerial);
		}

		return sb.toString().toUpperCase();
	}
}
