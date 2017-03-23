package com.ktds.movie.movie.vo;

import com.ktds.movie.common.web.pager.Pager;
import com.ktds.movie.common.web.pager.PagerFactory;

public class MovieSearchVO {
	
	private Pager pager;
	private String movieId;
	private String userId;
	
	
	public Pager getPager() {
		
		if(pager == null) {
			pager = PagerFactory.getPager(Pager.ORACLE);
		}
		
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
}
