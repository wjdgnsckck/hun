
//1. 글쓰기 버튼을 글릭하면
function onWrite(){
	if(loginState){  // - 만약에 비 로그인이면
		location.href="/jsp/board/write.jsp"
	}
	else{
		alert('로그인후 글 등록이 가능합니다.')
		location.href="/jsp/Member/login.jsp"
	}
	// - 만약에 비 로그인 이면 로그인 페이지로 이동

	// - 로그인이면 쓰기 페이지 이동
}
getList();
function getList(){
	$.ajax({
		url : "/jsp/BoardInfoController",
		method : "get",
		data : "",
		success : r => {
			if(r){
					//1. 출력할 위치
					let boardTable =document.querySelector('.boardTable')
					
					//2. 출력할 내용 (r)구성
					let html =`	<tr>
						<th>번호</th>
						<th>카테고리</th>
						<th>제목</th>
						<th>작성자</th>
						<th>조회수</th>
						<th>작성일</th>
							</tr>`
							// * 서블릿으로부터 전달받은 내용[배열]
							// 배열명.forEach
							r.forEach(b=>{
								html += `	<tr>
						<th>${b.bno}</th>
						<th>${b.bcname}</th>
						<th>${b.btitle}</th>
						<th>${b.mid}/<img class ="img"src = "/jsp/Member/img/${b.mimg}"/></th>
						<th>${b.bview}</th>
						<th>${b.bdate}</th>
							</tr>`
							});
							boardTable.innerHTML=html;
					}
			else{}
		},
		error : e => {}
		
	})
}