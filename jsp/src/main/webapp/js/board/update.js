let bno =new URL(location.href).searchParams.get("bno");

getBoard();
//1. 수정할 게시물의 기본 정보를 보여주기
function getBoard(){
	
	//개별페이지에서 bno 가져오기
	

	
	//3. ajax 에게 bno 전달해서 게시물정보 가져오기
	$.ajax({
		url : "/jsp/BoardInfoController",
		method : "get",
		data : {type : 2 , bno : bno},
		success  : r=>{
			// 응답 결과 html 대입
			document.querySelector('.bcno').value =`${r.bcno}`;
			document.querySelector('.btitle').value =`${r.btitle}`;
			document.querySelector('.bcontent').value =`${r.bcontent}`;
			
		},
		error : e =>{}
		
	})
}

function onUpdate (){
	//입력된 값 수정하기
	let WriteForm = document.querySelectorAll('.WriteForm')[0];
	//폼전송!
	let formdata = new FormData(WriteForm);
		//폼 객체에 데이터 추가 [bno]
				//.set (속성명 , 값)
		formdata.set("bno",bno);
	$.ajax({
		url: "/jsp/BoardInfoController",
		method : "put",
		data : formdata ,
		contentType : false,
		processData : false,
		success: r=>{
			if(r){alert('수정완료') ; location.href="/jsp/board/list.jsp"}
			else{alert('오류')}
			
			},
		error : e=>{}
	})
	
	 
}