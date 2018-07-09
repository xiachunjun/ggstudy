package com.ggstudy.common;

public class GGException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Exception exception = null;
	private String errCode;
	private String errMsg;

	public GGException() {
	}

	/**
	 * 只有一个字符串信息时使用
	 * 
	 * @param errStr
	 */
	public GGException(String errStr) {
		this.errCode = errStr;
	}

	/**
	 * 有code和msg时使用
	 * 
	 * @param errCode
	 * @param errMsg
	 */
	public GGException(String errCode, String errMsg) {
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	/**
	 * 需要保留原始异常时使用
	 * 
	 * @param errCode
	 * @param errMsg
	 * @param e
	 */
	public GGException(String errCode, String errMsg, Exception e) {
		this.errCode = errCode;
		this.errMsg = errMsg;
		this.exception = e;
	}
	/**
	 * 需要保留原始异常时使用
	 * 
	 * @param errStr
	 * @param e
	 */
	public GGException(String errStr, Exception e) {
		this.errCode = errStr;
		this.exception = e;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception e) {
		this.exception = e;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
}
