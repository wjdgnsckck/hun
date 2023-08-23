console.log("1_AJAX통신")

//1. 예제1
function 예제1() {
	console.log('예제1()실행')
	$.ajax({
		url: "http://localhost/jsp/Test06",    										    	// 1. 통신할 경로
		data:{'value1':'안녕하세요'},
		method: "get",                          			  	     // 2. 통신할 HTTP 메소드 방식 
		success: function 함수명(r) { console.log('서블렛 응답한 내용 :'  +r); },   // 3. 통신을 성공했을때 반환된 데이터
		error: function 함수(){}
	});
}//f end
function 예제2() { // 1. 입력받은 데이터 가져온다.

	console.log('예제2()실행')
	let nameDate= document.querySelector('.name').value;
	let ageData=document.querySelector('.age').value;
	//2.객체화
	let info={
		name : nameDate ,
		age : ageData
	}
	//3. [ 1달 => 배열에 객체 저장 ]
	//3. [ 3달 => 객체를 자바(서블릿)에게 전달 ]
	
	$.ajax({
		url: "http://localhost/jsp/Test07",    										    	// 1. 통신할 경로
		data: info,
		method: "get",                          			  	     // 2. 통신할 HTTP 메소드 방식 
		success: function 함수명(r) { console.log('통신성공:'); },   // 3. 통신을 성공했을때 반환된 데이터
		error: function 함수(){}
	});
}//f end