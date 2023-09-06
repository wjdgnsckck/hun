<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="../css/member.css" rel ="stylesheet">

</head>
<body>

	<%@include file="../header.jsp" %>
	
	<div class= "webcontainer">	<!--회원가입 전체구역  -->
		<form class="signupForm">
			<h2>마이페이지</h2>
			
			<div class="intitle">프로필 변경</div>
			<input onchange="preimg( this )" name="mimg"  class="mimg" type="file" accept="image/*"/>
			<img class="preimg" alt="" src="img/default.webp"> <!-- 등록 사진을 미리보기 할 사진 태그  -->
			
			<div class="intitle">아이디</div>
			<div class="mid"></div>
		
			
			<div class="intitle">비밀번호</div>
			<div class="memail"></div>
			
			
			<div class="intitle">기존 비밀번호</div>
			<input maxlength="20" name="mpwd"  class="mpwd" type="password"/><br/>
			
			<div class="intitle">새로운 비밀번호 </div>
			<input maxlength="20"  name="newMpwd" class="mpwdconfirm" type="password"/>
		
	
		
			<button class="signupbtn" onclick="mupdate()" type="button">수정</button>
			<button class="signupbtn" onclick="mdelete()" type="button">탈퇴</button>
		</form>
	</div>
		<script src="../js/signup.js" type="text/javascript"></script>
		<script src="../js/info.js" type="text/javascript"></script>

</body>
</html>