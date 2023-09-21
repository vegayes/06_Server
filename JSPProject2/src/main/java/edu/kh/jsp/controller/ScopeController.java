package edu.kh.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


// 서블릿 매핑에 유효하지 않은 url pattern ( "scope") 
// -> 매핑할 주소 제일 앞에 "/" 반드시 작성
// -> 쓰지 않으면 에러남.
@WebServlet("/scope")
public class ScopeController extends HttpServlet{
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/scope/scope.jsp");
			
			
			// 1. page scope => JSP에서 확인
			
			// 2. request scope => 요청받은 페이지  + 위임받은 페이지 
			req.setAttribute("reqValue", "1234");
			
			// 3. session scope => 브라우저당 1개 
			//					=> 브라우저 종료 또는 session 만료까지 유지 
			// ex) 로그인 여부에서 많이 사용
			
			// session 객체 얻어오는 방법
			HttpSession session = req.getSession(); // HttpSession 객체 
			session.setAttribute("sessionValue", "999");
			
			
			// 4. appliction scope => 서버가 켜져있는 동안 유지 
			// application 객체를 얻어오는 방법
			// -> request, session 객체에서 얻어오기 가능
			
			ServletContext application = req.getServletContext();
//			session.getServletContext();
			
			application.setAttribute("appValue", 10000);
			
			// ** 모든 scope는 속성을 세팅하고 얻어오는 방법 동일!! **
			
			
			
			// 모든 범위에 같은 key로 속성 세팅 
			req.setAttribute("str", "request 범위에 세팅된 문자열");
			
			session.setAttribute("str",  "session 범위에 세팅된 문자열");

			application.setAttribute("str",  "application  범위에 세팅된 문자열");
			
			
			
			
			dispatcher.forward(req, resp);
			
		}
}
