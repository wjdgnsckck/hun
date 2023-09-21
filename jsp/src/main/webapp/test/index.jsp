<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="currentRoom"></div>
	<button onclick="onRoom(1)" type="button">1번방 입장</button>
	<button onclick="onRoom(2)" type="button">2번방 입장</button>
	<button onclick="onRoom(3)" type="button">3번방 입장</button>
	<button onclick="onRoom(4)" type="button">4번방 입장</button>
	<button onclick="onRoom(5)" type="button">5번방 입장</button>
	<br/><br/><br/>
	<textarea class="msgbox"></textarea>
	<button onclick="msgsend()" type="button">전송</button>
	
	<div class="msgList">
	
	</div>
	
	<script src="index.js" type="text/javascript"></script>
</body>
</html>