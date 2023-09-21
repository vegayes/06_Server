<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- JSTL 사용시, 무조건 작성! --%>    
<%@ taglib  prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>



    <%--	<%@ %> :: 지시자 태그
    		
    		taglib :: 태그 라이브러리 추가
    		
    		prefix :: 접두사, 태그명 앞에 작성되는 단어 <c:if>  core?? 
    		
    		uri(Uniform Resource Identifier, 통합 자원 식별자)  
    		=> 자원을 식별하는 고유 문자열 (ID) 
    		
    		(참고) url(Uniform Resource Locator) 
    		=> 자원의 위치를 나타내는 문자열(경로)
    		
     --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSTL(Jsp Standard Tag Library)</title>
	</head>
	<body>
	
	    <%-- 상대경로 : 현재 경로가 중요함! 
	    	 현재 경로 : localhost:8000/jstl/contiditon --%>
		<a href="condition">JSTL을 이용한 조건문(if / choose, when, otherwise)</a>
		
		<br>
		<a href="loop">JSTL을 이용한 반복문(loop)</a>
		
		<br>
		<a href="student/selectAll">workbook에서 학생 전체 조회하기<a>
		
		
		<br>
		<a href = "student/selectArch">건축공학과인 학생만 찾아라</a>
		
		
		<br>
		<br>
		<br>입력한 학과명의 학생 정보 찾기
		
		<form action = "student/inputSelect" method="post">
			학과명 입력 : <input name ="deptName">
			<button>찾기</button>
		</form>
		
	
		<h1>JSTL(Jsp Standard Tag Library, JSP 표준 태그 라이브러리)</h1>
	
		<pre>
			JSP에서 자주 사용되거나 공통적으로 사용되는
			Java코드 (if, for, 변수 선언, 형변환)를 
			
			스크립틀릿 대신 html태그 형식을 태그화하여 
			표준으로 제공하는 라이브러리 
			(if, for 간단히 쓰고 싶으면 이거 써라..)
			
		</pre>
	
	
		<h3>JSTL 라이브러리 등록 방법</h3>
	
		<ol>
			<li>
				<a href = "https://tomcat.apache.org/download-taglibs.cgi">JSTL 다운로드 페이지 이동</a>
				JSTL 다운로드
			</li>
			
			<li>
				/webapp/WEB-INF/lib 폴더에 라이브러리 파일(.jar) 추가
			</li>
			
			<li>
				JSTL 라이브러리를 사용하고자 하는 JSP 파일 상단에 tablib JSP 지시자 태그를 추가
			</li>
			
		</ol>
		
		<hr>
		
		<h1> 1. 변수 선언(c:set 태그)</h1>
		
		<pre>
			- 변수 선언을 위한 태그
			
			- c:set에 작성 가능한 속성
			
			1) var : 변수명(속성 key)
			2) value : 대입할 값 
			3) scope : page, request, session , application 중 하나 지정 
						(기본값 page) 
		</pre>
	
	
	
		<%
			// 스크립틀릿으로 page scope에 속성 세팅하는 방법
			pageContext.setAttribute("num1", 10);
			
		%>
	
	
		<%-- JSTL로  page scope에 속성 세팅하는 방법  --%>
		<c:set var = "num2" value = "20" scope = "page" />
		
		num1 : ${num1}
		<br>
		num2 : ${num2}
		
	
	
	
		<hr>
		
		<h1>2. 변수 제거 (c:remove)</h1>
		<pre>
			- 변수 제거 : 내장 객체에 세팅된 속성을 제거
				( removeAttribute("num1"))
			- c:remove 속성
				1) var : 삭제할 변수명
				2) scope : 내장 객체 범위 (기본값 : 모든 scope)

		</pre>

		<%
			pageContext.removeAttribute("num1");
		 %>	
		 
		 num1 제거 확인 : ${num1}
		 
		 <br>
		 
		 
		 <c:remove var = "num2" />
		 
		 num2 제거 확인 : ${num2}
	
	
		<hr>
		
		<h1>3. 변수 출력(c:out 태그)</h1>
	
		<pre>
			\${key}EL 구문 비슷함
			
			-단, escapeXml = "true" (기본값) 설정 시 
			    html 태그가 해석 X 
			    
			-escapeXml = "false" : html 태그 해석 O 
		</pre>
	
	
		<c:set var="temp" value = "<h1>곧 점심시간</h1>" />


		html 태그 해석 X : <c:out value="${temp}"/>		
	
	
		<br>
		
		html 태그 해석 O : <c:out value="${temp}" escapeXml = "false"/>
	
	</body>
</html>