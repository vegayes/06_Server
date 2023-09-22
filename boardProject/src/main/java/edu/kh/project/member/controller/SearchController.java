package edu.kh.project.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.service.SearchMemberService;


@WebServlet("/search")
public class SearchController extends HttpServlet{
	
	SearchMemberService service = new SearchMemberService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("서비스 확인");
	
		try {
			

			String nickName = req.getParameter("query");
			
			List<Member> mem = service.searchmem(nickName);
//			HttpSession session = req.getSession(); // HttpSession 객체 
//			session.setAttribute("searchnickName", nickName);
			req.setAttribute("mem", mem);
			req.setAttribute("query", nickName);

		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("/WEB-INF/views/new/search.jsp").forward(req, resp);
		
	}
	
	
	
}
