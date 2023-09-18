package edu.kh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test/result")
public class TestController extends HttpServlet{
	
	// a태그 이용
	// a태그 이용 시, 컨트롤러 무조건 이동! (주소만 이동됨)
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//바로 JSP로 위임
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/testResult.jsp");
			
		dispatcher.forward(req, resp);
	}
}
