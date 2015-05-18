package com.caipiao.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.caipiao.dbutil.HumpPropertyBeanProcessor;
import com.caipiao.entity.FootballMatch;

@Service("footballMatchService")
public class FootballMatchServiceImpl implements FootballMatchService{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static ResultSetHandler<List<FootballMatch>> rsh = 
    		new BeanListHandler<FootballMatch>(FootballMatch.class, 
    				new BasicRowProcessor(new HumpPropertyBeanProcessor()));
	
	private static ResultSetHandler<List<Map<String,Object>>> rsh_map = new MapListHandler();

	@Override
    public List<FootballMatch> queryFootballMatchOld(FootballMatch footballMatchQuery){
    	
    	QueryRunner qr = new QueryRunner();
        String sql = "select * from football_match where type_code='jczq-bqc' ";
        try {
			return qr.query(jdbcTemplate.getDataSource().getConnection(),sql, rsh);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return null;
    }
	
    @Override
	public List<Map<String,Object>> queryFootballMatch(FootballMatch footballMatchQuery){
		
		QueryRunner qr = new QueryRunner();
		String sql = "select * from football_match where type_code='jczq-bqc' ";
		try {
			return qr.query(jdbcTemplate.getDataSource().getConnection(),sql, rsh_map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}