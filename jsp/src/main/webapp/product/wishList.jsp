<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
		<link href="/jspweb/css/product/wishList.css"rel="stylesheet">
		
		
</head>
<body>
	<%@include file = "../header.jsp" %>
		<div class="container">
	  	
	  		<table class="table table-hover align-middle">
	  			<!-- js 로 뿌려주기 -->
	  		
	  		</table>
	  		<div class="selectbtn">
	  			<button class="btn btn-danger" type="button">선택 삭제</button>
	  			<button class="btn btn-danger" type="button">전체 삭제</button>
	  		</div>
	  		
	  		<div class="buybtn">
	  			<button class="btn btn-success" type="button">선택 구매</button>
	  			<button class="btn btn-success"type="button">전체 구매</button>
	  		</div>
	  	
		</div>
	
	<script src="/jspweb/js/product/wishList.js" type="text/javascript"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>