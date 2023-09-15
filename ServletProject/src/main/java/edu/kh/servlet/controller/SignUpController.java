package edu.kh.servlet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signUp")
public class SignUpController extends HttpServlet{
	
	// POST 요청 처리 메서드 오버라이딩
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 전달받은 값을 얻어와서 확인
		// -> 한글이 깨지는 문제 발생! 
		// why? 요청데이터의 문자 인코딩
		//      서버의 문자 인코딩이 같지 않아서.. 
		
		// 해결방법 :: 전달받은 데이터의 문자 인코딩을 서버에 맞게 변경
		req.setCharacterEncoding("UTF-8");
		
		String inputId = req.getParameter("inputId");
		String inputPw = req.getParameter("inputPw");
		String inputName = req.getParameter("inputName");
		String intro  = req.getParameter("intro");
		
		
		// 응답화면 만들기
		// -> Java에서 작성하기 너무 귀찮고 힘들다.
		// -> 누가 이것좀 대신 해주면 안되나? --> JSP 대신 화면을 만들어서 응답해줌
		
		// JSP가 대신 화면을 만들어 주기 위해선
		// Servlet이 어떤 요청을 받았는지 알아야 함! 
		// -> Servlet이 받은 요청을 JSP로 위임하는 작업을 진행! 
		
		// WEB-INF :: 클라이언트 직접 접근 불가 (주소를 쳐서 직접 접근 불가) => 숨겨놓은 파일.
		// webapp :: 배포되는 폴더 
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/result.jsp");
										// webapp 기준				
		
		dispatcher.forward(req, resp);
		
	}
	
	
	

}
