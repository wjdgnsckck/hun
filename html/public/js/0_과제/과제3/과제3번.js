/*

	<주요기능1 -등록>
	1. HTML 작성	:input 3개 button 1개
	2. button 클릭했을때 입력받은 input 3개 저장하는 이벤트
	3.
		무슨이벤트 =정의 =구체적인 이벤트 내용물
		-등록버튼 클릭시 함수 실행
		1.input 입력된 3개 데이터를 모두 가져오기
			1.마크업 선택자 필수!
			1. 호출할 마크업의 선택자 필수!!
					선택자 : 마크업 식별하는 방법
						1.class,id,마크업
		2.DOM객체 함수를 이용한 선택자의 마크업 객체로 호출			
				1.document.getElementByClass("클래스명")
				2.document.querySelector(".클래스명")
		3. DOM 객체 호출
			input ,textarea , select => value속성
			div ,span, table 등등 => value 속성x
			
		2.배열에 저장 
			*배열은 여러개 데이터를 저장할수 있다.
			*함수는 종료되는 순간 = { } 에서 사용되었던 메모리는 모두 초기화
		<배열 선언>
			날짜,항목,금액
			1. 인덱스 순으로 데이터 형태 구분 
							0 3 6 9 12 =날짜 인덱스
							1 4 7 10 13 = 항목 인덱스
							2 5 8 11 14 = 금액 인덱스
				let 가계부 =['2023-06-27' , '콜라' , '10000 ' ,'2023-06-27' , '사이다' , '3000 '] 
			2.
				각 배열당 0번 인덱스가 '2023-06-27' , '콜라' , '10000'
				
				let 가계부_날짜 = [' 2023 - 06 -27' ,'2023 - 06 - 27']
				let 가계부_항목 =[ '콜라 ' , '사이다 ']
				let 가계부_금액 =['10000' , '3000']
		<배열 저장>
		
			1.(저장 하기전)유효성검사 = 데이터 검사/필터링	
			
			push 
			
			2.(저장 성공후)
     <주요기능2-출력>
     	1. HTML 작성 :출력 예상 HTML
     	2. 출력이벤트 생성	
     		1.입장했을때	-> JS 열렸을때
     		2.등록했을때	-> JS등록함수 push 밑에
     		3.삭제했을때  -> JS 삭제함수 안에 splice했을때 밑에
     	3.함수 정의
     		*배열에 있는값을 테이블로 출력
     		1.테이블 마크업 객체로 호출
     		
     		2.테이블 안에 넣을 HTML 구성
     		
     		3.테이블안에 구성된 HTML 넣어줌
     <주요기능3 -삭제>
     	1.HTML 작성 button
     	2.삭제 이벤트는 언제?	button 클릭시!
     	<button onclick="삭제()">삭제</button>
     	3.삭제 함수 정의
     	*무엇을?? 인수로 삭제할 인덱수 번호를 받는다.[배열은 주로 식별자역할=인덱스(중복x)]
     	<button onclick="삭제(삭제할인덱스번호)">삭제</button>
     	1.삭제할 인덱스 번호를 인수로 받는다.
     	
     	2.인수로 받은 인덱스번호에 해당하는 배열내 인덱스 삭제=splice
 */
// 입력받은 데이터 여러개를 저장하기 위한 배열3개 
let 날짜배열=[]
let 항목배열=[]
let 금액배열=[]
//1. 등록 버튼 클릭했을때 이벤트
console.log('js 열림')
출력();			//JS 열렸을때 최초 1번 실행
function 등록(){console.log('등록함수 클릭');
	
	//1.
	//document.getElementByClass("클래스명")
	let dateInput =document.querySelector(".date")
	let nameInput=document.querySelector(".name")
	let moneyInput=document.querySelector(".money")
	
	console.log(dateInput)
	console.log(nameInput)
	console.log(moneyInput)
	
	//2. 태그의 입력된 값 호출
	let date = dateInput.value	;		console.log(date)
	let name = nameInput.value	;		console.log(name)
	let money = moneyInput.value ;	console.log(money)
	
	//* 유효성검사		:	만약에 3가지중에 하나라도 공백이면
	if( date==''	||	name==''	||	money==''){
			alert('미입력이 존재합니다.[등록불가]');
			return;		//함수 강제종료 // return 실행되면 아래 코드는 실행x
	}
	//3. 배열저장
	날짜배열.push(date);					console.log(날짜배열)
	항목배열.push(name);					console.log(항목배열)
	금액배열.push(money);				console.log(금액배열)
	출력();
	// * 저장 성공시 input 상자 초기화
	alert('항목 등록 성공')
		dateInput.value=``
		nameInput.value=``
		moneyInput.value=``
	
}// f end
function 출력(){
	console.log('가계부목록 출력합니다.');
	// 1. 어디에 출력할껀지?? table 가져오기
	let outputTalbe= document.querySelector('.outputTable')
	
	//2. 무엇을???
	let html=`<tr>
				<th>날짜</th>
				<th>항목</th>
				<th>가격</th>
				<th>비고</th>
			</tr>`
		for(i=0 ; i<날짜배열.length ; i++){
		html+=`<tr>	
				<td> ${날짜배열[i]}</td>
				<td>${항목배열[i]}</td>
				<td>${금액배열[i].toLocaleString()}원</td>
				<td><button onclick="삭제(${i})">삭제</button></td>
			</tr>		`
			console.log(i)
	}		

	//undefined : 정의된게 없다 / 데이터가 없다 / 등록안했는데 먼저 출력했으니 오류발생
	//*요구사항 : 총합계 계산 (금액배열에 있는 데이터 모두 더하기)
			//0번 인덱스의 데이터부터 마지막 인덱스의 데이터까지를 누적
	let 총합계 = 0;
	for(let 인덱스 = 0 ; 인덱스 <금액배열.length; 인덱스++){
		console.log(인덱스);					//배열에 저장된 순서번호
		console.log(금액배열[인덱스]);		//배열에 저장된 순서번호에 저장된 데이터
		총합계+=Number(금액배열[인덱스]);		//text=문자열이라 숫자 출력x Number 사용
														//Number('숫자') push  에서 사용하길 권장
	}//f end
	console.log('총합계 :' +총합계);
	
	html +=`<tr>
					<td colspan="2">총합계</td>
					<td colspan="2">${총합계.toLocaleString()}원</td>	
					
				<tr>
					`
	//2. table에 HTML 넣어주기		<table>inner</table>
	outputTalbe.innerHTML	=	html;
}
//삭제 이벤트 함수
function 삭제(삭제할인덱스번호){
	console.log('삭제할인덱스번호:'+삭제할인덱스번호)
	날짜배열.splice(삭제할인덱스번호 ,1)
	항목배열.splice(삭제할인덱스번호 ,1)
	금액배열.splice(삭제할인덱스번호 ,1)
	//테이블/화면  업데이트 /새로고침
	출력()
}








