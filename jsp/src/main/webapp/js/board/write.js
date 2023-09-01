
//write , update ,delete : js 내장함수들이 존재해서 동일한 이름을 쓰면 출돌이 생길수있다.

function bwrite(){

		//1. form 가져오기
		let form=document.querySelectorAll('.WriteForm')[0];
		
		//2. form 객체화 하기
		let formData=new FormData(form)
		
		//3. ajax로 대용량 form 전송하기
		$.ajax({
			url : "/jsp/BoardInfoController",
			method : "post",
			data : formData,
			contentType : false,
			processData : false,
			success : r=> {
				if(r){alert('글 등록 성공')
				location.href="/jsp/board/list.jsp"}
				else{alert('글 등록 실패')}
			},
			error : e => {}
		
		})
		
		
		
}