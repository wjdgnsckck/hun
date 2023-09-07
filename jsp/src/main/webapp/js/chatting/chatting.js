/*
	1. AJAX
	
		JS0

 
 */
//1. 클라이언트 소켓 만들기
		//1. JS 웹 소켓 객체 [WebSocket클래스]
			//new Websocket('ws://ip주소:포트번호/서버소켓URL');
				
		let 클라이언트소켓 = new WebSocket('ws://localhost:80/jspweb/ChattingSocket'); console.log(클라이언트소켓);
		// 2. onopen ,onclose , send , onmessage
		클라이언트소켓.onmessage = (e) => onmsg(e)
function msgsend(){
	//1. input 입력된 값 가져오기
	let msg = document.querySelector('.inputcontent').value;
	//2. 클라이언트소켓 .send();
	클라이언트소켓.send(msg);
	
}

function onmsg(e){
	document.querySelector('.contentbox')
	.innerHTML += `<div>${event.data}</div>`
}
