package com.ktds.movie.movie.dao;

import java.util.List;

import com.ktds.movie.movie.vo.MovieSearchVO;
import com.ktds.movie.movie.vo.MovieVO;

public interface MovieDao {
	List<MovieVO> getAllMovies(MovieSearchVO movieSearchVO);
	int selectAllMovieCount(MovieSearchVO movieSearchVO);
	int insertOneMovie(MovieVO movieVO);
}
