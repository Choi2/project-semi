package com.ktds.movie.user.service;

import com.ktds.movie.user.biz.UserBiz;
import com.ktds.movie.user.biz.UserBizImpl;
import com.ktds.movie.user.vo.UserVO;


public class UserServiceImpl implements UserService{

	private UserBiz userBiz;
	
	public UserServiceImpl() {
		userBiz = new UserBizImpl();
	}
	
	@Override
	public boolean checkOneAccount(String userId) {
		return userBiz.checkOneAccount(userId);
	}

	@Override
	public boolean insertNewUser(UserVO newUserVO) {
		return userBiz.insertNewUser(newUserVO);
	}

}
