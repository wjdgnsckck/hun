setPoint(1000,'회원가입축하')
getPoint()
getPointList()
//1. 포인트 사용 함수
function setPoint(mpamount,mpcomment){
	if(loginState==false){return;}
	$.ajax({
		url : "/jspweb/PointController",
		method : "post",
		data : {mpamount:mpamount,mpcomment:mpcomment},
		success : result =>{console.log(result)
		},
		error : e =>{"ajax오류"+e}
	})
	
	
}


//2. 내 포인트 확인 함수
function getPoint(){
	if(loginState==false){return;}
		$.ajax({
		url : "/jspweb/PointController",
		method : "get",
		data : {type:"getPoint"},
		success : result =>{console.log(result)
		},
		error : e =>{"ajax오류"+e}
	})
}


//3. 내 포인트 내역 전체 출력함수
function getPointList(){
	if(loginState==false){return;}
		$.ajax({
		url : "/jspweb/PointController",
		method : "get",
		data : {type:"getPointList"},
		success : result =>{console.log(result)},
		error : e =>{"ajax오류"+e}
	})
}