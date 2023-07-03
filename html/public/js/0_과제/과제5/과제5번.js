
// 누구를~~  : userbox 를 
// 1. 조작/제어할 HTML 태그 dom객체 호출
let userbox 
= document.querySelector('.userbox');


//유저 위치 =x 좌표
let u_left = 10;
let u_top = 420;
// 어떻게~~  : 페이지전체(body) 에서 키보드를 누를때
	// DOM객체명.addEventListener('이벤트명' , ()=>{ })
document.body.addEventListener('keydown' , ( e )=>{
	console.log('키 눌림');
	// 1. 눌린 키 상태 확인 e.keyCode
	console.log( e ); // keydown 이벤트 상태 객체
	// 2. 만약에 왼쪽/오른쪽 키를 눌렀을때 css left 변경  
	if( e.keyCode == 37 ){
		console.log("왼쪽으로 이동"); // css left 차감 
		u_left -=10;			//10감소 왼쪽이기 때문에
			//* 유효성검사 [배경 밖을 못나가게]
		if(u_left<0){u_left=0};		//만약에 위치가 0보다 작아지면 고정
	}else if( e.keyCode == 38 ){
		console.log('위쪽으로 이동');	 // css left 증가 
		u_top -=10 ; // 10증가 오른쪽이기 때문에
		if(u_top<0){u_top=0};		//만약에 위치가 0보다 작아지면 고정
	}
	else if( e.keyCode == 39 ){
		console.log('오른쪽으로 이동');	 // css left 증가 
		u_left +=10 ; // 10증가 오른쪽이기 때문에
		if(u_left>900){u_left=900};		//만약에 위치가 0보다 작아지면 고정
		userbox.style.backgroundImage=`url(../img/캐릭터이동.png)`;// 이동 이미지 출력
	}
		
	else if( e.keyCode == 40 ){
		console.log('아래로');	 // css left 증가 
		u_top +=10 ; // 10증가 오른쪽이기 때문에
		if(u_top>420){u_top=420};		//만약에 위치가 0보다 작아지면 고정
	
	}
	else if(e.keyCode==65){
		console.log('공격')
		userbox.style.backgroundImage=`url(../img/캐릭터공격.png)`;// 공격 이미지 출력
	}													
	//3. 
	userbox.style.left=`${u_left}px`
	userbox.style.top=`${u_top}px`
	// 확인 
	console.log( userbox.style.left );
	console.log(userbox.style.top);
	
})		//f end

//2. 키 누르고 떼었을때.	=keyup
document.body.addEventListener('keyup' , ( e )=>{
	userbox.style.backgroundImege = `url(../img/마리오캐릭터.png)`;
})













