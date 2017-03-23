package com.ktds.movie.common.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.movie.movie.vo.MovieVO;

public abstract class JdbcDaoSupport {
	
	private final String ACCOUNT = "MOVIE";
	private final String PASSWORD = "movie";
	private final String IPADDRESS = "192.168.201.22";
	
	public Object otherFunctions() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		Connection conn = null;
		PreparedStatement stmt = null;
		
		String url = "jdbc:oracle:thin:@" + IPADDRESS + ":1521:XE";

		try {
			conn = DriverManager.getConnection(url, ACCOUNT, PASSWORD);
			String query = query();

			stmt = conn.prepareStatement(query);
			mappingParms(stmt);

			return stmt.executeUpdate();
			
		

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {

				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {

				}
			}
		}
	}
	
	
	public Object select(boolean isOne) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String url = "jdbc:oracle:thin:@" + IPADDRESS + ":1521:XE";

		try {
			conn = DriverManager.getConnection(url, ACCOUNT, PASSWORD);
			String query = query();

			stmt = conn.prepareStatement(query);
			mappingParms(stmt);

			rs = stmt.executeQuery();
			
			
			if(isOne) {
				
				if (rs.next()) {
					return bindData(rs);
				}
				
			}
			
			else {
				
				List<MovieVO> movieList = new ArrayList<MovieVO>();
				
				while(rs.next()) {
					movieList.add((MovieVO) bindData(rs));
				}
				
				
				return movieList;
			}
			
			return 0;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {

				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {

				}
			}
		}

	}
	

	public abstract String query();
	public abstract void mappingParms(PreparedStatement stmt) throws SQLException;
	public abstract Object bindData(ResultSet rs) throws SQLException;

}
