package com.caipiao.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caipiao.entity.FootballMatch;
import com.caipiao.service.FootballMatchService;

@Controller
@RequestMapping("/football")
public class FootballMatchController {

	@Autowired
	private FootballMatchService footballMatchService;
	
	@RequestMapping(value="/matchList",produces={"application/json;charset=utf-8"})
	@ResponseBody
	public List<FootballMatch> matchList(FootballMatch footballMatchQuery){
		return footballMatchService.queryFootballMatchOld(footballMatchQuery);
	}
}
