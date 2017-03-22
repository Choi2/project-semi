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
import com.ktds.movie.movie.vo.MovieSearchVO;
import com.ktds.movie.movie.vo.MovieVO;


public class ViewMovieListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private  MovieBiz movieBiz;
    
       public ViewMovieListServlet() {
    	movieBiz = new MovieBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String pageNo = request.getParameter("pageNo");
		
		Pager pager = PagerFactory.getPager(Pager.ORACLE);
		pager.setPageNumber(pageNo);
		MovieSearchVO searchVO = new MovieSearchVO();
		searchVO.setPager(pager);
		
		List<MovieVO> MovieList = movieBiz.getAll(searchVO);
		PageExplorer pageExplorer = new ClassicPageExplorer(pager);
		String pages = pageExplorer.getPagingList("pageNo", "[@]", "PREV", "NEXT", "searchForm");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/movie.jsp");
		
		request.setAttribute("count", pager.getTotalArticleCount());
		request.setAttribute("pager", pages);
		dispatcher.forward(request, response);
	}

}
