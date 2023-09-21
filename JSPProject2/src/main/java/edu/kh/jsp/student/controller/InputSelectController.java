package edu.kh.jsp.student.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.jsp.student.model.dto.Student;
import edu.kh.jsp.student.model.service.InputStudentService;

@WebServlet("/jstl/student/inputSelect")
public class InputSelectController extends HttpServlet{
	
	InputStudentService service = new InputStudentService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			req.setCharacterEncoding("UTF-8");
			
			String dept = req.getParameter("deptName");
			
			List<Student> stdList = service.inputSelect(dept);
			
			req.setAttribute("deptName", dept);
			req.setAttribute("stdList", stdList);
			
		}catch(Exception e) {
			e.printStackTrace();
		}

		
		req.getRequestDispatcher("/WEB-INF/views/student/inputSelect.jsp").forward(req, resp);
	}

}
