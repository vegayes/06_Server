<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%-- JSTL 사용시, 무조건 작성! --%>    
<%@ taglib  prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>학생 전체 조회</title>
			
		<style>
			table{
			border-collapse: collapse;
			}
		</style>
		
	</head>
	<body>
		
		<h1>학생 전체 목록</h1>
	
		<table border = "1">
			<%-- 출력 번호임 --%>
			<tr>
				<th>번호</th>
				<th>학번</th>
				<th>이름</th>
				<th>학과</th>
				<th>주소</th>
			</tr>
			
			
			<%-- 반복 접근을 이용해서 데이터를 가져올거기 때문에 JSTL 사용함. --%>
			<c:forEach var = "std" items = "${stdList}" varStatus = "vs" >
				<tr>
					<td>${vs.count}</td> <%-- 현재 반복한 횟수 --%>
					<td>${std.studentNo}</td>
					<td>${std.studentName}</td>
					<td>${std.departmentName}</td>
					<td>${std.studentAddress}</td>
				</tr>
			</c:forEach>
		
		
		</table>
		
		
	
	</body>
</html>