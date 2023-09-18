package edu.kh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login") // 현재 클래스를 Servlet 등록 + /login 요청을 처리
public class LoginController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// POST 방식 문제점 : 한글 깨짐(인코딩 불일치 문제)
		
		req.setCharacterEncoding("UTF-8"); // 요청 데이터 인코딩 변경
		
		// html에서 전달받은 값(파라미터) 변수에 저장 
		// 전달된 값 == 파라미터
		
		// name 속성값 받아옴
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
	
		String msg = null;
		
		// id/pw가 user01/pass01과 일치하면 "로그인 성공"
		// 일치하지 않으면 "아이디 또는 비밀번호 불일치" 출력
		
		if(id.equals("user01") && pw.equals("pass01")) {
			msg = "로그인 성공";
		}else {
			msg = "아이디 또는 비밀번호가 일치하지 않습니다.";
		}	
		
		
		// Servlet으로 클라이언트에게 응답할 화면 만들기.. 
		// 작성하기 힘들어서 ==> JSP 이용 
		
		// Request : 요청
		// Dispatcher : 발송자, 필요한 정보를 제공하는자, 역할을 넘김.
		
		
		// RequestDispatchaer : 요청 정보 , (응답)역할을 넘기는 객체 
		
		// ** JSP 경로 작성방법 **
		// -> webapp 폴더 기준으로 경로를 작성
		// 
		RequestDispatcher dispatcher
			= req.getRequestDispatcher("/WEB-INF/views/loginResult.jsp");
		
		
		// msg를 같이 전달해줄 것 ( 속성(attribute)으로 추가)
		// -> Map 형식으로 작성(K:V)
		req.setAttribute("msg", msg);
		
		//****************
		// forward	
		// 전송하다, 전달하다, 보내다
		
		// forward를 하면 주소창이 요청 주소 바뀜 -> 그 요청에 맞는 화면으로 변함
		// 요청에 맞는 응답을 했기 떄문
		
		// => Servlet이 가지고 있던 req,resp객체를 JSP에게 전달하여 요청을 위임
		dispatcher.forward(req, resp);
		
		
	}
}