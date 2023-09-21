


/*
	소켓 사용하는 이융 
		소켓[양방향:요청이 없어도 응답이 올수있음] 
			vs 아작스[단방향 : 요청이 없으면 응답이 없음]
		
		- 정의 : 통신 데이터 의 종착점
		 
		 시작소켓					끝소켓 
		 	<--------------------->
		
		클라이언트소켓JS
		클라이언트소켓JS
		클라이언트소켓JS
		클라이언트소켓HS					서버소켓[ 중앙 처리 소켓 : 여러개의 클라이언트소켓 관리 ]
		클라이언트소켓JS						PC
		클라이언트소켓
		클라이언트소켓
		
			JS 에서 new WebSocket 했을때 클라이언소켓 생성 
			JS 에서 WebSocket객체를 초기화 하면 클라이언트소켓 삭제 
				1. null 대입하기 
				2. F5
				3. 페이지 전환
				등등등
		
	클라이언트소켓 : 사용자PC 
	서버소켓 : 서버PC
	
*/

let 클라이언트소켓 = null;
let roomNum = 0;

function onRoom( rno ){
	console.log( rno +'번 선택');
	클라이언트소켓 = new WebSocket("ws://localhost:80/SocketTest/serversocket");
	클라이언트소켓.onopen = (e)=>{ 
		console.log( "접속" ); 
	}
	
	클라이언트소켓.onclose = (e)=>{ 
		console.log( "나감" ); 
	}
	
	클라이언트소켓.onmessage = (e)=>{
		let html = ``;
		let msgbox =  JSON.parse(e.data);
		
		if( roomNum == msgbox.rno ){
			
			// 현재내방과 메시지를 보내온 방과 같으면
			html = `<div>${ msgbox.msg }</div>`;
		}
		document.querySelector('.msgList').innerHTML += html;
	}
	
	document.querySelector('.currentRoom').innerHTML = `${ rno }방 이용중`
	roomNum = rno;
}

function msgsend(){
	let msg = {
		rno : roomNum  ,
		msg : document.querySelector('.msgbox').value
	}
	클라이언트소켓.send( JSON.stringify( msg ) ) ;
}





































