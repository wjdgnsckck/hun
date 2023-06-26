//* 선택된 번호를 저장하는 배열
let 선택번호목록=[ ];

// 1. 로또 구매 함수 정의 [실행 조건 : 로또 구매 버튼 클릭시]
function 로또구매(){
	console.log('로또구매()실행');
	let buttonHTML ='';
	// 1. 1~45개의 버튼 생성
	for(let i= 1 ; i<=45 ; i++){//for start
		//버튼 하나씩 변수에  추가
		buttonHTML += `<button
									 onclick="숫자버튼(  ${i})"> 
									 	${i} 
									 </button>  `		//i번째 버튼생성
									 //인수 =i번째 출력된 숫자(1~45)중 클릭된 숫자를 숫자버튼함수 에게 전달
									 
		//만약 if가 5의 배수이면
if(i%5==0){buttonHTML+= `<br/>`}
	}

	//2.
	document.querySelector('.버튼목록구역').innerHTML = buttonHTML;
}//for end


//2. 숫자(선택) 버튼 함수 정의 [실행조건: 1~45중 1개의 버튼 클릭시]
function 숫자버튼(선택된번호){
	console.log(선택된번호 +'숫자버튼을 클릭했군요.')
	//<push>배열에 저장하기전에 유효성검사 
	// 1. 중복검사 = 배열명.indexOf		무조건은 아님 pw찾기에도 이용
	if(선택번호목록.indexOf(선택된번호) !=-1){//-1 : 동일한 데이터가 배열내 없음 뜻
												//!=-1 : 배열내 존재하면
	
		선택번호목록.splice(선택번호목록.indexOf(선택된번호) , 1);		//선택된 번호의 인덱스 1개 삭제
		alert('이미선택된 번호 입니다.[취소합니다]')
		선택번호출력();
		return; 	//함수 강제 종료
	}
	
	
	//2. 6개 초과인지 검사  = 배열명.length			:배열내 데이터 총개수/길이
	if(선택번호목록.length == 6){		//if start
		alert('이미 6개 번호 모두 선택하셨습니다.');
		return;	//함수 강제 종료 // return 안했을경우 코드는 계속 돌아감(계속 push!! 배열내 6개 이상 들어감)
	}// if end
	
	
	
	//*배열에 저장  (2개의 유효성검사를 모두 통과했을때 배열에 저장)
	선택번호목록.push(선택된번호); console.log(선택번호목록)
	선택번호출력();
}

//3. 선택된 번호들을 출력	[실행조건 : 배열에 변화가 있을때 (1.추가 / 2.삭제 / 3.수정)]
function 선택번호출력(){	//f start
		document.querySelector('.선택번호출력구역').innerHTML = 선택번호목록;
		
		if(선택번호목록.length == 6){
				document.querySelector('.추첨결과버튼구역').innerHTML =
								`<button onclick="추첨결과()">추첨결과보기 </button>`
		}
		else{document.querySelector('.추첨결과버튼구역').innerHTML = ``}
		
}	// f end
//4. 추첨 결과 함수
function 추첨결과(){
	alert('로또 추첨합니다. [잠시 대기]');
	
	//1.난수 생성 공식 :Math.random()* 마지막번호+시작번호
	console.log( Math.random())				//Math.random(): 0~1 사이의 난수(실수) 생성(1미만)
	console.log( Math.random()+1)			//(0~1)+1 =>1~2 사이의 난수(실수) 생성
	console.log( Math.random()*45+1)		//(0~1)*45+1 =>0~45 사이의 난수(실수) 생성 [끝값은 x]
														//(0~1)*45+1 =>1~46 사이의 난수(실수) 생성
	// 2. 실수 (소수점 있는) --->정수(소수점 없는)	  : 	parseInt()  실수 --> 정수(소수점x)
	console.log(parseInt( Math.random()*45+1))		//1~46 사이에 실수(실수-->정수)아닌 정수
						
//* 추첨번호 저장 배열
let 추첨번호목록=[];				//추첨번호목록은 추첨할때마다 새롭게 등록하기 위해 함수 안에서 선언						
	//3. 1~45 사이의 난수생성[중복검사후 push]6회 반복
	for(let i = 1 ; i<=6 ; i++){// for start
		let 추첨번호 = parseInt(Math.random()*45+1);
		if(추첨번호목록.indexOf(추첨번호)==-1){		//if start
			추첨번호목록.push(추첨번호);  }		//배열에 저장 // 정상 //i정상 증가
			else{			//[중복]동일한 추첨번호가 있으면
				i--;}		// 비정상	//i 차감 // 해당 i 다시한번 실행
	} //if end													
console.log(추첨번호목록);	

	//4. 두 배열 비교하기 [선택번호목록 과 추첨번호 목록]
			//배열과 for 활용
	let 맞은개수 = 0;
			//방법1. 일반 for문 원형 꼭알아야함!	(인덱스용으로 사용하기 때문에 i는 0부터 / 길이는 6, 인덱스는 0~5)
			for(let i = 0; i<선택번호목록.length ; i++){
				if(추첨번호목록.indexOf(선택번호목록[i]) != -1){맞은개수 ++;}
			}
		alert('맞은개수:'+맞은개수)
			//방법2. 향상된 for문 [for (let 반복변수명 in 배열명)]
			for(let 인덱스 in 선택번호목록){ // 자동으로 0번 인덱스부터 마지막 인덱스까지 인덱스를 반복변수에 대입
				console.log(인덱스)
				if(추첨번호목록.indexOf(선택번호목록[인덱스])!= -1){맞은개수++;}
			}
			
			//방법3. 향상된 for문 [for(let 반복변수명 of 배열명)]
			for(let 데이터 of 선택번호목록){		//자동으로 0번 인덱스부터 마지막 인덱스까지의 데이터를 반복변수에 대입
				console.log(데이터)
				if(추첨번호목록.indexOf(데이터) !=-1){맞은개수++;}
			}
			//방법4. for 관련함수 [배열명 . forEach() vs  배열명.map()	vs filter()]
										// 배열명. forEach( (데이터=>{실행문}))	
										// 배열명. forEach( (데이터,인덱스=>{실행문}))									
			선택번호목록.forEach((데이터,인덱스)=>{	
				console.log(데이터);	console.log(인덱스);
				if(추첨번호목록.indexOf(데이터) != -1){맞은개수++;}
			});
			
			
												
}		//for end
































