package edu.kh.jsp.student.model.service;

import java.sql.Connection;
import java.util.List;

import static edu.kh.jsp.common.JDBCTemplete.*;

import edu.kh.jsp.student.model.dao.StudentDAO;
import edu.kh.jsp.student.model.dto.Student;





public class StudentService {
		
	// DAO 필드에 생성
	private StudentDAO dao = new StudentDAO();
	
	public List<Student> selectAll() throws Exception {

		// 1. Connection 생성
		Connection conn = getConnection();
		
		// 2. DAO 호출
		List<Student> stdList = dao.selectAll(conn);
		
		// 3. 트랜잭션 제어 select 필요 없음
		
		// 4. Connection 반환
		close(conn);
		
		
		// 5. DAO에서 받아온 호출 Controller로 넘기기
		return stdList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
