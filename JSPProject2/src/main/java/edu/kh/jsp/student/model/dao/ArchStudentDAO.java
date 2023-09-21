package edu.kh.jsp.student.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


import edu.kh.jsp.student.model.dto.Student;
import static edu.kh.jsp.common.JDBCTemplete.*;

public class ArchStudentDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public ArchStudentDAO() {
		
		try {
			String filePath = StudentDAO.class.getResource("/edu/kh/jsp/sql/student-sql.xml").getPath();
			
			prop = new Properties();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	

	public List<Student> selectArch(Connection conn) throws Exception {

		List<Student> listArch = new ArrayList<Student>();

			try {
				
				String sql = prop.getProperty("selectArch");
				
				stmt = conn.createStatement();
	
				rs = stmt.executeQuery(sql);			
				
				while(rs.next()) {
					
					String studentNo = rs.getString("STUDENT_NO");
					String studentName = rs.getString("STUDENT_NAME");
					String studentAddress = rs.getString("STUDENT_ADDRESS");
					String departmentName = rs.getString("DEPARTMENT_NAME");
					
					Student student = new Student(studentNo, studentName, studentAddress, departmentName);
				
					listArch.add(student);
					
				}
			
			
		}finally {
			
			close(rs);
			close(pstmt);
		}
		
		return listArch;
	}

}
