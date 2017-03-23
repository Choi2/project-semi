 



package com.ktds.movie.movie.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.movie.common.web.dao.JdbcDaoSupport;
import com.ktds.movie.movie.vo.MovieSearchVO;
import com.ktds.movie.movie.vo.MovieVO;


public class MovieDaoImpl implements MovieDao{

	@Override
	public List<MovieVO> getAllMovies(MovieSearchVO movieSearchVO) {
	

		
		JdbcDaoSupport jds = new JdbcDaoSupport() {
			
			@Override
			public String query() {
				
				StringBuffer query = new StringBuffer();
				                                                                              
				query.append("	SELECT	*                                                         ");
				query.append("	FROM	(                                                         ");
				query.append("				SELECT	ROWNUM	AS RNUM                               ");
				query.append("								,	A.*                               ");
				query.append("				FROM	(                                             ");
				query.append("						SELECT		M.MVIFMT_ID                       ");
				query.append("								,	M.USR_ID                          ");
				query.append("								, 	TO_CHAR(M.MVIFMT_DT, 'YYYY-MM-DD')	MVIFMT_DT ");
				query.append("								, 	M.MVIFMT_LK                         ");
				query.append("								,	M.MVIFMT_CNTN                       ");
				query.append("								,	M.MVIFMT_CK                         ");
				query.append("								,	M.MVIFMT_TTL                        ");
				query.append("								,	U.USR_NM                         	");
				query.append("								                                      ");
				query.append("						FROM		MVIFMT	M                         ");
				query.append("								, 	USR		U                         ");
				query.append("						WHERE	M.USR_ID	=	U.USR_ID              ");
				query.append("						ORDER	BY	M.MVIFMT_ID		DESC              ");
				query.append("						)	A                                         ");
				query.append("				WHERE		ROWNUM	<=	?                             ");
				query.append("			)                                                         ");
				query.append("	WHERE		RNUM	>=	?                                         ");
						
				return query.toString();
			}
			
			@Override
			public void mappingParms(PreparedStatement stmt) throws SQLException {
				
				stmt.setInt(1, movieSearchVO.getPager().getEndArticleNumber());
				stmt.setInt(2, movieSearchVO.getPager().getStartArticleNumber());
			}
			
			@Override
			public Object bindData(ResultSet rs) throws SQLException {
				
				MovieVO movie = new MovieVO();
				
				movie.setMovieId(rs.getInt("MVIFMT_ID"));
				movie.setMovieDate(rs.getString("MVIFMT_DT"));
				movie.setMovieLikeCount(rs.getInt("MVIFMT_LK"));
				movie.setMovieContent(rs.getString("MVIFMT_CNTN"));
				movie.setMovieTitle(rs.getString("MVIFMT_TTL"));
				movie.setMovieCheck(rs.getInt("MVIFMT_CK"));
				movie.getUserVO().setUserName(rs.getString("USR_NM"));;
				
			
				
				return movie;
			}
			
		};
		

		return (List<MovieVO>) jds.select(false);
		
	}

	@Override
	public int selectAllMovieCount(MovieSearchVO movieSearchVO) {
		
		
		JdbcDaoSupport jds = new JdbcDaoSupport() {
			
			@Override
			public String query() {
				
				StringBuffer query = new StringBuffer();
                
				query.append("	SELECT	COUNT(1)	AS	CNT");
				query.append("	FROM	MVIFMT	     	");
						
				return query.toString();
				
				
			}
			
			@Override
			public void mappingParms(PreparedStatement stmt) throws SQLException {
			
			}
			
			@Override
			public Object bindData(ResultSet rs) throws SQLException {
				return  rs.getInt("CNT");
			}
		};
		
	
		return (int) jds.select(true);
	}

	@Override
	public int insertOneMovie(MovieVO movieVO) {
		
		JdbcDaoSupport jds = new JdbcDaoSupport() {

			@Override
			public String query() {
				
				StringBuffer query = new StringBuffer();
				                                                         
				query.append("	INSERT	INTO	MVIFMT		(                     ");
				query.append("			                                      ");
				query.append("									MVIFMT_ID     ");
				query.append("								,	MVIFMT_DT     ");
				query.append("								,	MVIFMT_LK     ");
				query.append("								,	MVIFMT_CNTN   ");
				query.append("								,	MVIFMT_CK     ");
				query.append("								,	MVIFMT_TTL     ");
				query.append("								,	USR_ID        ");
				query.append("			)                                     ");
				query.append("	                                              ");
				query.append("	VALUES	(                                     ");
				query.append("									MOVIE_ID_SEQ.NEXTVAL  ");
				query.append("								,	SYSDATE       ");
				query.append("								,	0             ");
				query.append("								,	?             ");
				query.append("								,	0             ");
				query.append("								,	?             ");
				query.append("								,	?             ");
				query.append("			)                                     ");
				
				return query.toString();
			}

			@Override
			public void mappingParms(PreparedStatement stmt) throws SQLException {
				
				stmt.setString(1, movieVO.getMovieContent());
				stmt.setString(2, movieVO.getMovieTitle());
				stmt.setString(3, movieVO.getUserId());
				
			}

			@Override
			public Object bindData(ResultSet rs) throws SQLException {
				return null;
			}
			
			
		
		};
	
	
		return (int) jds.otherFunctions();
	}

}
