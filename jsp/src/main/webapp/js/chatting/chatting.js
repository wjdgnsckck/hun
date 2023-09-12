
// * ajax(기본값 비동기통신) 가 응답의 결과를 가지고 오기전에 아래코드 실행. [ loginState 변경되기전에 실행되므로 문제발생 ]
// - 해결방안 ajax 동기화 통신 하자.. 
// 1. 비 로그인시 입장 불가능.. 
if( loginState == false ){ alert('회원전용 페이지입니다.'); location.href="/jspweb/member/login.jsp"; }

// 2. JS 클라이언트[유저] 소켓 만들기 
console.log( '채팅방에 입장한 아이디 : ' + loginMid );
let clientSocket = new WebSocket(`ws://192.168.17.13/jspweb/serversokcet/${loginMid}`);
	// - 클라이언트소켓이 생성되었을때 자동으로 서버소켓에 접속 ----> 서버소켓의 @OnOpen 으로 이동
	// - 서버소켓URL에 매개변수 전달하기 [- 주로 식별자 전달 ] 서버소켓URL/데이터1/데이터2/데이터3
	// ---- 메소드 4가지 메소드 자동으로 실행
		// 1. (자동실행)클라이언트소켓이 정상적으로 서버소켓 접속했을때
	clientSocket.onopen = e =>{
		//1-2 : 만약에 접속을 성공하면 알람메시지 전송
		let msg ={type : "alarm" , content :`${loginMid}님이 입장했습니다.`}
		//clientSocket.send(msg );  문제발생 : 해당 메시지를 받는 JAVA는 JSON 타입을 모른다.. 그래서 문자열 타입으로 전송해준다. 
		clientSocket.send(JSON.stringify(msg) ); 
	} ;
	 	// 2. (자동실행)클라이언트소켓이 서버소켓과 연결에서 오류가 발생했을때.
	clientSocket.onerror =  e =>{console.log('서버와 오류발생 :'+e)} ; 
		// 3. (자동실행)클라이언트소켓이 서버소켓과 연결이 끊겼을때
	clientSocket.onclose = e =>{console.log('서버와 연결 끊김 :'+e)} ;
		// 4. (자동실행)클라이언트소켓이 메시지를 받았을때
	clientSocket.onmessage = e => onMsg( e ) ;
	//clientSocket.onsend = ; 보내기x
	
	


// 3. 서버에게 메시지 전송
function onSend(){
	//3-1 textarea 입력값 호출
	let msaVlaue = document.querySelector('.msg').value;
	
	if(msaVlaue==''||msaVlaue=='\n'){alert('내용을 입력해주세요.');
	document.querySelector('.msg').value=``;
	return;}
	
	let msg = {type : 'message', content : msaVlaue}
	
	
	//3-2 메시지 전송
	clientSocket.send(JSON.stringify(msg) ); // 클라이언트소켓과 연결된 서버소켓에게 메시지 전송 -->
					//JSON타입을 String 타입으로 변환해주는 함수 []
	//3-3 메시지 성공시 입력상자 초기화
	document.querySelector('.msg').value=``;
	

}


//4. 메시지를 받았을때 추후 행동(메소드) 선언
function onMsg(e){
	
	//1. 전달받은 내용물을 JSON타입으로 형변환
	let msgBox = JSON.parse(e.data);
	msgBox.msg = JSON.parse(msgBox.msg);
	
	//2. msg속성내 content \n -> <br>
		//- replace() 문자열 교체/치환/바꾸기(정수는 변환이 안된다.)
	msgBox.msg.content=msgBox.msg.content.replace(/\n/g,'<br>')
	
	
	
	//어디에 출력할건지
	let chatcont =document.querySelector('.chatcont')
	//2.무엇을
	let html=``;
		// 만약에 알림 메시지 이면
		if( msgBox.msg.type==`alarm`){
			html =`${typeHTML( msgBox.msg )}`;
		}
		// 만약에 일반 메시지 이면
		else if(msgBox.frommid==loginMid){
			 html = `<div class="rcont"> 
					<div class="subcont">
						<div class="date"> ${msgBox.date} </div>
						${typeHTML( msgBox.msg )}
					</div>
				</div>`;
			
		}else{ // 2-2 내가 보낸 내용이 아니면
		
			 html = `<div class="lcont"> 
			 
					<img class="pimg" src="/jspweb/member/img/${msgBox.frommimg}" />
					
					
					<div class="tocont">
						<div class="name">${msgBox.frommid}</div> 
						<div class="subcont">
							${typeHTML( msgBox.msg )}
							<div class="date"> ${msgBox.date} </div>
						</div>
					</div>
				</div>`;
				
		}
	 
	//3. 누적 대입 [기존 채팅목록에 이어서 추가 +]
	chatcont.innerHTML += html;
	
	//------------------------------ 스크롤 최하단으로 내리기 ( 스크롤 이벤트 )----------------------//
	//1. 현재 스크롤의 상단 위치 좌표.
	//let topHeight = chatcont.scrollTop; //dom객체.scrollTop : 해당 div의 스크롤 상단위치
	//console.log(topHeight)
	//2. 현재 dom객체의 전체 높이
	//let scrollHeight=chatcont.scrollHeight
	//console.log(scrollHeight)
	//3. 전체 높이 값을 현재 스크롤 상단 위치에 대입
	chatcont.scrollTop = chatcont.scrollHeight;
}

//5. textarea 입력창에서 입력할때마다 이벤트 발생 함수
function onEnterKey () {
	//1. 만약에 ctrl + 엔터 이면 줄바꿈 처리.
	if (window.event.keyCode==13 && window.event.ctrlKey){// 조합키 : 한번에 두개 이상 입력 가능한 키 [ctrl.shift+enter]
	document.querySelector('.msg').value+=`\n`;return;}
	//2. 만약에 입력한 키 가  [엔터] 이면 메시지 전송
	if(window.event.keyCode==13){onSend();return;}


}

getEmo();
function getEmo(){

	
	// - 
	for (let i = 1 ; i<= 43 ; i++){
		document.querySelector('.emolistbox').innerHTML
		+=`	<img onclick ="onEmoSend(${i})"
		src="/jspweb/img/imoji/emo${i}.gif" />`;
	}
}

//7. 클릭한 이모티콘 서버로 보내기.
function onEmoSend(i){
	
	let msg ={type : 'emo', content : i  };
	//type :msg[메시지] , emo[이모티콘] , img[사진]
	// content : 내용물
	clientSocket.send(JSON.stringify(msg));
}
	

//8. msg 타입에 따른 html 반환 함수
function typeHTML( msg ){
	
	let html =``;
	
	
	// 1. 메시지 타입 일때는 <div> 반환
	if(msg.type =='message'){
		html +=`<div class="content"> ${msg.content} </div>`;
	}
	
	// 2. 이모티콘 타입 일때는 <img> 반환
	else if(msg.type== 'emo'){
		html +=`<img src = "/jspweb/img/imoji/emo${msg.content}.gif"`;
	}
	else if(msg.type=='alarm'){
		html +=`<div class="alarm"> ${msg.content} </div>`;
	}
	// 3. 만약에 알림 타입일때는 <div>를 반환해준다.
	return html;
}
	
// ------------------------------------------------------------------------------ // 
/*
	JS[ HTML파일 종속된 파일 - HTML 안에서 실행되는 구조 ] - 추후 node.js 라는 프레임워크 는 HTML로부터 벗어남.
	
	* 
		클라이언트 : 사용 데이터 요청 하는 PC
		서버 : 데이터 제공하는 PC
		
	* URL[주소] 상의 매개변수 전달하는 방법
		1. 쿼리스트링 방식 : URL?매개변수명1=데이터1&매개변수명2=데이터2&매개변수명3=데이터3
		2. 경로매개변수 방식 : URL/데이터1/데이터2/데이터3
		
	* 소켓이란. 
		- 통신의 종착점[데이터가 전달되는 위치 -받는사람 -보낸사람]
		- 예시 
		[클라이언트소켓]							[서버소켓]
		JS=강호동집									우체국		
			안산시 상록구[소켓]	----------------->					
			
		JS=신동엽집
			수원시 영통구[소켓]	<------------------
		
	* WebSocket 클라이언트 웹 소켓 라이브러리 
		- 소켓 관련된 함수들을 제공하는 클래스 
		1. 웹소켓 객체 생성 
			new WebSocket("ws://IP주소:PORT번호/프로젝트명/서버소켓경로");
		
		2.메소드 제공 
			.send() : 클라이언트소켓이 연결된 서버소켓에게 메시지를 전송	
	* 동기화 vs 비동기화 
	
	
	동기화[ 요청1 결과에 따른 다음 요청이 필요할때 ]		비동기화[ 여러 기능을 별도로 처리 ]
	
	Client				Server					Client				Server
	
		--------요청1------->							--------요청1------->
	대기상태o				요청1처리중					대기상태x					요청1처리중[5분]
		<-------응답1--------							--------요청2------->
																		요청2처리중	[1분]
		--------요청2------->							<-------응답2--------
						요청2처리중						
		<-------응답2--------							<-------응답1--------
		
		
	
*/








































/*
// 1. 클라이언트 소켓 만들기 
	// 1. JS웹소켓 객체 [ WebSocket클래스 ] / 객체가 생성되면 서버소켓에 자동으로 접속됨.
		// new WebSocket('ws://ip주소:포트번호/프로젝트명/서버소켓URL');  [ 객체생성 =====> 서버소켓 @OnOpen ]
	let 클라이언트소켓 = new WebSocket('ws://localhost:80/jspweb/ChattingSocket'); console.log( 클라이언트소켓 );
		// 2. opopen , onclose , send , onmessage 등등 메소드 제공 
	
		// 내가 만든 함수를 클라이언소켓 속성에 대입
	클라이언트소켓.onmessage = ( event ) => onmsg(event);
	
// 2. 연결된 서버소켓에게 메시지 보내기 
function msgsend(){
	// 1. input 입력된 값 가져오기 
	let msg = document.querySelector('.inputcontent').value;
	// 2. 클라이언트소켓 .send();
	클라이언트소켓.send( msg ); // input에서 입력받은 데이터를 보내기  [ 클라이언트소켓.send() =====> 서버소켓 @OnMessage ]
	
	// 3. 
	document.querySelector('.inputcontent').value = '';
}// f end 

// 3. 연결된 서버소켓으로 부터 메시지를 받았을떄.
function onmsg(event){ 
	console.log(event) ;
	console.log(event.data);
	
	document.querySelector('.contentbox')
				.innerHTML += `<div> ${event.data}</div>`
	
}
*/

/*
	1. AJAX [ 단방향 ]
		발신자(보내는사람) 	: AJAX		
		수신자(받는사람) 	: 서블릿		
	
		JS					JAVA[서블릿]
							
		AJAX	
				rest		get
							post	
							put
							delete
	2. (웹)소켓 [ 양방향 ]
		소켓 : 통신의 종착점[도착위치]
		- 전체조건 : 서버가 클라이언트소켓의 정보를 가지고 있어야한다.
		
		JS					JAVA
		[클라이언트소켓]		[서버소켓]
		websocket
		1. 서버소켓 접속		2. 서버소켓 24시간 상시 클라이언트 소켓 명단 저장
		3. 데이터 전송			4. 데이터 받는다.
*/
/*

				클라언트[사용자]						서버[서비스회사]
			
		강호동카카오톡		
						'안녕'
				-------------------------------->
				1. 강호동 메시지(안녕) 보낸다.
				
				<--------------------------------
				3. 서버가 '안녕' 메시지 보낸다.
				
		유재석카카오톡 
													카카오서버[제주도]
													- 전제조건 : 클라이언트의 정보들 보관
													접속된명단 : [ 강호동,유재석,신동엽,하하 ]
													2. '안녕' 메시지 받는다.
				<--------------------------------		
				3. 서버가 '안녕' 메시지 보낸다.			
		신동엽카카오톡 
		
				<--------------------------------
				3. 서버가 '안녕' 메시지 보낸다.
		하하카카오톡 
				<--------------------------------
				3. 서버가 '안녕' 메시지 보낸다.
		
*/