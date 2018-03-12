package com.dlf.garment3.util;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class JSONResult<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7424426799887924229L;
	
	@ApiModelProperty(value = "错误码")
	private String code;
	
	@ApiModelProperty(value = "数据对象")
    private T data;
	
	@ApiModelProperty(value = "错误码描述")
	private String message;

	public JSONResult() {
	}
	
	public JSONResult(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public JSONResult(SimpleCode simpleCode) {
		this.code = simpleCode.getCode();
		this.message = simpleCode.getMessage();
	}
	
	public JSONResult(String code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
	public JSONResult(SimpleCode simpleCode, T data) {
		this.code = simpleCode.getCode();
		this.message = simpleCode.getMessage();
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "JSONResult [code=" + code + ", data=" + data + ", message="
				+ message + "]";
	}

}
