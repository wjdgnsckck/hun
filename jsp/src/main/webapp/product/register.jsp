<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../header.jsp"%>
	<div class="webcontainer">
	
		<form class="registerForm">
			카테고리 : <select name = "pno">
						<option value="1"> 노트북 </option>
						<option value="2"> 태블릿 </option>
						<option value="3"> 냉장고 </option>
					</select></br>
			제품명 : <input name="pname" type="text"></br>
			제품설명 : <textarea  name="pcontent"></textarea></br>
			제품가격 : <input name="pprice" type="text"></br>
			제품위치 : <div id="map" style="width:100%;height:350px;"></div>
						<p><em>지도를 클릭해주세요!</em></p> 
						<div id="clickLatlng"></div>
			
			<!--1. 첨부파일 1개일때  -->
			<!--  제품이미지 : <input type="file"></br>-->
			<!--2. 첨부파일 2개일때  -->
			<div class="fileDropBox" style="width : 200px ; height:100px; border : 1px solid red;">
				여기에 드래그 해서 파일을 올려주세요
				
			</div>
			
			
			<button onclick="onRegister()" type="button">전송</button>
		</form>
	</div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=35439badb1220aad48f6df6be361a1cf"></script>
	<script src="/jspweb/js/index.js"  type="text/javascript"></script>
	<script src="/jspweb/js/product/register.js"  type="text/javascript"></script>
</body>
</html>