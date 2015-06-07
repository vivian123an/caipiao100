package com.caipiao.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.caipiao.dbutil.HumpPropertyBeanProcessor;
import com.caipiao.entity.User;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static ResultSetHandler<User> rsh = 
    		new BeanHandler<User>(User.class,new BasicRowProcessor(new HumpPropertyBeanProcessor()));
	
	@Override
	public User findUserByName(String username) {
		QueryRunner qr = new QueryRunner();
        StringBuilder sql = new StringBuilder("select * from member_user where 1=1 ");
        List<Object> params = new ArrayList<Object>();
        if(!StringUtils.isEmpty(username)){
        	sql.append(" and user_name = ?");
        	params.add(username);
        }
        try {
			return qr.query(jdbcTemplate.getDataSource().getConnection(), sql.toString(),rsh,params.toArray());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
