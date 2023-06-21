/*
   조건 : 반복문X 입력:prompt 출력 : console 
	   문제 1 : 2개의 정수 를 입력받아서 가장 큰수를 출력 
	   문제 2 : 3개의 정수 를 입력받아서 가장 큰수를 출력     [ max 함수 x ]
	   문제 3 : 4개의 정수 를 입력받아서 가장 큰수를 출력    [ max 함수 x ]
	   
	   *문제 4 : 3개의 정수 를 입력받아서 오름차순 / 내림차순 출력 
	   문제 5 : 4개의 정수 를 입력받아서 오름차순 / 내림차순 출력 
	   
	   문제 6 : 점수를 입력받아 점수 90점이상 합격 출력 아니면 탈락 출력 
	   문제 7 : 점수를 입력받아 점수 90점이상 A등급 출력 
							80점이상 B등급 출력 
							70점이상 C등급 출력  
							그외 재시험
	   *문제 8 : 아이디와 비밀번호 입력받기 
			 회원아이디가 admin 이고 비밀번호가 1234 이면 로그인 성공 출력 
									 아니면 로그인실패 출력

*/

//1.문제
let 정수1 = Number(prompt('정수를입력하시오:'))
let 정수2 = Number(prompt('정수를입력하시오:'))
if (정수1 > 정수2) { console.log('큰수:' + 정수1); }
else { console.log('큰수:' + 정수2); }

//2.문제
let 정수3 = Number(prompt('정수를입력하시오:'));
let 정수4 = Number(prompt('정수를입력하시오:'));
let 정수5 = Number(prompt('정수를입력하시오:'));

if (정수3 > 정수4) { console.log('큰수:' + 정수3); }
else if (정수4 > 정수5) { console.log('큰수:' + 정수4); }
else if (정수3 > 정수5) { console.log('큰수:' + 정수3); }
else { console.log('큰수:' + 정수5); }

//3.문제
let 정수6 = Number(prompt('정수를입력하시오:'));
let 정수7 = Number(prompt('정수를입력하시오:'));
let 정수8 = Number(prompt('정수를입력하시오:'));
let 정수9 = Number(prompt('정수를입력하시오:'));
let max2 = 정수6
if (max2 > 정수7) { max2 = 정수7; }
if (max2 > 정수8) { max2 = 정수8; }
if (max2 > 정수9) { max2 = 정수9; }
console.log(max2)

//4.문제 3개의 정수 를 입력받아서 오름차순 / 내림차순 출력 
let 정수10 = Number(prompt('정수를입력하시오:'));//3
let 정수11 = Number(prompt('정수를입력하시오:'));//5
let 정수12 = Number(prompt('정수를입력하시오:'));//2

//정렬 하나씩 비교를 해서 자리교체
if (정수10 > 정수11) {
	let temp = 정수10;
	정수10 = 정수11;
	정수11 = temp;
}

if (정수10 > 정수12) {
	let temp = 정수10;
	정수10 = 정수12;
	정수12 = temp;
}

if (정수11 > 정수12) {
	let temp = 정수11;
	정수11 = 정수12;
	정수12 = temp;
}
console.log('오름차순:' + 정수10 + " " + 정수11 + " " + 정수12)
if (정수10 < 정수11) {
	let temp = 정수10;
	정수10 = 정수11;
	정수11 = temp;
}

if (정수10 < 정수12) {
	let temp = 정수10;
	정수10 = 정수12;
	정수12 = temp;
}

if (정수11 < 정수12) {
	let temp = 정수11;
	정수11 = 정수12;
	정수12 = temp;
}
console.log('내림차순 : ' + 정수10 + " " + 정수11 + " " + 정수12)
//  문제 5 : 4개의 정수 를 입력받아서 오름차순 / 내림차순 출력
let value = Number(prompt('정수를입력하시오:'));//3
let value2 = Number(prompt('정수를입력하시오:'));//5
let value3 = Number(prompt('정수를입력하시오:'));//2
let value4 = Number(prompt('정수를입력하시오:'));//2
//오름차순
if (value > value2) {
	let temp = value;
	value = value2;
	value2 = temp;
}
if (value > value3) {
	let temp = value3;
	value = value3;
	value3 = temp;
}
if (value > value4) {
	let temp = value4;
	value = value4;
	value4 = temp;
}
if (value2 > value3) {
	let temp = value2;
	value2 = value3;
	value3 = temp;
}
if (value2 > value4) {
	let temp = value4;
	value2 = value4;
	value4 = temp;
}
if (value3 > value4) {
	let temp = value3;
	value3 = value4;
	value4 = temp;
}
console.log('오름차순 :' + value + " " + value2 + " " + value3 + " " + value4)
//내림차순
if (value < value2) {
	let temp = value;
	value = value2;
	value2 = temp;
}
if (value < value3) {
	let temp = value3;
	value = value3;
	value3 = temp;
}
if (value < value4) {
	let temp = value4;
	value = value4;
	value4 = temp;
}
if (value2 < value3) {
	let temp = value2;
	value2 = value3;
	value3 = temp;
}
if (value2 < value4) {
	let temp = value4;
	value2 = value4;
	value4 = temp;
}
if (value3 < value4) {
	let temp = value3;
	value3 = value4;
	value4 = temp;
}
console.log('내림차순 :' + value + " " + value2 + " " + value3 + " " + value4)
// 문제 6 : 점수를 입력받아 점수 90점이상 합격 출력 아니면 탈락 출력 
let 점수 = Number(prompt('점수를입력하시오:'))
if (점수 > 90) { console.log('합격:'); }
else { console.log('탈락:'); }


//문제 7 : 점수를 입력받아 점수 90점이상 A등급 출력 
// 80점이상 B등급 출력 
//70점이상 C등급 출력  
//  그외 재시험
if (점수 >= 90) { console.log('A등급.') }
else if (점수 >= 80) { console.log('B등급.') }
else if (점수 >= 70) { console.log('C등급.') }
else { console.log('재시험') }


//   문제 8 : 아이디와 비밀번호 입력받기 
//회원아이디가 admin 이고 비밀번호가 1234 이면 로그인 성공 출력 
//  아니면 로그인실패 출력
let id = prompt('아이디:');
let pw = prompt('비밀번호:');

if (id == 'admin') {//if st
	if (pw == '1234') {//if st
		console.log('로그인성공');
	}//if end
	else {//else st
		console.log('아이디 오류,로그인실패');
	}//else end
}//if end
else {
	console.log('아이디,비밀번호 오류,로그인실패') ;
}














