package edu.kh.jsp.student.model.service;

import java.sql.Connection;
import java.util.List;

import static edu.kh.jsp.common.JDBCTemplete.*;
import edu.kh.jsp.student.model.dao.InputStudentDAO;
import edu.kh.jsp.student.model.dto.Student;

public class InputStudentService {

	InputStudentDAO dao = new InputStudentDAO();

	public List<Student> inputSelect(String dept) throws Exception{
		
		Connection conn = getConnection();
		
		List<Student> stdList =  dao.inputStudentDAO(conn, dept);
		
		close(conn);
		
		return stdList;
	}

	
}
