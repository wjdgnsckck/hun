
/* onchange : 포커스(커서) 변경될때 
   onkeyup  : 키보드에서 키를 누르고 떼었을때 
   onkeydown : 키보드에서 키를 눌렀을때
*/


/*
	정규표현식 : 문자열에 특정 규칙/패턴 집합 표현할때 사용되는 언어
		문법
			/^ 		: 정규표현식 시작 알림.
			$/		: 정규표현식 끝 알림.
			[a-z] 	: 소문자 a-z 패턴 검색
			[A-Z]	: 대문자 A-Z 패턴 검색
			[0-9]	: 숫자0~9 패턴 검색
			[가-힣]	: 한글 패턴
			{ 최소길이 , 최대길이 }
			
			
			예시]
				1.[a-z] 			: 소문자a-z 패턴
				2.[a-zA-Z]			: 영문(대,소) 패턴
				3.[a-zA-Z0-9]		: 영문 + 숫자 조합 패턴
				4.[a-zA-Z0-9가-힣]	: 영문 + 숫자 한글 조합 패턴
				5.[ac]				: a와c 패턴

			패턴 검사 
				"패턴".test(검사할데이터) : 해당 데이터가 패턴에 일치하면 true 아니면 false

*/

//1. 아이디 유효성 검사.
function idcheck(){ /* 실행조건 : 아이디 입력창이 입력할때마다 */
	
	//1. 값 호출
		let mid = document.querySelector('.mid').value;
		let idcheck = document.querySelector('.idcheckbox');
	//2. 유효성검사
		//제어문 이용한 검사 if(mid.length<=10 && mid.mid.length>=20){}
		///^[a-z0-9]{5,20} $/; 영문 + 숫자 조합의 5~20글자 사이 이면
		//1.  아이디는  영문 + 숫자 조합의 5~20글자 사이 이면
				//1. 정규표현식 작성.
		let midj =/^[a-z0-9]{5,20}$/
				//2. 정규효션식 검사.
				console.log(midj.test(mid));
		if(midj.test(mid)){//패턴과 입력한 값이 일치하면
		idcheck.innerHTML='패턴합격';
			
			//-- 입력한 아이디랑 패턴과 일치하면 아이디 중복검사
			$.ajax({
      url : "/jsp/MemberFindController",
      method : "get",
      data : {mid:mid} ,
      success : r=>{if(r){idcheck.innerHTML="사용중인 아이디입니다."}
      				else{idcheck.innerHTML="사용가능한 아이디입니다."}
      } ,
      error : r=>{}
   })
		}else{//패턴과 입력한 값이 일치하지 않으면
		idcheck.innerHTML='영문(소문자)+숫자 조합의 5~20글자 가능합니다.';	}
		
	//3. 결과 출력

}





//-- 회원가입 메소드
function signup(){
	let mid = document.querySelector('.mid');
	let mpwd = document.querySelector('.mpwd');
	let mpwdconfirm = document.querySelector('.mpwdconfirm');
	let memail = document.querySelector('.memail');
	let mimg = document.querySelector('.mimg');
	
	
	//2. (객체화)
	let info={
		mid : mid.value , 
		mpwd : mpwd.value,
		mpwdconfirm :mpwdconfirm.value,
		memail : memail.value,
		mimg : mimg.value
	}
	//3. 유효성검사
	
	//4. AJAX메소드를 이용한 Servlet 와 통신
	$.ajax({
      url : "/jsp/MemberController",
      method : "post",
      data : info ,
      success : r  => {if(r==true){alert('회원가입성공')}},
      error : e=>{}
   })
			
			//5. Servlet 의 응답에 따른 제어
}

function login(){}