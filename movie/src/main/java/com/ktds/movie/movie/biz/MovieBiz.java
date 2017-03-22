package com.ktds.movie.movie.biz;

import java.util.List;

import com.ktds.movie.movie.vo.MovieSearchVO;
import com.ktds.movie.movie.vo.MovieVO;

public interface MovieBiz {
	List<MovieVO> getAllMovies(MovieSearchVO movieSearchVO);
	int selectAllMovieCount(MovieSearchVO movieSearchVO);
	boolean insertOneMovie(MovieVO movieVO);
}
