package com.caipiao.service;

import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.caipiao.entity.UserLoginLog;

@Service("userLoginLogService")
public class UserLoginLogServiceImpl implements UserLoginLogService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void saveUserLoginLog(UserLoginLog entity) throws SQLException {
		QueryRunner run = new QueryRunner(jdbcTemplate.getDataSource());
		run.update( "insert into user_login_log (user_name,create_date,login_ip,type_code) VALUES (?,?,?,?)",
					entity.getUsername(),new Date(), entity.getLoginIp(),entity.getTypeCode());
		
	}
}
