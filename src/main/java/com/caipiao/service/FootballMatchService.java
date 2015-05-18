package com.caipiao.service;

import java.util.List;
import java.util.Map;

import com.caipiao.entity.FootballMatch;

public interface FootballMatchService {

    public List<FootballMatch> queryFootballMatchOld(FootballMatch footballMatchQuery);
    
    public List<Map<String,Object>> queryFootballMatch(FootballMatch footballMatchQuery);
}
