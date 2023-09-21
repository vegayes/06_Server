package edu.kh.project.member.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.project.member.model.dto.Member;
import static edu.kh.project.common.JDBCTemplete.*;

public class MemberDAO {
	// JDBC 객체 저장을 참조 변수 선언
		private Statement stmt;
		private PreparedStatement pstmt;
		private ResultSet rs;
		
		private Properties prop;
		
		// 기본 생성자로 객체가 생성될 때 
		// sql이 작성된 xml 파일 읽어와 prop에 저장
		public MemberDAO() {
			
			try {
				prop = new Properties();

				String filePath = MemberDAO.class.getResource("/edu/kh/project/sql/member-sql.xml").getPath();
				
				prop.loadFromXML(new FileInputStream(filePath));
				
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	public Member login(Connection conn, String inputEmail, String inputPw) throws Exception{
		

		Member loginMember = null;
		
		try {
			
			String sql = prop.getProperty("login");
			
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, inputEmail);
			pstmt.setString(2, inputPw);

			rs = pstmt.executeQuery();
			
			System.out.println(rs);

			if(rs.next()) {
//				int memberNo  = rs.getInt("MEMBER_NO");
//				String memberEmail = rs.getString("MEMBER_EMAIL");
//				String memberPw = rs.getString("MEMBER_PW");
//				String memberNickName = rs.getString("MEMBER_NICKNAME");
//				String memberTel = rs.getString("MEMBER_TEL");
//				String memberAddr = rs.getString("MEMBER_ADDR");
//				String profileImg= rs.getString("PROFILE_IMG");
//				String enrollDate = rs.getString("ENROLLDATE");
//				String memberDeleteFlag = rs.getString("MEMBERDELETEFLAG");
//				int authority  = rs.getInt("AUTHORITY");

				loginMember = new Member();
				loginMember.setMemberNo(rs.getInt(1));
				loginMember.setMemberEmail(rs.getString(2));
				loginMember.setMemberNickName(rs.getString(3));
				loginMember.setMemberTel(rs.getString(4));
				loginMember.setMemberAddress(rs.getString(5));
				loginMember.setProfileImg(rs.getString(6));
				loginMember.setAuthority(rs.getInt(7));
				loginMember.setEnrollDate(rs.getString(8));
				
				
			}
	
		}finally {
			
			close(rs);
			close(stmt);
		}
		
		
		return loginMember;
	}

}
