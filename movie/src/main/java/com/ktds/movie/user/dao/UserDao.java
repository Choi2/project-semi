package com.ktds.movie.user.dao;

import java.util.List;

import com.ktds.movie.user.vo.UserSearchVO;
import com.ktds.movie.user.vo.UserVO;

public interface UserDao {
	
	public int insertNewUser(UserVO newUserVO);
	public List<UserVO>selectAllUser(UserSearchVO userSearchVO);
	
	public UserVO selectOneUser(String userId);
	
	public UserVO selectOneUser(UserVO userVO);
	public int updateUserInfo(UserVO userVO);
	public int deleteOneUser(String userId);
	public int selectAllUserCount(UserSearchVO userSearchVO);
	

}
