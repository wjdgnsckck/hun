
findByTop(10);

// 1. N개 제품들을 최신순으로 출력 함수 
function findByTop( count ) {
	$.ajax({
		url : "/jspweb/ProductInfoController" , method : "get" , 
		data : { type: "findByTop" , count : count } ,
		success : p => { console.log(p)
		let productBox =document.querySelector('.productBox');
		let html=``;
		p.forEach((r)=>{
			
		let firstImg = r.imgList[Object.keys(r.imgList)[0]];		/* Object.keys (객체명)*/
			console.log(r.imgList); 				//제품별 이미지 객체
			console.log(Object.keys(r.imgList)); 	//제품별 이미지 객체
			console.log(Object.keys(r.imgList)[0]);	//제품별 이미지 객체의 속성명 리스트 중에 첫번째 속석명
		
			html+=`<div class="col">
				<div class="card" style="width: 18rem;">
				 	 <img src="/jspweb/product/img/${firstImg}" class="card-img-top" alt="...">
				 	 <div class="card-body">
					  	  <h5 class="card-title">${r.pname}</h5>
					   	  <p class="card-text">${r.pcontent}</p>
					   	  <p class="card-text">${r.pprice}</p>
					   	 <a href="#" class="btn btn-primary">구매하러 가기</a>
				 	 </div>
				</div>
			</div>`
			
		});
		productBox.innerHTML=html;
			
			
			
		 }
	
	})
}

/*

	자바스크립트 객체
		형태 : let 변수명 = {속성명 : 데이터 , 속성명 :데이터 , 속성명 :데이터}
			- 데이터 : 데이터 (상수/변수) , 함수 , 배열/리스트 등등
			객체명.새로운속성명 = 데이터
			
	자바스크립스 배열/리스트
		형태 : let 변수명 = [ 데이터 , 데이터 , 데이터]
				배열명.push(데이터)
				배열명.splice(인덱스,개수)
				배열명[인덱스]



 */


function findByLatLng( east , west  ,  south  , north  ) {
	$.ajax({
		url : "/jspweb/ProductInfoController" , method : "get" , 
		data : { type: "findByLatLng" 	, 
				east :  east , west  : west ,  
				south  : south , north  :  north  
				} ,
		success : r => { }
	})
}
// 3. 선택된 제품번호에 해당하는 제품 출력 함수 
function findByPno( pno ) {
	$.ajax({
		url : "/jspweb/ProductInfoController" , method : "get" , 
		data : { type: "findByPno" 	, pno : pno  } ,
		success : r => { }
	})
}
// 4. 모든 제품들을 출력하는 함수 
function findByAll(   ) {
	$.ajax({
		url : "/jspweb/ProductInfoController" , method : "get" , 
		data : { type: "findByAll" 	 } ,
		success : jsonArray => { console.log( jsonArray ) }
	})
}