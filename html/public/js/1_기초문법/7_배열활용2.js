/* 
	변수
		지역변수 : 지역{ }에서 태어났으면 지역 밖으로 못나감
			{안산} 태어났으면 안산{} 밖으로 못나감
			- { } 안에서 선언된 변수는 {} 밖에서 사용 불가능	//안으로는 가능!
		전역변수 : 지역{ }밖에서 태어났으면 자유롭게 이동 가능
			대한민국 태어났으면 안산{} 성남{} 자유롭게 이동가능
			-{} 밖에서 선언된 변수는 {} 안으로 이동 가능
			
		문자열내 변수/배열/객체 포함하는 방법[js안에서 html 작성시 문자처리]
		1. 작은따옴표(연결연산자)='<td>'+변수명/배열명+'</td>'
		2.백틱 ('${}')		= `<td>${변수명/배열명}</td>` (작은따옴표x)
	*/

console.log('JS실행')		//파일 연결했는지 확인 필수!


//4. 배열 선언
let 방문록배열=[];		//1. 여러 함수에서 사용하기 때문에 함수 밖에서 선언
				// 인덱스 : 배열내 저장된 순서 번호

// 1. 이벤트 함수 만들기
function 등록(){		//f st
						//let 방문록배열=[];		//2.작동시 계속 초기화 지역변수는 재사용x
	//1. 함수 잘 작동하는지 체크
	console.log('등록함수 실행');
	
	//2.<input>태그 호출
	let contentInput= document.querySelector('.content');
	console.log(contentInput);		//호출 잘 되는지 체크
	//3.입력받은 값 호출
	let value = contentInput.value;		
	console.log(value);			// 입력값 확인
	
	//4. 배열 등록
	방문록배열.push(value);
	console.log(방문록배열);
	//5. html에 배열 출력
		//1.
	let contentTable=document.querySelector('.contentTable')
		//2.
	let tableHTML =contentTable.innerHTML;
	console.log(tableHTML)	
			//3 innerHTML 내용 추가 (+=)
			//* 배열내 존재하는 인덱스(length = 배열길이)까지만 출력
			//*반복문을 이용한 0번 인덱스 부터 마지막 인덱스까지 출력
			//반복문 0번 부터 마지막 인덱스까지 1개씩 출력
			//0번부터(초기값) ; 마지막 인덱스까지(조건); 1개씩(증감식)
			//인덱스는 0부터 length는 1부터
			//i<방문록배열.length or i<=방문록배열.length-1
	//1.반복문을 이용한 출력	
	tableHTML =`<tr><th>내용</th><th>작성자</th></tr>`	
	for(let i =0; i< 방문록배열.length ; i++){ //for s
		tableHTML+=  `<tr><td>${방문록배열[i]}</td><td></td></tr>`
	}	//for end
					//tableHTML+=  '<tr><td>'+방문록배열[0]+'</td><td></td></tr>'//1.번째 정렬

	//2. 마지막 인덱스[최근 등록된 요소] = 배열.length-1
	//tableHTML+=  `<tr><td>${방문록배열[방문록배열.length-1]}</td><td></td></tr>`
	//let tableHTML =contentTable.innerHTML;	 
	console.log(tableHTML)	
		// 4. 추가된 HTML 내용 대입	
	contentTable.innerHTML = tableHTML
		
}		//f end

					//let 방문록배열=[];		//3. 1번이랑 똑같다.
					
					
//* 배열내 존재하는 인덱스(length = 배열길이)까지만 출력
			//*반복문을 이용한 0번 인덱스 부터 마지막 인덱스까지 출력
			//반복문 0번 부터 마지막 인덱스까지 1개씩 출력
			//0번부터(초기값) ; 마지막 인덱스까지(조건); 1개씩(증감식)
			//인덱스는 0부터 length는 1부터
			//i<방문록배열.length or i<=방문록배열.length-1		
					