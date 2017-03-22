package com.ktds.movie.movie.vo;

import com.ktds.movie.user.vo.UserVO;

public class MovieVO {
	
	private int movieId;
	private String userId;
	private String movieDate;
	private String movieTitle;
	private int movieLikeCount;
	private String movieContent;
	private int movieCheck;
	private UserVO userVO;
	
	
	public UserVO getUserVO() {
		
		if(userVO == null) {
			userVO = new UserVO();
		}
		
		return userVO;
	}
	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getMovieDate() {
		return movieDate;
	}
	public void setMovieDate(String movieDate) {
		this.movieDate = movieDate;
	}
	public int getMovieLikeCount() {
		return movieLikeCount;
	}
	public void setMovieLikeCount(int movieLikeCount) {
		this.movieLikeCount = movieLikeCount;
	}
	public String getMovieContent() {
		return movieContent;
	}
	public void setMovieContent(String movieContent) {
		this.movieContent = movieContent;
	}
	public int getMovieCheck() {
		return movieCheck;
	}
	public void setMovieCheck(int movieCheck) {
		this.movieCheck = movieCheck;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
}
