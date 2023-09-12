
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
			\d		: 숫자0~9 패턴 검색
			[가-힣]	: 한글 패턴
			{ 최소길이 , 최대길이 } : 문자열 길이 패턴
			+ : 앞 에 있는 패턴 1개 이상 반복
			? : 앞 에 있는 패턴0개 혹은 1개 이상 반복
			* : 앞 에 있는 패턴0개 반복
			
			
			예시]
				1.[a-z] 				: 소문자a-z 패턴
				2.[a-zA-Z]				: 영문(대,소) 패턴
				3.[a-zA-Z0-9]			: 영문 + 숫자 조합 패턴
				4.[a-zA-Z0-9가-힣]		: 영문 + 숫자 한글 조합 패턴
				5.[ac]					: a와c 패턴
				6.(?=.*[패턴문자]) 		: 해당 패턴문자가 한개 이상 포함된 패턴
					(?=.*[a-z])			: 소문자 한개 이상 필수
					(?=.*[A-Z])			: 대문자 한개 이상 필수
					(?=.*[\d])			: 숫자 한개 이상 필수
					(?=.*[0-9])			: 숫자 한개 이상 필수
					(?=.*[!@#$%^*])		: 패턴문자내 특수문자 한개 이상 필수
					
				/^[A-Za-z0-9]{5,20}$/
				영대소문자 + 숫자 조합의 5~20글자 사이	
				/^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^*])[A-Za-z0-9]{5,20}$/
				영대문자1개 + 영소문자1개 + 숫자 1개 이상 필수로 갖는
				
				/^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^*])[A-Za-z0-9]{5,20}$/
				영대문자1개 + 영소문자1개 + 숫자 1개 + 특수문자 1개 이상 필수로 갖는 5~20글자 사이				
				
			1./^[a-z0-9]{5,30}$/			:영소문자+숫자 조합 5~30 글자
			2./^(?=.*[A-Za-z])(?=.*[\d])[A-Za-z\d]{5,20}$/	 :영대소문자 (1개이상)+숫자 (1개이상) 영대소문자 +숫자 5~20글자
			3./^(?=.*[A-Za-z])(?=.*[\d])[A-Za-z0-9]{5,20}$/	 :영대소문자 (1개이상)+숫자 (1개이상) 영대소문자 +숫자 5~20글자
			 0-9 와 \d 는 동일한 식이다!
			 
			패턴 검사 
				"패턴".test(검사할데이터) : 해당 데이터가 패턴에 일치하면 true 아니면 false

*/

//1. 아이디 유효성 검사.
function idcheck() { /* 실행조건 : 아이디 입력창이 입력할때마다 */

	//1. 값 호출
	let mid = document.querySelector('.mid').value;
	let idcheck = document.querySelector('.idcheckbox');
	//2. 유효성검사
	//제어문 이용한 검사 if(mid.length<=10 && mid.mid.length>=20){}
	///^[a-z0-9]{5,20} $/; 영문 + 숫자 조합의 5~20글자 사이 이면
	//1.  아이디는  영문 + 숫자 조합의 5~20글자 사이 이면
	//1. 정규표현식 작성.
	let midj = /^[a-z0-9]{5,20}$/
	//2. 정규효션식 검사.
	console.log(midj.test(mid));
	if (midj.test(mid)) {//패턴과 입력한 값이 일치하면
		idcheck.innerHTML = '패턴합격';

		//-- 입력한 아이디랑 패턴과 일치하면 아이디 중복검사
		$.ajax({
			url: "/jspweb/MemberFindController",
			method: "get",
			data: { type: "mid", data: mid },
			success: r => {
				if (r) { idcheck.innerHTML = "사용중인 아이디입니다.";checkList[0]=false; }
				else { idcheck.innerHTML = "사용가능한 아이디입니다.";checkList[0]=true; }
			},
			error: r => { }
		})
	} else {//패턴과 입력한 값이 일치하지 않으면
		idcheck.innerHTML = '영문(소문자)+숫자 조합의 5~20글자 가능합니다.' ; checkList[0]=false;;
	}

	//3. 결과 출력

}
//비밀번호 유효성 검사 [ 1. 정규표현식 검사 2.비밀번호와 비밀번호 확인 일치여부]
function pwcheck() {
	let pwcheckbox = document.querySelector('.pwcheckbox');
	//1.입력값 호출
	let mpwd = document.querySelector('.mpwd').value; console.log("mpwd:" + mpwd);
	let mpwdconfirm = document.querySelector('.mpwdconfirm').value;

	//2.유효성검사
	//1. 정규표현식 만들기 [ 영대소문자 +숫자 조합 5~20글자 사이]
	let mpwdj = /^(?=.*[A-Za-z])(?=.*[\d])[A-Za-z\d]{5,20}$/
	if (mpwdj.test(mpwd)) {

		//비밀번호 확인 정규표현식 검사
		if (mpwdj.test(mpwdconfirm)) {
			//3. 비밀번호 와 비밀번호 확인 일치여부
			if (mpwd == mpwdconfirm) {
				pwcheckbox.innerHTML = `사용가능한 비밀번호`;checkList[1]=true;
			}
			else { pwcheckbox.innerHTML = `사용불가능한 비밀번호`;checkList[1]=false; }
		}
		else {
			pwcheckbox.innerHTML = `영대소문자1개이상+숫자1개이상 5글자~20글자 사이 입력해주세요`
					;checkList[1]=false;
		}


	} else {
		pwcheckbox.innerHTML = `영대소문자1개이상+숫자1개이상 5글자~20글자 사이 입력해주세요`
		checkList[1]=false;

	}
}



//3. 이메일 유효성 검사 [1. 정규표현식 2.중복검사]
function emailcheck() {
	let emailcheckbox = document.querySelector('.emailcheckbox');
	let authReqBtn = document.querySelector('.authReqBtn');
	//1. 입력된 값 호출
	let memail = document.querySelector('.memail').value;

	//2. 이메일 정규표현식 [ 영대소문자,숫자,_-@]
	//ex) itdanja@kakao.com
	// 1. itdanja : 이메일 아이디부분 은 영대소문자 , 숫자,_- 패턴
	// 2. @  	  : +@		 @ 앞에 패턴이 1개이상 필수
	// 3. 도메인 
	// 회사명 : @ 뒤에 그리고 . 앞에 패턴은 a-zZ-Z0-9_-
	// . 	: +\. : . 앞에 패턴이 1개이상 필수
	// 도메인	: . 뒤에 패턴은 a-zA-Z
	let memailj = /^[a-zA-Z\d_-]+@[a-zA-Z0-9_-]+\.[a-zA-Z]+$/

	//3. 유효성검사
	if (memailj.test(memail)) {
		$.ajax({
			url: "/jspweb/MemberFindController",
			method: "get",
			// type 사용하는 이유 : 서로 다른 ajax가 동일한 서블릿과 동일한 get메서드를 사용하기위해
			data: { type: "memail", data: memail },
			//data : { type : "mid" ,mid:mid} , 아이디 중복검사
			success: r => {
				if (r) {
					emailcheckbox.innerHTML = `사용중인 이메일입니다.`;checkList[2]=false;
					authReqBtn.disabled = false;
				} else {
					emailcheckbox.innerHTML = `사용가능한 이메일입니다.`;checkList[2]=true;
					authReqBtn.disabled = false;
				}
			},
			error: r => { console.log(r) }

		})

	} else {
		emailcheckbox.innerHTML = `이메일형식에 맞게 입력해주세요.`
		authReqBtn.disabled = true;
		checkList[2]=false;
	}
}



//4.인증요청 버튼을 눌렀을때
function authReq() {

	let authbox = document.querySelector('.authbox');
		
			//2.authbox html 구성
			let html = `<span class="timebox">02:00</span>
						<input class="ecode" type="text"/>
						<button onclick="auth()" type="button">인증</button><br/>`
			//3. authbox html  대입
			authbox.innerHTML = html;
		
			//4. 타이머 실행
			authcode = "1234" ; 	  // [Controller(서블릿)에서 전달받은 값이 인증코드]
			timer = 120;	  //인증 제한시간 10초 테스트용
			settimer();		  //타이머 실행

	/*//-- 인증요청시 서블릿 통신 [ 인증코드 생성 , 이메일전송 ]
	$.ajax({
		url:"/jspweb/AuthSendEmail",
		method:"get",
		data:{memail:document.querySelector('.memail').value},
		success : r=>{
			console.log(r)
			
			//1. div 호출
			let authbox = document.querySelector('.authbox');
		
			//2.authbox html 구성
			let html = `<span class="timebox">02:00</span>
						<input class="ecode" type="text"/>
						<button onclick="auth()" type="button">인증</button><br/>`
			//3. authbox html  대입
			authbox.innerHTML = html;
		
			//4. 타이머 실행
			authcode = r ; 	  // [Controller(서블릿)에서 전달받은 값이 인증코드]
			timer = 120;	  //인증 제한시간 10초 테스트용
			settimer();		  //타이머 실행
		},
		error: e=>{console.log(e)}
		
	})*/
}//f end

//4번,5번,6번 함수에서 공통적으로 사용할 변수[ 전역변수 ]
let timer = 0;	//인증 시간 (초)변수
let timerInter;	//setInterval() 함수를 가지고 있는 변수 [ 종료시 사용한다. ]
let authcode = '1234';
//5.타이머 함수 만들기

function settimer() {
	//setInterval (함수명 , 실행 간격 [밀리초]) : 특정시간마다 함수를 실행
	//setInterval( ()=> {console.log('안녕')},1000);
	timerInter = setInterval(() => {

		//시간형식 만들기
		//분 만들기
		let m = parseInt(timer / 60);  //분 계산[몫]
		let s = parseInt(timer % 60); //초 계산[나머지]
		//2. 두자리수 맞춤 3 -> 03
		m = m < 10 ? '0' + m : m; //만약에 분이 한자리수 이면 0붙이고 아니면 그냥 사용
		s = s < 10 ? '0' + s : s; //만약에 초가 한자리수 이면 0붙이고 아니면 그냥 사용

		document.querySelector('.timebox').innerHTML = `${m}:${s}`; 	// 현재 인증 시간(초) HTML대입
		timer--; //1씩 차감 

		//만약에 타이머가 0보다 작으면 [ 시간 끝 ]
		if (timer < 0) {
			//1.setInterval 종료
			clearInterval(timerInter)
			//2. 인증실패 알림
			document.querySelector('.emailcheckbox').innerHTML = `인증실패`; checkList[2]=false;
			//3. authbox 다시 숨기기
			document.querySelector('.authbox').innerHTML = ``;
		}

	}, 1000);	//1초에 한번씩 실행되는 함수

}//f end


//6. 인증요청후 인증코드를 입력하고 인증하는 함수
function auth() {
	//1.입력받은 인증코드 
	let ecode = document.querySelector('.ecode').value;

	//2.비교 [인증코드와 입력받은 코드를 비교하기]
	if (authcode == ecode) {
		//1. setInterval종료
		clearInterval(timerInter)
	
		//2. 인증성공 알림
		document.querySelector('.emailcheckbox').innerHTML=`인증성공` ;checkList[2]=true;
		//3. authbox 구역 HTML 초기화
		document.querySelector('.authbox').innerHTML=``;
	}
	else {
		//1. 인증코드 불일치 알림
		document.querySelector('.emailcheckbox').innerHTML=`인증코드 불일치`;checkList[2]=false;
	}
}// f end

//7. 첨부파일에  등록된 사진을 HTML 표시하기 < 등록 사진을 미리보기 기능>
function preimg(object){console.log('사진 선택 변경')
	console.log(object) // 이벤트 발생시킨 태그의 DOM객체를 인수로 받음
	//console.log(document.querySelector('.mimg'))
	//1. input태그의 속성 [ type,class,onchange,name 등등]
	//2. input태그 이면서 type="file" 이면 추가적인 속성
		//.files : input type = "file" 에 선택한 파일 정보를 리스트로 받음
	console.log(object.files[0]); // 리스트중에서 하나의 파일만 가져오기
	
	// --- 해당 파일을 바이트코드 변환
	// 2. JS 파일클래스 선언
	let file = new FileReader(); // 파일 읽기 클래스 이용한 파일읽기객체 선언
	// 3. 파일 읽어오기 함수 제공
	file.readAsDataURL(object.files[0]); // input 에 등록된 파일리스트중 1개를 파일객체로 읽어오기
	console.log(file)
	//4. 읽어온 파일을 해당 html img태그에 load
	file.onload = e => { //onload() :  읽어온 파일의 바이트코드를 불러오기
	console.log(e)  ; // e : 이벤트 정보
		console.log(e.target.result) // onload() 실행한 FileReader 객체
		document.querySelector('.preimg').src=e.target.result}
	
	

}// f end
let checkList = [false , false , false] // [0] : 아이디 통과  [1] :비밀번호 통과 [2] : 이메일 통과
	//true 이면 통과 , false 이면 불통
// 8. 회원가입 메소드
function signup(){
	console.log(checkList)
	if(checkList[0]==true&&checkList[1]==true&&checkList[2]==true){
		console.log('회원가입성공')
		
		//2. 입력받은 데이터를 한번에 가져오기 form태그 사용
			//<form> 각종 input/button </form>
			let signupForm =document.querySelectorAll('.signupForm')[0];
			console.log(signupForm)
			//2. form 데이터 객체화
			let signupData = new FormData(signupForm);
			//console.log(signupData);
			//3. AJAX 에게 첨부파일 [대용량]파일 전송
				//1. 첨부파일 없을때.
					/*	$.ajax({
							url: "",
							method: "",
							data: info,
							success: r => {  },
							error: e => { }
							})
							*/
				//2. 첨부파일 있을때 . []
				$.ajax({
							url: "/jspweb/MemberController",
							method: "post",		//첨부파일 form 전송은 무조건 post 방식
							data: signupData ,
							contentType:false,
							processData:false,
							success: r => { 
							
								if(r){	//회원가입에 성공하면
									alert('회원가입성공');
									location.href='/jspweb/member/login.jspweb';
								}
								else{//회원가입에 실패하면
									alert('회원가입 실패')
								}
								
								
							 },
							error: e => {console.log(e) }
							})
	
	}else{alert('정상으로 입력이 안된 내용이 있습니다!') }
	
}



//0. 유효성 검사가없는 회원가입 메소드
//-- 유효성검사가 없는 회원가입 메소드
/*
function signup() {
	let mid = document.querySelector('.mid');
	let mpwd = document.querySelector('.mpwd');
	let mpwdconfirm = document.querySelector('.mpwdconfirm');
	let memail = document.querySelector('.memail');
	let mimg = document.querySelector('.mimg');


	//2. (객체화)
	let info = {
		mid: mid.value,
		mpwd: mpwd.value,
		mpwdconfirm: mpwdconfirm.value,
		memail: memail.value,
		mimg: mimg.value
	}
	//3. 유효성검사

	//4. AJAX메소드를 이용한 Servlet 와 통신
	$.ajax({
		url: "/jspweb/MemberController",
		method: "post",
		data: info,
		success: r => { if (r == true) { alert('회원가입성공') } },
		error: e => { }
	})

	//5. Servlet 의 응답에 따른 제어
}
*/
