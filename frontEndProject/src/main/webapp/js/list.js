console.log('list.js');

// 0. 쿠키에 있는 배열 호출 [ 페이지[JS] 열리면 ]
let boardList = JSON.parse( localStorage.getItem('boardList') );
	/* 쿠키/세션에 저장된 객체/배열 호출시  JSON.parse( )
	   쿠키/세션에 저장된 객체/배열 저장시 JSON.stringify( ) */
if( boardList == null ) boardList = [ ] // 만약에 쿠키가 비어 있으면 비어 있는 배열 대입

boardPrint();
// 1. 게시물 출력 함수 [ 페이지[JS] 열리면 ]
function boardPrint(){
	// 1. 어디에 
	let tcontent = document.querySelector('.tcontent')
	// 2. 무엇을 
	let html =``
		// HTML 구성 : 쿠키에서 꺼내온 배열을 반복문 해서 HTML 누적 더하기 
		for( let i = 0 ; i<boardList.length ; i++ ){
			let board = boardList[i];	// i번째 게시물 호출
			html += `<tr>
						<td> ${ board.no } </td> <td onclick= "onViewLoad (${board.no} )"> ${ board.title } </td> <td> ${board.writer} </td>
						<td> ${ board.date } </td> <td> ${ board.view } </td> <th> ${ board.like } </th>
						
					</tr>`
		}
	// 3. 대입
	tcontent.innerHTML = html;
}

//2. 상세 페이지로 이동 [실행조건 : 클릭한 게시물 제목]
function onViewLoad(no){console.log("선택한 게시물 번호 :" + no)

//클릭된 결과를 다른페이지로 옮기는 방법
	// JS는 페이지 전환/새로고침 초기화 - >  // 세션/쿠키  
//1.
sessionStorage.setItem('no',no) // 클릭된 게시물 번호 저장
increaseView( no )
//2.페이지 이동
location.href="view.jsp"	



	
}
//3. 조회수 증가함수 [실행조건 : 제목 클릭후 페이지 전환 전에 실행]
function increaseView(no){
	for(let i = 0 ; i < boardList.length ; i++){		//찾을시
		let b = boardList[i];
		if(b.no==no){
			boardList[i].view++;
			//*만약에 세션/쿠키 사용중이라면 업데이트
			localStorage.setItem('boardList', JSON.stringify(boardList) );
			break;
		}
		
	}
	
	
}






















	