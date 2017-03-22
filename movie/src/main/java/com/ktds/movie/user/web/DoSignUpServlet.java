package com.ktds.movie.user.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.movie.user.service.UserService;
import com.ktds.movie.user.service.UserServiceImpl;
import com.ktds.movie.user.vo.UserVO;


public class DoSignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService;  
   
    public DoSignUpServlet() {
       userService = new UserServiceImpl();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String userPassword = request.getParameter("userPassword");
		String userName = request.getParameter("userName");
	
		UserVO user = new UserVO();
		
		user.setUserId(userId);
		user.setUserPassword(userPassword);
		user.setUserName(userName);
		
		userService.insertNewUser(user);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/signin.jsp");
		dispatcher.forward(request, response);
		
	}

}
