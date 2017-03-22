package com.ktds.movie.user.biz;

import com.ktds.movie.user.dao.UserDao;
import com.ktds.movie.user.dao.UserDaoImpl;
import com.ktds.movie.user.vo.UserVO;

public class UserBizImpl implements UserBiz{

	private UserDao userDao;
	
	public UserBizImpl() {
		userDao = new UserDaoImpl();
	}
	
	@Override
	public boolean checkOneAccount(String userId) {
		return userDao.checkOneAccount(userId) > 0;
	}

	@Override
	public boolean insertNewUser(UserVO newUserVO) {
		return userDao.insertNewUser(newUserVO) > 0;
	}

}
