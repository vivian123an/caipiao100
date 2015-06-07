package com.caipiao.entity;

import java.util.Date;
/**
 * 系统用户登陆日志
 * @author Jeff Xu
 *
 */
public class UserLoginLog{

	private String typeCode;
	private String loginIp;
	private Date createDate;
	private String username;

	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
