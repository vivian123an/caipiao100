package com.caipiao.util;

import java.util.List;

/**
 * 用于web页面返回ajax结果
 * 
 * @author pingan
 * @since  2015-06-03
 * @param <T>
 */

public class ResultDto<T>{
	
	public static final String NO_SESSION_CODE = "100";
	public static final String NO_SESSION_MESSAGE = "session不存在,重新登录";
	
	public static final String NOT_RESGISTER_CODE = "150";
	public static final String NOT_RESGISTER_MESSAGE = "账号未注册，请先注册";
	
	
	public static final String LOGIN_SUCCESS = "200";
	public static final String NO_PDATE_CODE = "410";
	public static final String NO_PDATE_MESSAGE = "未设置pdate参数，请设置";
	public static final String NO_TYPE_CODE = "420";
	public static final String NO_TYPE_MESSAGE = "未设置typeCode参数，请设置";
	public static final String NO_USERNAME_CODE = "430";
	public static final String NO_USERNAME_MESSAGE = "未设置userName参数，请设置";
	public static final String NO_PASSWORD_CODE = "440";
	public static final String NO_PASSWORD_MESSAGE = "未设置password参数，请设置";
	
	
	
	public static final String SYSTEM_BUSY_CODE = "500";
	public static final String SYSTEM_BUSY_MESSAGE = "系统繁忙，请稍候再试";
	
	public final static String USERNAME_ERROR_CODE = "900";
	public final static String USERNAME_ERROR_MESSAGE = "账号错误";
	
	public final static String PASSWORD_ERROR_CODE = "910"; 
	public final static String PASSWORD_ERROR_MESSAGE = "密码错误";
	

	private boolean success;
	private String code;
	private String message;
	private List<T> list;//不分页集合
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	
}
