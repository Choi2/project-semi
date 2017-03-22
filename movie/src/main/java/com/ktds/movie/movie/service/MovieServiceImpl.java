package com.ktds.movie.movie.service;

import java.util.List;

import com.ktds.movie.movie.biz.MovieBiz;
import com.ktds.movie.movie.biz.MovieBizImpl;
import com.ktds.movie.movie.vo.MovieSearchVO;
import com.ktds.movie.movie.vo.MovieVO;

public class MovieServiceImpl implements MovieService{

	private MovieBiz movieBiz;
	
	public MovieServiceImpl() {
		movieBiz = new MovieBizImpl();
	}
	
	@Override
	public List<MovieVO> getAllMovies(MovieSearchVO movieSearchVO) {
		return movieBiz.getAllMovies(movieSearchVO);
	}

	@Override
	public int selectAllMovieCount(MovieSearchVO movieSearchVO) {
		return movieBiz.selectAllMovieCount(movieSearchVO);
	}

	@Override
	public boolean insertOneMovie(MovieVO movieVO) {
		return movieBiz.insertOneMovie(movieVO);
	}
	
}
