package com.huarui.product2020.entity;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * 统一返回结果类
 *
 * @author DongJie
 * @since 2017年8月31日
 */
public class ResultEntity implements Serializable {

	/** 错误返回值*/
	public final static int ERROR_CODE = 0; 
	
	/** 正确返回值*/
	public final static int RIGHT_CODE = 200; 
	
	/** Token错误返回值*/
	public final static int TOKEN_CODE = HttpStatus.UNAUTHORIZED.value();
	
	/** 数据正确与否标识 */
	private int code = 200;
	
	/** 错误信息 */
	private String errorMsg;
	
	/**
	 * 错误代码信息
	 */
	private String errorCode;
	
	/** 返回数据 */
	private Object data;
	
	public ResultEntity() {
	}
	
	public ResultEntity(int code, String errorMsg) {
		this.code = code;
		this.errorMsg = errorMsg;
	}

	public ResultEntity(int code, String errorMsg, Object data) {
		this.code = code;
		this.errorMsg = errorMsg;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.code = this.ERROR_CODE;
		this.errorMsg = errorMsg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
}
