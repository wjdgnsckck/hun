<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<!--부트스트랩 css 불러오기  -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<!-- 썸머노트 css 불러오기 -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/summernote-bs5.min.css" rel="stylesheet">
	
	<!-- 
		썸머노트[부트스트랩/JQUEY 라이브러리 기반으로 생성된 에디터
		1.설치
			1. <link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/summernote-lite.min.css" rel="stylesheet">
			2. <script src="http://code.jquery.com/jquery-latest.min.js"></script>
			3. <script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/summernote-lite.min.js"></script>
			4. <script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/lang/summernote-ko-KR.min.js"></script>
		2.
	
	
	 -->

</head>
<body>


<%@include file="../header.jsp" %>
	<div class="container">
		<input class="form-control my-3 title" type="text" placeholder="제목">
		<textarea  id="summernote" class="form-control my-3"  rows="10" cols="" placeholder="내용"></textarea>
		<input class="form-control my-3" type="file"/>
		
		<div	class="row justify-content-md-center gx-3">
		<div class="col-1 "><input onclick="onWrite()" class="form-control btn btn-outline-primary"	type="button" value="등록"></div>
		<div class="col-1"><input class="form-control btn btn-outline-success"type="button" value="다시쓰기"></div>
		<div class="col-1"><input class="form-control btn btn-outline-danger"type="button" value="목록보기"></div>
		</div>
	</div>
	
	
	<%@include file="../footer.jsp" %>
	<!--부트스트랩 js 불러오기  -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
	
	<!-- jquery : js 라이브러리 -->
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	
	<!-- 썸머노트 js 불러오기 -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/summernote-bs5.min.js"></script>
	
	<!--썸머노트 한글 적용 -->
	<script src=" https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/lang/summernote-ko-KR.min.js"></script>
	
	
	<!-- js 호출  -->
		<script   src="../js/write.js"  type="text/javascript"></script>
	<!-- js적용 -->
	
</body>
</html>