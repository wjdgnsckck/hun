<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
		
		<%@include file="../header.jsp" %>
	
	<!-- 
		부트스트랩 class
		container
		text-center
		row justify-content-md-center
		col-8"
	 -->
	
	
	
	<div class ="container"><!-- 부트스트립 박스권 -->
			<h4 class="title text-center mt-5 mb-2" ></h4>
			<p class="writedate text-center" style="font-size:10px"></p>
			<div class="row justify-content-md-center">
					<div class="content col-8" style="min-height:500px"></div>
			</div>
			
			<div	class="row justify-content-md-center gx-3">
				<div class="col-2 "><input onclick="onDelete()" class="form-control btn btn-outline-primary"	type="button" value="삭제하기"></div>
				<div class="col-2">  <a href="update.jsp"><input class="form-control btn btn-outline-success"type="button" value="수정하기"></a></div>
				<div class="col-2">   <a href="list.jsp"><input class="form-control btn btn-outline-danger"type="button" value="목록보기"></a></div>
			</div>
	</div>
		
		
		<%@include file="../footer.jsp" %>
		<!-- 부트스트랩 -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
		
		<script src="../js/view.js"     type="text/javascript"></script>
</body>
</html>