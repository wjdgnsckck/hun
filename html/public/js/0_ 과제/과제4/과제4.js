console.log('js시작')

let profile=[ ];
//*JS 열렸을때 최초 1번
visit()
//1.등록 이벤트 함수[온 클릭 이벤트를 통해 배열에 저장]
function input(){
	
	let midValue=document.querySelector('#mid').value;		//작성자input값 저장
	let pwdValue=document.querySelector('#pwd').value;		//비밀번호input값 저장
	let titleValue=document.querySelector('#title').value;		//제목input값 저장
	let datailValue=document.querySelector('#datail').value; //내용input값 저장
	
		let now= new Date();							//1. 현재 시스템(pc)의 날짜/시간 호출
		let year = now.getFullYear();			console.log('year'+year);
		let month = now.getMonth()+1;			console.log('month'+month);
		let week = now.getDay();					console.log('week '+week); 
		let day= now.getDate();					console.log('day '+day);
		let hour = now.getHours();				console.log('hour'+hour);
		let minute = now.getMinutes();			console.log(' minute'+ minute);
		let second = now.getSeconds();		console.log('second'+second);
	//모든값 객체에 라벨붙여서 저장하기
	let profile_s={mid:midValue ,			
						 pwd:pwdValue ,
	 					title:titleValue, 
	 					datail:datailValue,
	 					date:`${now.getFullYear()}년  
	 					${now.getMonth()+1}월 
	 					${now.getDate()}일					
	 					${now.getHours()}:${now.getMinutes()}:${now.getSeconds()}:`
	 					,
	 					view:0
	 				   };
	profile.push(profile_s)												//객체값 배열에 넣기
	
		
	visit()				//등록시 사용	
			
	document.querySelector('#mid').value=``					//4가지값 넣고 초기화
	document.querySelector('#pwd').value=``
	document.querySelector('#title').value=``
	document.querySelector('#datail').value=``
}//f end


//배열에있는 데이터 html실행 출력함수 [ 실행조건 : 1.JS열렸을때 2.등록했을때 3.삭제했을때 4.수정,조회했을때]
function visit(){
	
	
	//1. 어디에 출력할건지 
	let contentTable=document.querySelector('.contentTable')
	//2.테이블 무엇을 대입할건지
	let html=`<tr>
				<th>번호</th>	<th>제목</th>	
				<th>작성자</th>	<th>작성일</th>	
				<th>조회수</th>
					</tr>`
	for(let i=0; i<profile.length ; i++){		//인덱스 번호 찾기 f start
		let board=profile[i]					    	//찾은 인덱스 변수에 넣기
	
		html+=											//html에 대입할 자료 넣기
		`<tr>
		<td>${i+1}</td>
		<td onclick="onView( ${i})">${board.title}</td>
		<td >${board.mid}</td>
		<td>${board.date}</td>
		<td>${board.view}</td>
		</tr>`
}				//f end
	contentTable.innerHTML =html

}
//3.

function onView(index){
	console.log('onView()확인');
	
	
	//1. 어디에~~
	let viewbox=document.querySelector('#viewbox')
	let board=profile[index]
	//2. 무엇을~~
	let html=`<h3>글보기 페이지</h3>
	<div>제목: ${board.title}</div>
	<div>내용: ${board.datail}</div>
	<div>작성자: ${board.mid}</div>
	<button onclick="onDelete(${index})">삭제</button>`
	viewbox.innerHTML =html
	//왼쪽은 조회수 증가(JS변경) 오른쪽 화면 새로고침(HTML변경)
	board.view++;visit();
}//f end

//삭제함수
function onDelete(index){
	console.log('dataD삭제'+index)

	//1.배열내 삭제할 인덱스의 객체 호출
	let board=profile[index]
	
	//2.입력값
	let input=Number(prompt('비밀번호를입력해주세요 :'));
	
	//3.비교 둘다 일치시 삭제
	if(input==board.pwd){
		//4.배열내 해당 객체 삭제
		profile.splice(index, 1);
		//5.화면 새로고침
		visit();
		//게시물 공백만들기
		document.querySelector('#viewbox').innerHTML=``
		alert('삭제되었습니다.')
		
	}else{//일치x
		alert('[삭제실패] 비밀번호가 다릅니다.')
	}
}



















