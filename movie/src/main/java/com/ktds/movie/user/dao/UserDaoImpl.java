package com.ktds.movie.user.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ktds.movie.common.web.dao.JdbcDaoSupport;
import com.ktds.movie.user.vo.UserSearchVO;
import com.ktds.movie.user.vo.UserVO;

public class UserDaoImpl implements UserDao {

	@Override
	public int insertNewUser(UserVO newUserVO) {
		
		return 0;
	}

	@Override
	public List<UserVO> selectAllUser(UserSearchVO userSearchVO) {
		return null;
	}

	@Override
	public UserVO selectOneUser(String userId) {
		return null;
	}

	@Override
	public UserVO selectOneUser(UserVO userVO) {
		
		JdbcDaoSupport jds = new JdbcDaoSupport() {
			
			@Override
			public String query() {
				StringBuffer query = new StringBuffer();
				
				query.append("	SELECT  USR_ID        ");
				query.append("		, USR_NM        ");
				query.append("		, USR_PW        ");
				query.append("	FROM USR              ");
				query.append("	WHERE USR_ID = ?      ");
				query.append("	AND   USR_PW = ?      ");
				
				return query().toString();
					    
				
			}
			
			@Override
			public void mappingParms(PreparedStatement stmt) throws SQLException {
				
			}
			
			@Override
			public Object bindData(ResultSet rs) throws SQLException {
				UserVO userVO = new UserVO();
				bindData(rs);
				
				return userVO;
			}
		};
		return userVO;
		
		
	}

	@Override
	public int updateUserInfo(UserVO userVO) {
		return 0;
	}

	@Override
	public int deleteOneUser(String userId) {
		return 0;
	}

	@Override
	public int selectAllUserCount(UserSearchVO userSearchVO) {
		return 0;
	}

}
