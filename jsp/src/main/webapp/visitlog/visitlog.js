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
									<button type="button">수정</button>
									<button type="button">삭제</button>
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
function vupdate() {


}//f end

//4. Delete(삭제)
function vdelete() {


}//f end