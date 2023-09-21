package edu.kh.jsp.student.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jsp.student.model.dto.Student;
import static edu.kh.jsp.common.JDBCTemplete.*;

public class InputStudentDAO {
	
	// JDBC 객체 저장을 참조 변수 선언
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	// 기본 생성자로 객체가 생성될 때 
	// sql이 작성된 xml 파일 읽어와 prop에 저장
	public InputStudentDAO() {
		
		try {
			String filePath = StudentDAO.class.getResource("/edu/kh/jsp/sql/student-sql.xml").getPath();
			
			prop = new Properties();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
			
		
	}


	public List<Student> inputStudentDAO(Connection conn, String dept) throws Exception {

		// 1. 결과 저장용 변수 선언
		List<Student>stdList = new ArrayList<Student>();
		
		try {
			
			// 2. sql 작성
//			String sql = prop.getProperty("selectAll");
			String sql = prop.getProperty("inputStudent");
			
			// 3. statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dept);
			
					
			// 4. sql 수행 후 결과(ResultSet) 반환받기
			rs = pstmt.executeQuery();
			
			// 5. ResultSet 1행씩 접근하면서 List에 옮겨 담기
			while(rs.next()) {
				
				String studentNo = rs.getString("STUDENT_NO");
				String studentName = rs.getString("STUDENT_NAME");
				String studentAddress = rs.getString("STUDENT_ADDRESS");
				String departmentName = rs.getString("DEPARTMENT_NAME");
				
				Student student = new Student(studentNo, studentName, studentAddress, departmentName);
			
				stdList.add(student);
			}
		}finally {
			
			close(pstmt);
		}
		
		
		
		
		return stdList;
	}


	
	
	
	
	
	
	
	
	
	
	
}
