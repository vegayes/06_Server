package edu.kh.project.member.model.service;

import java.sql.Connection;
import java.util.List;

import static edu.kh.project.common.JDBCTemplete.*;

import edu.kh.project.member.model.dao.SearchMemberDAO;
import edu.kh.project.member.model.dto.Member;

public class SearchMemberService {

	private SearchMemberDAO dao = new SearchMemberDAO();


	public List<Member> searchmem(String nickName) throws Exception{
		Connection conn = getConnection();
		
		List<Member> listMem = dao.searchMem(conn,nickName );
		
		 System.out.println("서비스 완료?");

		
		close(conn);
		
		return listMem;
	}
	
}
