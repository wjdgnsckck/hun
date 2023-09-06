<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="hrm.css" rel ="stylesheet">
</head>
<body>

		<%@include file="../header.jsp"%>
		<div>
			<form class="hrmForm">
				<div><!--상단   -->
					<h3>이젠 인사관리</h3>
					<div>직원사진
					<input onchange="preimg(this)" name="himg"  class="himg" type="file" accept="image/*"/>
					<img class="preimg" alt="" src="img/default.webp">
					</div>
					<input maxlength="20" name="hname" class="hname" type="text" placeholder="직원명">
					<input  maxlength="20"name="hphone"  class="hphone" type="text" placeholder="직원전화번호">
					<select name="hrank" class="hrank">
						<option value="1">사장</option>
						<option value="2">부장</option>
						<option value="3">팀장</option>
						<option value="4">대리</option>
						<option value="5">주임</option>
						<option value="6">사원</option>
					</select>
					<button onclick="regis()" class="regis" type="button">등록</button>
				</div>
				<div class="hrmbtn"> <!--하단 내용 읽기 js에서 뿌려줌  -->
			
				</div>
			</form>
		</div>
		
		<script src="hrm.js" type="text/javascript"></script>
</body>
</html>