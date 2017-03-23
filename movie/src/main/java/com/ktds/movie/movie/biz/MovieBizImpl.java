package com.ktds.movie.movie.biz;

import java.util.ArrayList;
import java.util.List;

import com.ktds.movie.movie.dao.MovieDao;
import com.ktds.movie.movie.dao.MovieDaoImpl;
import com.ktds.movie.movie.vo.MovieSearchVO;
import com.ktds.movie.movie.vo.MovieVO;

public class MovieBizImpl implements MovieBiz {

	private MovieDao movieDao;
	
	public MovieBizImpl() {
		movieDao = new MovieDaoImpl();
	}
	
	
	@Override
	public List<MovieVO> getAllMovies(MovieSearchVO movieSearchVO) {
		
		int MusicCount = movieDao.selectAllMovieCount(movieSearchVO);
		movieSearchVO.getPager().setPageNumber(MusicCount - 2);
		
		if(MusicCount == 0) {
			return new ArrayList<MovieVO>();
		}
		
		return movieDao.getAllMovies(movieSearchVO);
	}


	@Override
	public int selectAllMovieCount(MovieSearchVO movieSearchVO) {
		return movieDao.selectAllMovieCount(movieSearchVO);
	}


	@Override
	public boolean insertOneMovie(MovieVO movieVO) {
		return movieDao.insertOneMovie(movieVO) > 0;
	}

}
