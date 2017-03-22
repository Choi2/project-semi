package com.ktds.movie.movie.service;

import java.util.List;

import com.ktds.movie.movie.vo.MovieSearchVO;
import com.ktds.movie.movie.vo.MovieVO;

public interface MovieService {
	List<MovieVO> getAllMovies(MovieSearchVO movieSearchVO);
	int selectAllMovieCount(MovieSearchVO movieSearchVO);
	boolean insertOneMovie(MovieVO movieVO);
}
