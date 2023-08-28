<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href = "library.css" rel="stylesheet" />
</head>
<body>

   
   <div class="wrap">
      <div class = "sitBtnView">
      
      </div>
      <div class = "sitInputView">
         <input class ="nameInput" type="text" placeholder="이름">
         <input class="phoneInput" type="text" placeholder="전화번호">
      </div>
      
      <button class="input" onclick="enterace()">입실</button> 
      <button class="output" onclick="leave()">퇴실</button>
      

   </div>
   
   


   <!-- 최신 JQUERY 불러오기 : AJAX메소드 사용하기 위해 : JS가 외부로부터 통신하기 위해 -->
   <script src="http://code.jquery.com/jquery-latest.min.js"></script>
   
   <!-- js import -->
   <script src="library.js" type="text/javascript"></script>
</body>
</html>