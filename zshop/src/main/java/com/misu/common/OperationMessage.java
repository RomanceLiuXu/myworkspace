package com.misu.common;

import org.springframework.stereotype.Component;

/**
 * 操作返回信息
 * 
 * @author LiuXu
 * @version 2018年10月2日下午3:57:48
 */
@Component("OperationMessage")
public class OperationMessage {

	private int status;// 操作状态
	private String message;// 成功提示消息
	
	
	@Override
	public String toString() {
		return "OperationMessage [status=" + status + ", message=" + message + "]";
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
