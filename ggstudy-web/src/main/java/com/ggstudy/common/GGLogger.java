package com.ggstudy.common;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class GGLogger {
	private Logger logger =null;
	public GGLogger(Class<?> logClass) {
		logger = LoggerFactory.getLogger(logClass);
	}

	public static final String LOG_FORMAT = "[{}] :{}";

	public boolean isDebugEnabled() {
		return logger.isDebugEnabled();
	}

	public boolean isInfoEnabled() {
		return logger.isInfoEnabled();
	}

	public boolean isErrorEnabled() {
		return logger.isErrorEnabled();
	}

	public boolean isWarnEnabled() {
		return logger.isWarnEnabled();
	}

	public boolean isTraceEnabled() {
		return logger.isTraceEnabled();
	}

	
	public void info(String code, Object message) {
		if (logger.isInfoEnabled())
			logger.info(LOG_FORMAT, code, message);
	}

	public void info(String code) {
		if (logger.isInfoEnabled())
			logger.info(LOG_FORMAT, code, null);
	}

	public void error(Throwable t) {
		if (logger.isErrorEnabled())
			logger.error("[" + BaseConstants.APP_NAME + "]", t);
	}

	public void debug(Throwable t) {
		if (logger.isDebugEnabled())
			logger.debug("[" + BaseConstants.APP_NAME + "]", t);
	}

	public void info(String code, Object message, Throwable t) {
		if (logger.isInfoEnabled())
			logger.info("[" + BaseConstants.APP_NAME + "] [" + code + "] :" + message, t);
	}

	public void debug(String code, Object message) {
		if (logger.isDebugEnabled())
			logger.debug(LOG_FORMAT, BaseConstants.APP_NAME, code, message);
	}

	public void error(String code) {
		if (logger.isErrorEnabled())
			logger.error(LOG_FORMAT, BaseConstants.APP_NAME, code, null);
	}

	public void debug(String code, Object message, Throwable t) {
		if (logger.isDebugEnabled())
			logger.debug("[" + BaseConstants.APP_NAME + "] [" + code + "] :" + message, t);
	}

	public void debug(String message) {
		if (logger.isDebugEnabled())
			logger.debug(message);
	}
	public void error(String code, Object message) {
		if (logger.isErrorEnabled())
			logger.error(LOG_FORMAT, BaseConstants.APP_NAME, code, message);
	}

	public void error(String code, Object message, Throwable t) {
		if (logger.isErrorEnabled())
			logger.error("[" + BaseConstants.APP_NAME + "] [" + code + "] :" + message, t);
	}

	public void warn(String code, Object message) {
		if (logger.isWarnEnabled())
			logger.warn(LOG_FORMAT, BaseConstants.APP_NAME, code, message);
	}

	public void warn(String code) {
		if (logger.isWarnEnabled())
			logger.warn(LOG_FORMAT, BaseConstants.APP_NAME, code, null);
	}

	public void warn(String code, Object message, Throwable t) {
		if (logger.isWarnEnabled())
			logger.warn("[" + BaseConstants.APP_NAME + "] [" + code + "] :" + message, t);
	}

	public void trace(String code, Object message) {
		if (logger.isTraceEnabled())
			logger.trace(LOG_FORMAT, BaseConstants.APP_NAME, code, message);
	}

	public void trace(String code, Object message, Throwable t) {
		if (logger.isTraceEnabled())
			logger.trace("[" + BaseConstants.APP_NAME + "] [" + code + "] :" + message, t);
	}
}
