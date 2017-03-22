package com.ktds.movie.user.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.movie.user.service.UserService;
import com.ktds.movie.user.service.UserServiceImpl;

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
		boolean isDuplicate = userService.checkOneAccount(userId);
			

		StringBuffer json = new StringBuffer();
		json.append(" { ");
		json.append(" \"status\" : \"success\", ");
		json.append(" \"duplicated\" : " + isDuplicate);
		json.append(" } ");
		
		PrintWriter writer = response.getWriter();
		writer.write(json.toString());
		writer.flush();
		writer.close();
		
	}

}
