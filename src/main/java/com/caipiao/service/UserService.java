package com.caipiao.service;

import com.caipiao.entity.User;

public interface UserService {

	User findUserByName(String username);
}
