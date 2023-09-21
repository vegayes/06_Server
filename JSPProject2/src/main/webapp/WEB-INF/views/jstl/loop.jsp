<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        
<%-- JSTL 사용시, 무조건 작성! --%>    
<%@ taglib  prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSTL 반복문</title>
	</head>
	<body>
	
		<h1>6. 반복문 - for (c:forEach태그)</h1>
	
	
		<pre>
			- 일반 for + 추가 기능
			
			- 속성
				1) var : 현재 반복 횟수에 해당하는 변수 (int i)
				2) begin : 반복 시 var 시작 값
				3) end : 반복이 종료될 var 값
				4) step : 반복 시 마다 var의 증가 값 (기본값 1)
				
				5) items : 반복 접근한 객체(배열, 컬렉션 객체)
				
				6) varStatus : 현재 반복 상태와 관련된 정보를 제공하는 변수 선언
				
					varStatus="변수명"
					-> c:forEach 구문 내에서 "변수명"을 통해 원하는 값을 얻을 수 있다.
				
					* varStatus에서 제공되는 값
					- current : 현재 반복 횟수(현재 var 값)
					또는 현재 반복 접근 중인 객체(컬렉션/배열 요소)
					- index : 현재 인덱스값 반환 (0부터 시작)
					
					- count : 현재 몇바퀴째인지 반복 횟수 반환 (1부터 시작)
					
					- first : 첫 번째 반복이면 true, 아니면 false
					
					- last : 마지막 반복이면 true, 아니면 false
			
			
		</pre>
	
	
	
		<hr>
		
		<h3>일반 for문 형식으로 사용하기</h3>
		
		<c:forEach var = "i" begin ="1" end = "6" step = "1">
		     <%-- 1부터 6까지 1씩 증가 반복문 --%>
			<h${i}> 현재 i값 값 : ${i}  </h${i}>
		</c:forEach>
	

		<hr>
		
		<h3>향상된 for문 형식으로 사용하기</h3>
		<c:forEach var = "book" items = "${bookList}" varStatus = "vs">
				<%-- varStatus :: 변수명  --%>
				<p>
					1) 현재 인덱스 값을 반환 <br>
					index : ${vs.index} <br>
					
					<br><br>
					2) 몇 번째 반복인지 출력 <br>
					count : ${vs.count} <br>
					
					3) 현재 접근한 객체 <br>
					current : ${vs.current}<br>
					
					<c:if test = "${vs.first}">
					4) 첫 번째 요소 확인 (t/f)
						첫 번째 요소 입니다.
					</c:if>
					
					<c:if test = "${vs.last}">
					5) 마지막 요소 확인 (t/f)
						마지막 요소 입니다.
					</c:if>
				</p>
		</c:forEach>

	</body>
</html>