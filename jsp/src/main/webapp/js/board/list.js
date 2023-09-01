
//1. 글쓰기 버튼을 글릭하면
function onWrite(){
	if(loginState){  // - 만약에 비 로그인이면
		location.href="/jsp/board/write.jsp"
	}
	else{
		alert('로그인후 글 등록이 가능합니다.')
		location.href="/jsp/Member/login.jsp"
	}
	// - 만약에 비 로그인 이면 로그인 페이지로 이동

	// - 로그인이면 쓰기 페이지 이동
}