package com.ktds.movie.user.service;

import com.ktds.movie.user.vo.UserVO;

public interface UserService {
	public boolean checkOneAccount(String userId);
	public boolean insertNewUser(UserVO newUserVO);
}
