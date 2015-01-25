package com.fdzcxy.tms.manager.common;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * TODO description
 * 
 * @author zhongf
 * @date 2014-9-19
 */
public class SimpleSerialIdGenerator {

	private long maxValue;

	private final Map<Object, AtomicLong> valueMap = new HashMap<Object, AtomicLong>();

	public SimpleSerialIdGenerator(long maxValue) {
		this.maxValue = maxValue;
	}

	public long getMaxValue() {
		return this.maxValue;
	}

	private Long getSerialId(Object seed) {
		AtomicLong value = null;
		synchronized (valueMap) {
			value = valueMap.get(seed);
			if (value == null) {
				value = new AtomicLong(0);
				valueMap.put(seed, value);
			}
		}
		synchronized (value) {
			long l = value.addAndGet(1);
			if (l >= maxValue) {
				value.set(0);
			}
			return l;
		}
	}

	public void clear(Object seed) {
		synchronized (valueMap) {
			AtomicLong value = valueMap.get(seed);
			if (value == null || value.get() == 0) {
				return;
			} else {
				valueMap.put(seed, new AtomicLong(0));
			}
		}
	}

	public Long getId(Object seed) {
		return getSerialId(seed);
	}

	public void clearAll() {
		synchronized (valueMap) {
			valueMap.clear();
		}
	}
}
