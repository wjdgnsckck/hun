

/* 게시물 조회 조건 객체*/
let pageOject = { type: 1, bcno: 0, listsize: 10, page: 1 };
// * type 	  : ( 1: 전체 출력 , 2: 개별출력)
// * page  	  : 조회할 페이지번호
// * bcno     : 조회할 카테고리 번호 [ 기본값은 전체보기]
// * listsize : 하나의 페이지에 최대표시할 게시물수 [ 기본값은 10개]


//3. 카테고리 버튼을 클릭했을때,
function onCategory(bcno) {
	pageOject.bcno = bcno; // 조회 조건 객체내 카테고리 번호를 선택한 카테고리로 변경
	getList(1);
}

//4. 한페이지 최대 표시할 개수를 변경했을때.
function onlistSize() {
	pageOject.listsize = document.querySelector('.listsize').value; // 선택된 게시물수를 조회조건객체 저장
	getList(1);
}

//2. 모든 글 조회 [ js열렸을때 1이 자동실행]
getList();
function getList(page) { // 인수를 페이지로 받는다.
	pageOject.page = page;
	$.ajax({
		url: "/jsp/BoardInfoController",
		method: "get",
		data: pageOject,
		success: r => {
			if (r) {


				//-----------------------------1.게시물 출력 ----------//
				//1. 출력할 위치
				let boardTable = document.querySelector('.boardTable')

				//2. 출력할 내용 (r)구성
				let html = `	<tr>
						<th>번호</th>
						<th>카테고리</th>
						<th>제목</th>
						<th>작성자</th>
						<th>조회수</th>
						<th>작성일</th>
							</tr>`
				// * 서블릿으로부터 전달받은 내용[배열]
				// 배열명.forEach
				r.boardList.forEach(b => {
					html += `	<tr>
						<th>${b.bno}</th>
						<th>${b.bcname}</th>
						<th><a href ="/jsp/board/view.jsp?bno=${b.bno}">${b.btitle}</a></th>
						<th>${b.mid}/<img class ="img"src = "/jsp/Member/img/${b.mimg}"/></th>
						<th>${b.bview}</th>
						<th>${b.bdate}</th>
							</tr>`
				});
				boardTable.innerHTML = html;
			}
			//------------------2. 페이지번호 출력 --------------//
			html = ``;
			//이전
			html += `<button  onclick="getList(${page==1 ? page : page-1})" type="button"> < </button>`
			//페이지번호 버튼
			for(let i = 1 ; i<=r.totalpage ; i++){
					// 만약에 현재페이지와 i번째 페이지와 일치하면 버튼태그에 class="selectpage"추가
			html += `<button class="${page== i ? 'selectpage':''}" onclick="getList(${i})" type="button"> ${i} </button>`
						}
			//다음 버튼 [ page >= pageDto.totalpage ? page : page +1 만약에 현재페이지가 마지막 페이지 이면 ]
			html += `<button onclick="getList(${page>=r.totalpage ?  page:page+1})" type="button"> > </button>` ;	
					
			document.querySelector('.pagebox').innerHTML=html;
			
			
			//---------------------------------3. 게시물 수 출력 -------------------/
			let boardcount = document.querySelector('.boardcount');
			boardcount.innerHTML =`총 게시물 수 : ${r.totalsize}`
			
		},
		error : e => {}
		
	})
}

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

/* 
	
	HTTP URL에 매개변수 (파라미터) 전달
	
		URL?변수명 = 데이터
		URL?변수명 = 데이터&변수명 = 데이터
	
*/