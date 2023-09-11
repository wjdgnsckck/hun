
//0. 로그인된 회원의 정보
getInfo();
function getInfo(){
	$.ajax({
      url : "/jspweb/MemberInfoController",
      method : "get",
      data : {type : "info"} ,
      success : r=>{
		  if(r==null){//비로그인 상태
			  alert('회원전용 페이지 입니다.[로그인페이지 이동]')
			  location.href="/jspweb/member/login.jsp";
		  }
		  else{// 로그인 되어있으면
			  document.querySelector('.preimg').src=`img/${r.mimg}`; 
			  document.querySelector('.mid').innerHTML=r.mid;
			  document.querySelector('.memail').innerHTML=r.memail;
		  }
	  } ,
      error : e=>{}
   })
}

//1. 수정 (프로필,비밀번호)
function mupdate(){
	console.log('수정');
}




//2. 탈퇴
function mdelete(){
	//1.탈퇴여부 확인	confirm : 확인 
	let dconfirm=confirm('정말 탈퇴하시겠습니까?');
	//2.만약에 버튼을 눌렀을때
	console.log(dconfirm)
	if(dconfirm==true){
		let mpwd = prompt('비밀번호를 입력해주세요');
		//3. ajax
		$.ajax({ // mpwd가 있는지 검증
      	url : "/jspweb/MemberInfoController",
      	method : "post",
      	data : {mpwd:mpwd},
      	success : r=>{ 
			  if(r){
				  $.ajax({ // mpwd가 db에 있으면 그 비밀번호와 일치한 정보 삭제하기
				      url : "/jspweb/MemberInfoController",
				      method : "delete",
				      data : "" ,
				      success : r=>{
						  if(r){alert('삭제가 완료되었습니다.')
						   logout();}
						  else{alert('삭제오류!')}
					  } ,
				      error : e=>{}
   })
			  }
			  else{alert('없는 비밀번호입니다.')}
			  
		  } ,
      	error : e=>{alert(e)}
   })
	}
}



function mupdate(){
	
	// 첨부파일 전송할때
			//1. form dom객체 가져오기
	let form =document.querySelectorAll('.signupForm')[0];
	let formdata= new FormData(form);	
	
	$.ajax({
      url : "/jspweb/MemberInfoController",
      method : "put",
      data : formdata ,
      contentType:false,
	  processData:false,
      success : r=>{
		  if(r){alert('수정완료')
		 logout(); }
		  else{alert('수정오류')}
	  } ,
      error : e=>{}
   })
}