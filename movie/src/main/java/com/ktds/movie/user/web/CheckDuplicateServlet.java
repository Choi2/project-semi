package com.ktds.movie.user.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckDuplicateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService;   
	
    public CheckDuplicateServlet() {
    	userService = new UserServiceImpl();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		
		
		
		
	}

}
