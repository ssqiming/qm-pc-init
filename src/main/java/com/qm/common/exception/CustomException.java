package com.qm.common.exception;

/** 
 * @ClassName: CustomException 
 * @Description: 自定义异常基础类
 * @author caizhen
 * @date 2015年6月24日 下午4:36:08  
 */
public class CustomException extends RuntimeException{

	/**
	 * 
	 */
	public CustomException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public CustomException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public CustomException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public CustomException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public CustomException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	 

}
