<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 헤더  -->
	<div>
		<ul>
			<li><a href="/jsp/index.jsp">홈으로</a></li>
			<li><a href=" /jsp/visitlog/visitlog.jsp">방문록</a></li>
			<li><a href="/jsp/Member/signup.jsp">회원가입</a></li>
				<li><a href="/jsp/accountbook/accountbook.jsp">과제1:가계부</a></li>
			<li><a href="/jsp/library/library.jsp">과제2:독서실</a>
		</ul>
		
	</div>
	<!-- 최신 JQERY import (ajax() 사용할 js 파일위치 호출)  -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</body>
</html>

<!-- 
	헤더는 많은 페이지에서 참조하는 페이지 이므로 공통적인것 넣기
	1.라이브러리
		1. JQUERY <script src="http://code.jquery.com/jquery-latest.min.js"></script>


 -->


<!-- 404 : 경로문제 [1. 그 경로/파일 없거나 , 2. 있는데 경로에 오타 -->
<!-- 
	../ : 상위 경로 1번 이동
	
	
	상대경로 : 현위치 기준으로 경로 작성. visitlog/visitlog.jsp"
	절대경로 : 모든 경로 작성. http://localhost/jsp/visitlog/visitlog.jsp
		- 헤더파일은 불특정 페이지 경로에서 사용되므로 절대경로 링크 권장!!
		(생략가능)/jsp/visitlog/visitlog.jsp
	
 -->