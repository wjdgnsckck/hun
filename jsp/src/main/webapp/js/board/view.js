

getBoard();
//1. list.jsp에서 클릭된 제목에bno를 전달받아 게시물 1개 가져오기
function getBoard(){
	
	//1.URL에 있는 매개변수(쿼리스트링) 가져오기
		//1.현재 주소(url)상 매개변수 가져오기
	let urlParams = new URL(location.href).searchParams
	let bno =urlParams.get("bno");

	
	//2. AJAX 이요한 bno 전달해서 게시물의 상세 정보 모두 가져오기
	$.ajax({
		url:"/jsp/BoardInfoController",
		method:"get",
		data:{type : 2 , bno : bno},
		success : r=>{ 
			//1.
			let boardBox=document.querySelector('.boardBox')
			//2.
			let html = `부가정보 : <div>${r.bcname} ,${r.bview} , ${r.bdate}</div>
				부가정보2 : <div>${r.mid},${r.mimg}</div>
				제목 : <div>${r.btitle}</div>
				내용 : <div>${r.bcontent}</div>
				첨부파일 : <div>${r.bfile}</div>`
			
			html+=`<a href="list.jsp"><button type="button">목록보기</button></a>`
		
			
			//3. 만약에 본인글 인지 제어 [본인글이면 수정/삭제 표시함 / 아니면 표시안함]
			
			if(r.ishost){
				html +=`<button onclick="ondelete(${r.bno})" type="button">삭제</button>
				<button onclick="onUpdate(${r.bno})" type="button">수정</button>`}
				
				boardBox.innerHTML=html;
		
		},
		error : e => {}
		
	})




}

function ondelete(bno){
	$.ajax({
		url : "/jsp/BoardInfoController",
		method : "delete",
		data :  {bno : bno},
		success : r=>{ console.log('통신')
			if(r){alert('게시물 삭제되었습니다.'); location.href="/jsp/board/list.jsp"}
			else{alert('입력오류')}
		},
		error : e =>{console.log(e)}
	})
}

	
function onUpdate(bno){
	//1. 수정페이지로 이동
	location.href=`/jsp/board/update.jsp?bno=${bno}`
}

