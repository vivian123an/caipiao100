package com.caipiao.web;

import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caipiao.entity.FootballMatch;
import com.caipiao.entity.User;
import com.caipiao.entity.UserLoginLog;
import com.caipiao.service.FootballMatchService;
import com.caipiao.service.UserLoginLogService;
import com.caipiao.service.UserService;
import com.caipiao.util.AddressUtils;
import com.caipiao.util.Md5Util;
import com.caipiao.util.ResultDto;

/**
 * @author pingan
 * @since  2015-06-07
 */

@Controller
@RequestMapping("/football")
public class FootballMatchController {

	@Autowired
	private FootballMatchService footballMatchService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserLoginLogService userLoginLogService;
	
	
	@RequestMapping(value="/matchList",produces={"application/json;charset=utf-8"})
	@ResponseBody
	public ResultDto<FootballMatch> matchList(FootballMatch queryDto,HttpServletRequest request){
		ResultDto<FootballMatch> result = new ResultDto<FootballMatch>();
		
		if(StringUtils.isEmpty(queryDto.getUserName())){
			result.setSuccess(false);
			result.setCode(ResultDto.NO_USERNAME_CODE);
			result.setMessage(ResultDto.NO_USERNAME_MESSAGE);
			return result;
		}
		if(StringUtils.isEmpty(queryDto.getPassword())){
			result.setSuccess(false);
			result.setCode(ResultDto.NO_PASSWORD_CODE);
			result.setMessage(ResultDto.NO_PASSWORD_MESSAGE);
			return result;
		}
		if(StringUtils.isEmpty(queryDto.getPdate())){
			result.setSuccess(false);
			result.setCode(ResultDto.NO_PDATE_CODE);
			result.setMessage(ResultDto.NO_PDATE_MESSAGE);
			return result;
		}
		if(StringUtils.isEmpty(queryDto.getTypeCode())){
			result.setSuccess(false);
			result.setCode(ResultDto.NO_TYPE_CODE);
			result.setMessage(ResultDto.NO_TYPE_MESSAGE);
			return result;
		}
		try {
			User user = userService.findUserByName(queryDto.getUserName());
			if(user != null){
				if(Md5Util.validatePassword(user.getPassword(), queryDto.getPassword())){
					insertLoginLog(queryDto,request);
				}else{
					result.setSuccess(false);
					result.setCode(ResultDto.PASSWORD_ERROR_CODE);
					result.setMessage(ResultDto.PASSWORD_ERROR_MESSAGE);
					return result;
				}
			}else{
				result.setSuccess(false);
				result.setCode(ResultDto.USERNAME_ERROR_CODE);
				result.setMessage(ResultDto.USERNAME_ERROR_MESSAGE);
				return result;
			}
			result.setList(footballMatchService.queryFootballMatchOld(queryDto));
			result.setSuccess(true);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setCode(ResultDto.SYSTEM_BUSY_CODE);
			result.setMessage(ResultDto.SYSTEM_BUSY_MESSAGE);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 保存用户登陆登出明细记录
	 * @param user
	 * @param event
	 * @throws SQLException 
	 */
	private void insertLoginLog(FootballMatch queryDto,HttpServletRequest request) throws SQLException{
		UserLoginLog userLoginLog = new UserLoginLog();
		userLoginLog.setTypeCode(queryDto.getTypeCode());
		userLoginLog.setLoginIp(AddressUtils.getIp(request));
		userLoginLog.setCreateDate(new Date());
		userLoginLog.setUsername(queryDto.getUserName());
		userLoginLogService.saveUserLoginLog(userLoginLog);
	}
}
