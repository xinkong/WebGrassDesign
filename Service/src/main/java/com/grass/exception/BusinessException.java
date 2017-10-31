package com.grass.exception;

/**
 * 系统业务异常
 * @author huchao
 */
public class BusinessException extends RuntimeException {

	private String returnCode;

	public BusinessException() {
		super();
	}

	public BusinessException(String returnCode) {
		super(returnCode);
		this.returnCode = returnCode;
	}

	public BusinessException(String code, String message) {
		super(message);
		this.returnCode = code;
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(String code, String message, Throwable cause) {
		super(message, cause);
		this.returnCode = code;
	}

	public String getCode() {
		return returnCode;
	}

	public void setCode(String code) {
		this.returnCode = code;
	}

}
