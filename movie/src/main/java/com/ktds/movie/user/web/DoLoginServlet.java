package com.ktds.movie.user.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.movie.user.service.UserService;
import com.ktds.movie.user.service.UserServiceImpl;
import com.ktds.movie.user.vo.UserVO;


public class DoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService;   
    
    public DoLoginServlet() {
    	userService = new UserServiceImpl();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/signin.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String userId = request.getParameter("userId");
		String userPassword = request.getParameter("userPassword");
		
		//System.out.println("userId : " + userId );
		//System.out.println("userPassword : " + userPassword);
		
		
		UserVO user = new UserVO();
		
		user.setUserId(userId);
		user.setUserPassword(userPassword);
		
		user = userService.loginOneUser(user);
		
		//System.out.println(user.getUserName());
		
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("_USER_", user);
			response.sendRedirect("/movie/list");
			return ;
		}
		
		
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/signin.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
