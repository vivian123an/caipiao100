package com.caipiao.dbutil;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class ConnectionUtil {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Connection getConnection(){
		try {
			return jdbcTemplate.getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
