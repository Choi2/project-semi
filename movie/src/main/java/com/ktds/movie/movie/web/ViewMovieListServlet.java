package com.ktds.movie.movie.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.movie.common.web.pager.ClassicPageExplorer;
import com.ktds.movie.common.web.pager.PageExplorer;
import com.ktds.movie.common.web.pager.Pager;
import com.ktds.movie.common.web.pager.PagerFactory;
import com.ktds.movie.movie.biz.MovieBiz;
import com.ktds.movie.movie.biz.MovieBizImpl;
import com.ktds.movie.movie.service.MovieService;
import com.ktds.movie.movie.service.MovieServiceImpl;
import com.ktds.movie.movie.vo.MovieSearchVO;
import com.ktds.movie.movie.vo.MovieVO;

public class ViewMovieListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MovieService movieService;
    
       public ViewMovieListServlet() {
    	movieService = new MovieServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String pageNo = request.getParameter("pageNo");
		

		MovieSearchVO movieSearchVO = new MovieSearchVO();
		movieSearchVO.getPager().setPageNumber(pageNo);
		
		List<MovieVO> movieList = movieService.getAllMovies(movieSearchVO);
	
		int count = movieService.selectAllMovieCount(movieSearchVO);
		PageExplorer pager = new ClassicPageExplorer(movieSearchVO.getPager());
		
		
		
		String pages = pager.getPagingList(pageNo, "[@]", "PREV", "NEXT", "searchForm");
		
		
		request.setAttribute("movieList", movieList);
		request.setAttribute("pager", pages);
		request.setAttribute("count", count);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/movie/list.jsp");
		dispatcher.forward(request, response);
	}

}
