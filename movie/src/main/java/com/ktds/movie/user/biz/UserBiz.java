package com.ktds.movie.user.biz;

import com.ktds.movie.user.vo.UserVO;

public interface UserBiz {
	public boolean checkOneAccount(String userId);
	public boolean insertNewUser(UserVO newUserVO);
}
