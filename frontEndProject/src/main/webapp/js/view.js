
console.log('시작합니다.')

let no = sessionStorage.getItem('no')
let boardList =JSON.parse(localStorage.getItem('boardList'))
console.log('list.js 에서 저장된 세션정보:' +no)
onView()
//2. 클릭된 게시물번호의 게시물찾아서 출력
function onView(){
	// 식별자 : 인덱스 , 게시물번호 = 인덱스찾기
	// 1. 해당하는 게시물번호의 게시물찾기
	let title=document.querySelector('.title')
	let writedate=document.querySelector('.writedate')
	let content=document.querySelector('.content')
	
	for(let i = 0 ; i<boardList.length ; i++){
		let b = boardList[i] 				//i번째 게시물을 꺼내기
		if(b.no == no ){
			//만약에 i번째 게시물번호와 클릭된 게시물 번호와 같으면
			console.log(b);
			title.innerHTML = b.title
			writedate.innerHTML =`작성자 : ${b.writer} 작성일:${b.date}`
			content.innerHTML = b.content
			break;	//가장 반복문 종료
			
		}
	}
	
}


//삭제하기 함수 [클릭시]			//내가만들기
function onDelete(){
	console.log('삭제 이벤트 시작합니다.')
	
	for(let i =0; i<boardList.length ; i++){
		let b = boardList[i]
		if(b.no==no){
			boardList.splice(i,1);
			
			localStorage.setItem( 'boardList' , JSON.stringify( boardList )  )
			
			//세션 쿠키 넘버삭제
			sessionStorage.removeItem('no')
			
			location.href = 'list.jsp'
			alert('삭제 완료되었습니다.')
			
			break;
		}
		console.log(boardList)
	}
}



	
	
	
	
	
	
	
	
	
