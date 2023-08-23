<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- css import -->
	<link href="visitlog.css" rel = "stylesheet"/>
</head>
<body>
	<!--CRUD 기반의 비회원 게시판/방문록 구현  -->
	<div class ="visitwrap"><!-- 전체구역  -->
	
		<div class ="visit_Top"><!-- 쓰기 구역  -->
			<div class="visit_Inputs">
				<input class="vwirter" type="text" placeholder="작성자">
				<input class="vpwd" type="text" placeholder="비밀번호">
			</div>
			<textarea class="vcontent" placeholder="방문록내용"></textarea> 
			<button onclick="vwrite()"type="button">등록</button>
		</div>
		<!-- js 가 출력되는 구역  -->
		<div class = "visit_Bottom"><!-- 출력 구역  -->
			
			<div class = "visitbox">	<!--  방문록 1개의 표시구역  -->
				<div class="visit_top">
					<div>유재석</div>
					<div class="visitdate">2023-08-22 13:30:50</div>
				</div>
				<div class="visit_center"> 안녕하세요.안녕하세요.안녕하세요.안녕하세요.</div>
				<div class="visit_bottom">
					<button type="button">수정</button>
					<button type="button">삭제</button>
				</div>
			</div>
		</div>
	
	</div>
	<table>
		
	</table>
	<!--ajax  -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!--js  import  -->
	<script src="visitlog.js" type="text/javascript"></script>
	
</body>
</html>