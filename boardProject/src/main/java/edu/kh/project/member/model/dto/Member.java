package edu.kh.project.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter; // lombok의 자동완성으로 getter 만들어짐
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 모든 필드 매개변수 생성자
public class Member {

// lombok 라이브러리 : getter/setter , 생성자, toString() 자동완성 라이브러리	
	
	private int memberNo;
	private String memberEmail;
	private String memberPw;
	private String memberNickName;
	private String memberTel;
	private String memberAddress;
	private String profileImg;
	private String enrollDate;
	private String memberDeleteFlag;
	private int authority;
}
