//1. 로그인 함수
function login(){
		//1. 입력받은 아이디, 비밀번호 가져온다.
		let mid=document.querySelector('.mid').value;
		let mpwd=document.querySelector('.mpwd').value;
		//2.ajax에게 전달해서 회원이 존재하는지 결과 반환
		$.ajax({
			url : "/jspweb/MemberFindController",
			method :"post",	
			//get메소드는 전송하는 data노출(보안에 취약하다)post메소드는 전송하는 data노출x(보안적용)
			data : { mid:mid , mpwd:mpwd},
			success: r=>{
				
				if(r){alert('로그인완료')
				location.href="/jspweb/index.jsp";}
				else{alert('없는회원입니다.')
					document.querySelector('.logincheckbox').innerHTML=`동일한정보의 회원이없습니다.`}
			},
			error : e=>{console.log(e)}
		})
			//2-1 : 로그인성공시 index.web로 이동
			//2-2 : 로그인실패시 'logincheckbox'에 로그인 실패
	
	};
	
	
	
/* 

	 GET,PUT,DELETE vs POST
	 
	 	GET: http://localhost/web/MemberFindController?mid=asd$mpwd=asdasd
	 		-캐시(기록)
	 		-추후에 다시 전송시 빠름
	 		-보안에 취약하다(불가능하다)
	 		-매개변수 노출
	 		-개인정보가 없는 데이터정보 전송 권장
		POST: http://localhost/web/MemberFindController
			-캐시(기록X)
			-추후에 다시 전송시 속도 동일 get보다 느림!
			-보안 가능
			-매개변수 노출X
			-로그인 , 회원가입 (권장)
*/