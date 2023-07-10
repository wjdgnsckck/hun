//0.현재 연도/월[초기값]
	//new Date() : 현재 날짜/시간 반환해주는 클래스
		//.getFullYear (),
let year = new Date().getFullYear(); 				//현재 연도
let month = new Date().getMonth()+1;			//현재 월(0~11)+1
console.log(year); console.log(month);

let contents = [] // 여러개 일정객체를 등록하는 배열

//1. 현재 연도/월 기준으로 달력 출력해주는 함수
calPrint();
function calPrint(){
		//1. 현재 연도와 월 을 해당 구역에 출력하기
	document.querySelector('.caldate').innerHTML = `${ year } ${ month }`;
	
	
			/*
					1.시작 요일
					2.현재 일 마지막 일
			*/

	
	// 현재 보고 있는 캘린더의 날짜
		let now=new Date(year,month-1,1);
		let sWeek = now.getDay(); console.log(sWeek) 	
	//1. 요일과 일 출력
		let now2 = new Date(year,month,0);
		let eDay = now2.getDate(); console.log(eDay);
	
	let calendar = document.querySelector('.calendar');
	let html = ' ';
			//1요일
			html +=`<div class="sunday week">일</div>		<div class="week">월</div>
			        	 <div class="week">화</div>				<div class="week">수</div>
						 <div class="week">목</div>				<div class="week">금</div>
						 <div class="week">토</div>`;
			//2. **** 현재 달력 1일의 요일까지 공백 출력
			for(let b = 1 ; b<=sWeek ; b++){	//1부터 1일의요일까지 공백 구역 출력
				html += `<div></div>`
			}
			for( let day=1 ; day<=eDay ; day++){
				html +=`<div onclick="openModal(${day})">
				${day}
				${contentPrint ( `${year}-${month}-${day}`)}
				</div>`
				//만약에 현재 날짜와 일정목록 등록된 일정의 날짜와 같으면 출력
				
			}
			
		calendar.innerHTML = html;
}

//6. 일정 출력함수 [ 실행조건 : 만약에 현재 날짜와 동일한 일정 날짜 찾아서 출력]
		// 인수 : 함수 안으로 들어오는 수/값/코드
		// 반환 : 함수{} 끝나고 함수 호출 했던곳으로 수/값/데이터 보내기 = 해당날짜의 일정 내용 HTML
function contentPrint(date){
	console.log(date)
	let html=' ';
	//인수로 들어온 날짜와 같은 일정목록에서 일정 찾기
	for(let i = 0 ; i<contents.length ; i++){
		if(date==contents[i].date){
			html+=	`<span class="content" style="background-color:${contents[i].color}">
			${contents[i].content}
			</span>`
			
		}
	}
	return html;
}







function onNext(check){
	
	console.log(check)
	// 1. 버튼 식별후 월 증감
	if( check ==0){			//이전 달
		month --;				//현재 보고 있는 월 1 차감
		
			if(month<1){month=12; year--;}
			
	}else if(check ==1 ){	//다음 달
			month++						//현재 보고 있는 월 1 증가
			
	}		if(month>12){month=1;year++;}
	
	
	calPrint();
}




//3. 모달 열기
function openModal(day){
	document.querySelector('.modalwrap').style.display='flex';
	
	//* 현재 클릭한 일수의 날짜 출력
	document.querySelector('.date').innerHTML= `${year}-${month}-${day}`
	/* month< 10 ? `0`+month */
}



//4. 모달 닫기
function closeModal(){
	document.querySelector('.modalwrap').style.display='none';
}


//5. 일정 등록 버튼 클릭했을때
function onWrite(){
	//1. 입력받은 값 호출
	let color= document.querySelector('.color').value;
	let contentInput=document.querySelector('.contentInput').value;
	let date=document.querySelector('.date').innerHTML;
	
	
	//2.가공 [1.유효성검사, 2.객체화]
	let object = {
		color : color,
		content : contentInput,
		date: date
		
		
	}



	
	//3.저장
	contents.push(object);
	console.log(contents);
	
	//4. 비워주기
	color.value='' ; contentInput.value='';
	//5.모달닫기
	closeModal();
	//새로고침
	 calPrint();
}















