/* */

let 아이디 =[]
let 비밀번호=[]
/* 회원가입 조건 
	1.아이디 중복x
	2.비밀번호 중복x
	3.아이디 비밀번호가 같아야함	 */
function create_id(){	//f start
	let idInput = document.querySelector('.id')	//(class)id 입력값 idInput에 저장
	let Id=idInput.value						//idInput값 Id에 저장
	let pwInput = document.querySelector('.pw')	//(class)pw 입력값 pwInput에 저장	
	let Pw=pwInput.value						//PwInput값 Pw에 저장
		
	
	if(Id==''||Pw==''){		//if문 사용해서 회원가입 이벤트 구현  첫번째 1.if start
		if(Id==''){ //if안에 2.if start
				alert('아이디를입력해주세요.')
			}// 2.if end	
			else{alert('비밀번호를입력해주세요.')}
	}//1.if end
	 else if(Id.length<8 || Pw.length<8){//else if start 아이디 비밀번호8이하 이벤트
		if(Id.length<8){				//아이디 8이하일때
			alert('아이디는 8자이상 입력해주세요.')		//8자이상 입력멘트 이벤트 알람
		}else {	//else start					//비밀번호 다를시 이벤트
			alert('비밀번호는 8자이상 입력해주세요.')	//8자이상 비밀번호 이벤트 알람
		}			//else end
	
		
	}//else if end
	else{ alert('회원가입 성공')		//else 둘다 성공시 회원가입 성공 출력
		console.log('create_id='+Id)		//콘솔 id 출력
		console.log('create_Pw='+Pw)		//콘솔 pw 출력
		아이디.push(Id)						//아이디배열에 Id 입력(push)
		비밀번호.push(Pw)						//비밀번호배열에 Pw 입력(push)
		idInput.value=' '					//id초기화
		pwInput.value=' '					//pw초기화
	}		//if

	
}//f end

function login(){		//로그인 이벤트 f start
	let IdInput=document.querySelector('.log_id')	//로그인 아이디 입력 데이터 IdInput 저장
	let loginId = IdInput.value						//IdInput 값 loginId 저장
	
	let PwInput=document.querySelector('.log_pw')	//로그인 비밀번호 입력 데이터 PwInput 저장
	let loginPw = PwInput.value						//PwInput 값 loginPw 저장
	
	let indexId=아이디.indexOf(loginId)				//id인덱스 찾기
	let indexPw=비밀번호.indexOf(loginPw)				//pw인덱스 찾기
	
	if(indexId != -1 && indexPw != -1 ){			//Id와Pw 둘다 있을때
		if(indexId==indexPw){						//둘다 일치하면
				alert('로그인 성공')					//로그인 성공 알람
			
		}	else{alert('로그인 실패')}					//아닐시 로그인 실패
		
		
	}	else if(indexId !=-1 && indexPw ==-1){				//둘중 하나라도 다르면
				alert('아이디와 패스워드가 일치하지 않습니다.')		//일치x문구 알람
		
	}
	else{alert												//둘다 아닐시 아이디존재x알람
		('아이디가 존재하지 않습니다.')}
		IdInput.value=''									//Id 중복값 제거 
		PwInput.value=''									//Pw 중복값 제거
}
//로그인 이벤트 f end
console.log(아이디)
console.log(비밀번호)