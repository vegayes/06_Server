<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Scope 생명주기 확인 </title>
	</head>
	<body>
	
		<p>해당 값이 없으면 null로  즉, EL 이라서 빈 값 </p>
		<h3> page : ${pageScope.str}</h3>
		
		<h3> request : ${requestScope.str}</h3>
		
		<h3> session : ${sessionScope.str}</h3>
		
		<h3> application : ${applicationScope.str}</h3>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	</body>
</html>