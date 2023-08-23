console.log('1_AJAX통신.js Open')

//1. 예제1
function 예제1() {
	console.log('예제1()실행')
	$.ajax({
		url: "/jsp/Test02",    										    	// 1. 통신할 경로
		method: "get",                          			  	     // 2. 통신할 HTTP 메소드 방식 
		success: function 함수명(result) { console.log(result); }   // 3. 통신을 성공했을때 반환된 데이터
	});
}//f end
function 예제2() {//f start
	console.log('예제2()실행')
	$.ajax({
		url: "/jsp/Test03",    										    	// 1. 통신할 경로
		method: "get",                          			  	     // 2. 통신할 HTTP 메소드 방식 
		success: function 함수명(result) { console.log(result); }   // 3. 통신을 성공했을때 반환된 데이터
	});
}//f end
function 예제3() {//f start
	console.log('예제3()실행')
	$.ajax({
		url: "/jsp/Test04",    										    	// 1. 통신할 경로
		method: "get",                          			  	     // 2. 통신할 HTTP 메소드 방식 
		success: function 함수명(result) { console.log(result);
		console.log(result.title);
		console.log(result.content); }   // 3. 통신을 성공했을때 반환된 데이터
	});
}//f end

function 예제4() {//f start
	console.log('예제4()실행')
	$.ajax({
		url: "/jsp/Test05",    										    	// 1. 통신할 경로
		method: "get",                          			  	     // 2. 통신할 HTTP 메소드 방식 
		success: function 함수명(result) { console.log(result);
		console.log(result.title);
		console.log(result.content); }   // 3. 통신을 성공했을때 반환된 데이터
	});
}//f end


/*
-----------------------------------------
내장객체 : 서블릿
	- request : 요청 객체
	- response : 응답 객체
		- 	response.getWriter().append(데이터) :웹 출력 = 응답 데이터
		-	response.getWriter().print : 웹 출력 = 응답 데이터
		-   response.setContentType("전송할데이터타입명;인코딩타입") :
		 출력할 데이터의 타입 혹은 인코딩
			- 1. 문자전송[default]
			   response.setContentType("text/html;charset=UTF-8");
			- 2. JSON전송 
			   response.setContentType("application/json;charset=UTF-8");
 */