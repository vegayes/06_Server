package edu.kh.jsp.student.model.service;

import java.sql.Connection;
import java.util.List;

import static edu.kh.jsp.common.JDBCTemplete.*;

import edu.kh.jsp.student.model.dao.ArchStudentDAO;
import edu.kh.jsp.student.model.dto.Student;

public class ArchStudentService {

	private ArchStudentDAO dao = new ArchStudentDAO();
	
	public List<Student> selectArch() throws Exception{
	
		
		Connection conn = getConnection();
		
		List<Student> listArch = dao.selectArch(conn);


		close(conn);
		
		return listArch;
	}

}
