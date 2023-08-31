
//1. 현재 로그인된 회원정보 요청
getMemberInfo();


function getMemberInfo(){
	
	//1. ajax 이용한 서블릿 세션 정보 가져오기
	$.ajax({
      url : "/jsp/MemberInfoController",
      method : "get",
      data : {type : "info"} ,
      success : r=>{
		    let submenu=document.querySelector('.submenu')
		    let html=``;
		  if(r==null){ //비로그인 상태
		  console.log(r)
			 html+= `<li><a href="/jsp/Member/signup.jsp">회원가입</a></li>
					<li><a href="/jsp/Member/login.jsp">로그인</a></li>`;
		  }else{//로그인
			  html+=`<li>qweqwe님</li>
			<li><img class="hmimg" src ="/jsp/Member/img/${r.mimg}"></li>	<!-- 서브 메뉴  -->
			<li><a onclick="logout()" href="#">로그아웃</a></li>
			<li><a href="/jsp/Member/info.jsp">마이페이지</a></li>
			`;			
			  
		  }
		 submenu.innerHTML=html;
	  } ,
      error :e=>{}
   })
}
//2. 로그아웃 함수 [ 서블릿에 세션을 삭제 그리고 로그아웃 성공시 메인페이지로 이동]
function logout() {
	$.ajax({
      url : "/jsp/MemberInfoController",
      method : "get",
      data : {type : "logout"} ,
      success : r => {
		  location.href="/jsp/index.jsp"
	  },
      error : e => {console.log(e)}
      })
	
}