package edu.kh.project.member.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.project.member.model.dto.Member;
import static edu.kh.project.common.JDBCTemplete.*;

public class SearchMemberDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public SearchMemberDAO() {
		
		try {
			String filePath = MemberDAO.class.getResource("/edu/kh/project/sql/member-sql.xml").getPath();
			
			prop = new Properties();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	
	
	
	public List<Member> searchMem(Connection conn, String nickName) throws Exception{
		
		List<Member>memList = new ArrayList<Member>();
		
		try {
			
			String sql = prop.getProperty("searchMem");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nickName);
			
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				
//				 int memberNo = rs.getInt(1); ;
//				 String memberEmail= rs.getString(2) ;
//				 String memberPw = rs.getString(3);
//				 String memberNickName =  rs.getString(4);
//				 String memberTel = rs.getString(5);
//				 String memberAddress = rs.getString(6);
//				 String profileImg = rs.getString(7);
//				 String enrollDate = rs.getString(8);
//				 String memberDeleteFlag=  rs.getString(9);
//				 int authority = rs.getInt(10);
//				 Member member = new Member(memberNo,memberEmail,memberPw,memberNickName,memberTel,memberAddress,profileImg,enrollDate,memberDeleteFlag,authority );
//				 memList.add(member);
				
				
				 //몇 개만 받아오는 경우 이렇게 작성할 것!!  
 				 Member member = new Member();
				 member.setMemberNo(rs.getInt("MEMBER_NO"));
				 member.setMemberEmail(rs.getString("MEMBER_EMAIL"));
				 member.setMemberNickName(rs.getString("MEMBER_NICKNAME"));
				 member.setMemberTel(rs.getString("MEMBER_TEL"));
				
				 memList.add(member);
				 
				 System.out.println("여기까지 완료?");
			}
			
		}finally {
			
			close(rs);
			close(pstmt);
			
		}

		
		return memList;
	}
	
}
