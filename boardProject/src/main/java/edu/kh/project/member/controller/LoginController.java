package edu.kh.project.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.service.MemberService;

@WebServlet("/member/login")
public class LoginController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			// 인코딩 처리
			req.setCharacterEncoding("UTF-8");
			
			// 파라미터 얻어오기
			String inputEmail = req.getParameter("inputEmail");
			String inputPw = req.getParameter("inputPw");
			
			
			//서비스 객체 생성 
			MemberService service = new MemberService();
			
			//로그인 서비스 호출 후 결과 반환받기
			Member loginMember = service.login(inputEmail,inputPw);
			
			
			
			System.out.println(loginMember);
			
			
			//Session 객체 생성
			HttpSession session = req.getSession();
			
			if(loginMember!= null) { // 로그인 성공
				
				// session에 로그인한 회원 정보를 추가
				session.setAttribute("loginMember", loginMember);
				
				// session 만료 시간 지정 (초단위 지정)
				 session.setMaxInactiveInterval(60*60);
				
				 
				 resp.sendRedirect("/"); // 메인 페이지 재요청 ( 이거때문에 메인페이지로 다시 돌아옴  원래는 버튼 누르면 /member/login으로 이동했어야 함
				 
				 //forward : 요청 처리 후 자체적인 화면이 존재하여
				 //          이를 이용해서 응답
				 
				 // 로그인만을 위한 응답 페이지는 필요가 없음
				 // 그러므로 redirect 필요
				 
				 // redirect : 요청 처리 후 자체적인 화면이 없어서 
				 //           화면이 있는 다른 요청을 다시 호출(요청)
				 
				 
				 
			}else { // 실패
				
				// 로그인 실패 메시지를 session에 추가
				session.setAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
				
				// 현재 요청 이전 페이지로 redirect
				String referer = req.getHeader("referer");
				// referer => 각 페이지 방문시 남는 흔적을 말함
				// request.getHeader() : 안에 파라미터로 referer 전달 시 이전페이지 주소값 반환.
				// http://localhost:8080/
				
				System.out.println(referer);
				resp.sendRedirect(referer);
				
			}
			
			
			
			
			
			
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
//		req.getRequestDispatcher("/WEB-INF/views/project/ .jsp").forward(req, resp);
	}
	
}
