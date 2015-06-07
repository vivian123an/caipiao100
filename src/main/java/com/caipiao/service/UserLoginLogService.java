package com.caipiao.service;

import java.sql.SQLException;

import com.caipiao.entity.UserLoginLog;

public interface UserLoginLogService {

	void saveUserLoginLog(UserLoginLog entity) throws SQLException;
}
