<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원 검색 결과 </title>
		
		<link rel="stylesheet" href="/resources/css/main-style.css">
		
		<script src="https://kit.fontawesome.com/ac58eafae7.js" crossorigin="anonymous"></script>
	</head>
	<body>
	
		<main>
			<jsp:include page="/WEB-INF/views/common/header.jsp" />
			
			<section class = "search-page">
				<h1>'${query}'로 검색한결과</h1>
				
				<c:choose>
				
				 <%-- ★★★★★★★memberList가 비어있을 때 (근데, ''값 오면 빈값으로 들어옴??  --%>
					<%--<c:when test = "${empty requestScope.mem}"> --%>
					<c:when test = "${query == '' || empty requestScope.mem }">
						<p>검색된 회원이 없습니다.</p>
					</c:when>

					<c:otherwise>
						<c:forEach var = "member" items = "${mem}">
								<div class = "search-div">
									닉네임 : ${member.memberNickName} <br>
									<%-- var.필드명 --%>
									
									이메일 : ${member.memberEmail} <br>
								
									전화번호 : ${member.memberTel}<br>								
								
								</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</section>

		</main>

		<jsp:include page="/WEB-INF/views/common/footer.jsp" />
		
	</body>
</html>