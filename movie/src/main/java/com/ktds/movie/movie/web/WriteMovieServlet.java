package com.ktds.movie.movie.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.movie.common.web.MultipartHttpServletRequest;
import com.ktds.movie.movie.service.MovieService;
import com.ktds.movie.movie.service.MovieServiceImpl;
import com.ktds.movie.movie.vo.MovieVO;
import com.ktds.movie.user.vo.UserVO;


public class WriteMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MovieService movieService;
       
   
    public WriteMovieServlet() {
        movieService = new MovieServiceImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/movie/write.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		MultipartHttpServletRequest multipart = new MultipartHttpServletRequest(request);
		
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("_USER_");
		
		if(user == null) {
			response.sendRedirect("/movie/signin/");
			return ;
		}
		
		String movieTitle = multipart.getParameter("movieTitle");
		String movieContent = multipart.getParameter("movieContent");
		
		MovieVO movie = new MovieVO();
	
		movie.setMovieTitle(movieTitle);
		movie.setMovieContent(movieContent);
		movie.setUserId(user.getUserId());
		
		if(movieService.insertOneMovie(movie)) {
			response.sendRedirect("/movie/list");
			return ;
		}
		
		else {
			response.sendRedirect("/movie/write");
		}
		
	}

}
