package com.ggstudy.springboot.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

public class AppLogger {

	// ========error=========
	public static void error(Object obj, String message) {
		error(obj.getClass(), message, null);
	}

	public static void error(Class<?> clazz, String message) {
		error(clazz, message, null);
	}

	public static void error(Object obj, String message, Throwable e) {
		error(obj.getClass(), message, null);
	}

	public static void error(Class<?> clazz, String message, Throwable e) {
		Logger logger = LoggerFactory.getLogger(clazz);
		if (logger.isErrorEnabled()) {
			if (e == null) {
				logger.error(message);
			} else {
				logger.error(message, e);
			}
		}
	}

	// =======info======
	public static void info(Class<?> clazz, String message) {
		Logger logger = LoggerFactory.getLogger(clazz);
		if (logger.isInfoEnabled()) {
			logger.info(message);
		}
	}

	public static void info(Object obj, String message) {
		info(obj.getClass(), message);
	}

	/**
	 * 用json记录日志
	 * 
	 * info级别
	 */
	public static void logJson(Class<?> clazz, String message, Object obj) {
		Logger logger = LoggerFactory.getLogger(clazz);
		try {
			logger.info(message + JSONObject.toJSONString(obj));
		} catch (Exception e) {
			// 记日志报错就不管了
		}
	}

	public static void logJson(Object clz, String message, Object obj) {
		logJson(clz.getClass(), message, obj);
	}
	// ==========debug=========

	public static void debug(Class<?> clazz, String message, Object... params) {
		Logger logger = LoggerFactory.getLogger(clazz);
		if (logger.isDebugEnabled()) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < params.length; i++) {
				sb.append("[PARAM_" + i + "]=");
				sb.append(String.valueOf(params[i]));
				sb.append(";");
			}
			logger.debug(message + sb.toString());
		}
	}

	public static void debug(Object obj, String message, Object... params) {
		debug(obj.getClass(), message, params);
	}

}
