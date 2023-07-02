console.log('js시작합니다.')



//객체를 담을 데이터 생성
let profile=[];

//배열에 넣기 함수 지정 ! 
function input(){
	console.log(input)
	//입력값 변수에 넣기
	let mid=document.querySelector('#mid').value;
	let pwd=document.querySelector('#pwd').value;
	let title=document.querySelector('#title').value;
	let datail=document.querySelector('#datail').value;
	
	//객체에 라벨 붙여서 변수넣기
	let profile_s={mid:mid, 
				  pwd:pwd, title:title, 
				  datail:datail, view:0,
				  date:new Date()
				  }
				  
	//객체를 배열에 저장=이유는 함수내는 휘발성이기 때문에 전역변수인 배열에 넣는다
	profile.push(profile_s);
	view()
	console.log(profile);
	
	
}

function view(){console.log(view);
	let textTable=document.querySelector('.textTable');
	
	let Html =`<tr>
					<th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회수</th>
					
				</tr>`
	for(let i=0 ; i<profile.length ; i++){
		let board=profile[i]
		console.log[board]
		Html +=`<tr>
					<td>${i+1}</td>
					<td>${board.title}</td>
					<td>${board.mid}</td>
					<td>${board.date}</td>
					<td>${board.view}</td>
				
				</tr>`
		textTable.innerHTML =Html;
		
		
	}
}