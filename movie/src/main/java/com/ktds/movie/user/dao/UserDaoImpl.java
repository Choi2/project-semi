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
		
		JdbcDaoSupport jds = new JdbcDaoSupport() {

			@Override
			public String query() {
				
				StringBuffer query = new StringBuffer();
				
				query.append("	INSERT	INTO	USR			");
				query.append("	(            	USR_ID  	");
				query.append("				,   USR_NM  	");
				query.append("				,   USR_PWD 	");
				query.append("				,	JOIN_DT		");
				query.append("	)              ");
				query.append("	VALUES	(      ");
				query.append("					?      ");
				query.append("				,	?      ");
				query.append("				,	?      ");
				query.append("				,	SYSDATE      ");
				query.append("			)              ");
				
				return query.toString();
			}

			@Override
			public void mappingParms(PreparedStatement stmt) throws SQLException {
				
				stmt.setString(1, newUserVO.getUserId());
				stmt.setString(2, newUserVO.getUserName());
				stmt.setString(3, newUserVO.getUserPassword());		
			}

			@Override
			public Object bindData(ResultSet rs) throws SQLException {
				return null;
			}}; 
		
		return (int) jds.otherFunction();
	}
	

	@Override
	public List<UserVO> selectAllUser(UserSearchVO userSearchVO) {
		return null;
	}

	@Override
	public int checkOneAccount(String userId) {
		
		
		JdbcDaoSupport jds = new JdbcDaoSupport() {
			
			@Override
			public String query() {
				
				StringBuffer query = new StringBuffer();
				
				query.append("	SELECT  ROWNUM  AS  CNT  ");
				query.append("	FROM 	USR              ");
				query.append("	WHERE 	USR_ID = ?      ");
				
				return query.toString();
			}
			
			@Override
			public void mappingParms(PreparedStatement stmt) throws SQLException {
				stmt.setString(1, userId);
			}
			
			@Override
			public Object bindData(ResultSet rs) throws SQLException {
				return rs.getInt("CNT"); 
			}
		};
		

		
		return	(int) jds.selectOne();	
	}

	
	@Override
	public UserVO selectOneUser(UserVO userVO) {
		
		JdbcDaoSupport jds = new JdbcDaoSupport() {
			
			@Override
			public String query() {
				StringBuffer query = new StringBuffer();
				
				query.append("	SELECT  USR_ID        ");
				query.append("			, 	USR_NM        ");
				query.append("			, 	USR_PW        ");
				query.append("	FROM 	USR              ");
				query.append("	WHERE 	USR_ID = ?      ");
				query.append("	AND   	USR_PW = ?      ");
				
				return query.toString();
					    
				
			}
			
			@Override
			public void mappingParms(PreparedStatement stmt) throws SQLException {
				stmt.setString(1, userVO.getUserId());
				stmt.setString(2, userVO.getUserPassword());
			}
			
			@Override
			public Object bindData(ResultSet rs) throws SQLException {
				UserVO user = new UserVO();
				
				//user.setUserId(rs.getString("USR_ID"));
				//user.setUserName(rs.getString("USR_NM"));
			//	user.setUserPassword(userPassword);		
		
				
				
				return userVO;
			}
		};
		
		jds.selectOne();
		
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
