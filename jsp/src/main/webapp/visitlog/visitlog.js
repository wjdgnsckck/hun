console.log("visit 연결")

//1. Create(저장)
function vwrite() {

	//1. HTML input 태그 호출
	let vwirter = document.querySelector('.vwirter'); console.log(vwirter)
	let vpwd = document.querySelector('.vpwd'); console.log(vpwd)
	let vcontent = document.querySelector('.vcontent'); console.log(vcontent)
	//2. 객체화
	let info = {
		vwirter: vwirter.value,
		vpwd: vpwd.value,
		vcontent: vcontent.value
	};
	console.log(info)

	//3. 유효성검사


	//4.AJAX
	$.ajax({
		url: "/jsp/VisitlogController",
		method: "post",
		data: info,
		success: function f(r) {
			console.log(r);
			if (r == true) { alert('등록성공'); vread(); vwirter.value = ''; vpwd.value = ''; vcontent.value = ''; }
			else { alert('등록실패'); }
		},
		error: function f(r) { }
	})

	//5. 결과에 따른 코드


}//f end

//1. Read(호출)
vread();
function vread() { // 실행조건 : JS가 열릴때 한번 실행 ,등록 , 수정 , 삭제 =>최신화 [새로고침]
	$.ajax({
		url: "/jsp/VisitlogController",
		method: "get",
		data: "",
		success: function f(r) {
			console.log(r);

			//응답 받은 객체를 HTML에 출력
			//1.[어디에] 출력구역의 객체 호출
			let output = document.querySelector(".visit_Bottom");
			//2.[무엇을] 반복문 이용한 데이터를HTML 형식으로 만들기
			let html = ``;	//백틱

			//리스트내 모든 데이터
			for (let i = 0; i < r.length; i++) {
				//객체를 html형식으로 누적 더하기
				html += `<div class = "visit_Bottom"><!-- 출력 구역  -->
							<div class = "visitbox">	<!--  방문록 1개의 표시구역  -->
								<div class="visit_top">
									<div>${r[i].vwriter}</div>
									<div class="visitdate">${r[i].vdate}</div>
								</div>
								<div class="visit_center"> ${r[i].vcontent}</div>
								<div class="visit_bottom">
									<button onclick="vupdate(${r[i].vno})" type="button">수정</button>
									<button onclick="vdelete(${r[i].vno})" type="button">삭제</button>
								</div>
							</div>
						</div>`
			}
			output.innerHTML=html;
			//3.[대입]출력객체 html 통식
		},
		error: function f(r) {}
	})


}//f end

//3. Update(수정)
	//누구를(클릭된방문록) 어떻게(새롭게입력받아) 수정할껀지...
function vupdate(vno) { console.log('vupdate() open'+vno)

	//1. 수정할 내용 입력
	 let vcontent =	prompt('수정할 방문록내용: ')							//alert() : 확인알림창 confirm():확인/취소알림창		prompt():알림창에서 입력받기
	 //2. 비밀번호가 일치할 경우에도 수정하므로 확인용 비밀번호 입력받기
	 let vpwd=prompt("방문록비밀번호 :")
	 
	 // 수정 준비물 : vno(누구를) , vcontent(어떤내용으로) , vpwd(조건용:비밀번호일치여부)
	 $.ajax({
      url : "/jsp/VisitlogController", //통신할 백엔드 (컨트롤러 서블릿 주소)
      method : "put",
      data : {vno : vno , vcontent: vcontent ,vpwd : vpwd} ,
      success : function f(r){console.log("통신성공");
        if(r == true){alert('수정성공');vread();}
      else {alert('비밀번호가 일치하지 않습니다.')}},
     
      error : function f(r){console.log(r)}
   })
	 
}//f end

//4. Delete(삭제)
function vdelete(vno) {console.log('vdelete() open'+vno)
 
 		//1. 비밀번호가 일치할 경우에 수정하므로 확인용 비밀번호 입력받기
 		let vpwd = prompt("방문록비밀번호 : ")
		
		// 삭제 준비물 : vno(누구를) , vpwd(조건용:비밀번호일치여부)
	$.ajax({
      url : "/jsp/VisitlogController",
      method : "delete",
      data : {vno : vno , vpwd : vpwd} ,
      success : function f(r){if(r==true){alert('삭제성공');vread();}
      else {alert('비밀번호가 일치하지 않습니다.')}} ,
      error : function f(r){}
   })
}//f end