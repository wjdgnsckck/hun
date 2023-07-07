console.log('js시작')



//------------------------------샘플데이터-------------------
//1.광고이미지 변경			//1. 광고이미지 여러개 = 배열
let bimgList=[	'himg1.png'	,'himg2.png','himg3.jpg','himg4.png','himg5.png'];
//1.카테고리 여러개 저장하는 배열
let categoryList = ['신제품(NEW)', '프리미엄','와퍼&주니어','치킨&슈림프버거','올데이킹&킹모닝']
//1. 제품 여러개 저장하는 배열
		//서로 다른 유형들의 데이터 여러개 저장 = 객체{}
		//동일한 유형들의 데이터 여러개 저장 = 베열/리스트[]
	

let burgerList=[
		{name :'헬로디아블로와퍼',price : 9500, img : '헬로디아블로와퍼.png', category:0},
		{name :'헬로릴리트와퍼',price : 12500, img : '헬로릴리트와퍼.png', category:2},
		{name :'치킨킹',price : 8000, img : '치킨킹.png', category:3},
	
]
// 1. 카트(장바구니) 배열  / 선택 버거들이 저장되는 배열
		//1. 버거 ?? 2. 버거의식별?? - > 버거제품번호 대신에 인덱스
let cartList=[]
		//1. 주문(주문내역) 배열
		/*
			주문{주문번호 : , 주문날짜 : , 주문금액 : , 주문제품: [] , 상태 : true[주문]/false[완료]}
		*/
let orderList=[
	{ono:1 , date: '2023-07-05 13:30:21', pay:27000, products : [0,0,2] ,state:1 }  
	
]
//---------------------------------------------------------------------//



//1.광고이미지 변경
			//1. 광고이미지 여러개 = 배열

			//2. 특정시간마다 이미지의 src 변경하기
				//-setInterval(함수/기능,밀리초): 밀리초 = 1/1000초				
				//1.function 함수(){ } 2.function(){} 3. () => {}
				//setInterval(()=>{ 실행코드},2000 );			// 2초마다 주기적으로 실행한다.
let viewhimg=0;			//현재 출력중인 광고이미지 인덱스 저장
setInterval(()=>{ 
	// 1. 해당 이미지 태그 객체 호출
	let himg=document.querySelector('.himg');
	//2. 호출된 객체 에서 src 속성 대입/바꿔치기
	
			//배열내 이미지 하나씩 바꿔가져서 대입
	viewhimg++;				//인덱스 증가시킴[ 다음 이미지로 변경한다]
				//만약에 마지막인덱스 다음이면[끝] 처음인덱스[0] 이동
	if(viewhimg>=bimgList.length){viewhimg=0;}
	himg.src =`../img/${bimgList[viewhimg]}`;	

},2000 );
//2.카테고리 출력	함수
		//1.카테고리 여러개 저장하는 배열

		//2.카테고리 출력 함수 정의 [실행 조건 :??]
categoryPrint(0)	; // 최초 1번 실행 [ 가장 앞에 있는 카테고리 선택 가정]
function categoryPrint(selectNo){											//카테고리 출력함수 start
		//1.어디에
		let categorymenu=	document.querySelector('.categorymenu'); console.log(categorymenu);
		//2.무엇을
		let html =``;
				//HTML 구성 : 배열내 모든 데이터(for)를 li형식으로 출력.
		for(let i = 0 ; i<categoryList.length; i++){
			if(i== selectNo){
					//선택된카테고리[selectNo] 와  i 와 같으면 i번째 인덱스 선택된 카테고리
					html += `<li onclick="categorySelect(${i})"class="categoryselect">${categoryList[i]}</li>`
			}else{	html += `<li onclick="categorySelect(${i})">${categoryList[i]}</li>`}
			
			
		}
		
		categorymenu.innerHTML=html;
		prodectPrint(selectNo);
		
};					// 출력함수 end

//3.카테고리 클릭 함수		[ 실행 조건 : 1. li에서 클릭했을때]

function categorySelect( selectNo ){
	// <li> 여러개 존재 하는데 무엇 선택했는지 식별
	console.log( selectNo );
	// 0. 카테고리의 모든 li 호출 [ querySelector 1개호출 = 객체1개 vs querySelectorAll 여러개호출 = 여러개객체(배열) ]
	let categoryli = document.querySelectorAll('.categorymenu li'); // 해당 클래스 ul 안에 있는 모든 li 호출 
		console.log( categoryli )
		
	// 1. 해당 선택된 인덱스의 class 추가 // !!!  JS에서 class 추가 / 삭제 가능 
	for( let i = 0 ; i<categoryList.length ; i++ ){
		// 2. 선택된 카테고리[selectNo]의 i번째 카테고리 찾기 
		if( selectNo == i ){ // 해당 li 에 class 추가   	DOM객체명.classList.add( '새로운클래스명' )
			categoryli[i].classList.add('categoryselect');
		}else{ // 해당 li 에 class 삭제 		DOM객체명.classList.remove( '삭제할클래스명' )
			categoryli[i].classList.remove('categoryselect');
		}
	}
	// 3. 
	prodectPrint(selectNo);
}

//----------------------------------------------------//

//4. 제품 출력 함수	[실행 조건 : 1.카테고리 클릭(변경)하면 실행]
function prodectPrint(categoryNo){		//어떤 카테고리의 제품 출력할건지??
	//1.어디에
	let productbox=document.querySelector('.productbox')	
	//2.무엇을	[선택된 카테고리에 맞는 제품만 출력]
	let html=``;
			//html 구성
			for(let i = 0 ; i<burgerList.length ; i ++){// 모든 버거리스트 열어서 확인
				// i번째 버거의 카테고리 와 선택한 카테고리가 같으면 html구성 / 아니면 굿
				if(burgerList[i].category==categoryNo){
					html  +=`<div onclick="productSelect(${i})" class="product">
					<img src="../img/${ burgerList[i].img }" />
						<div class="pinfo">
						<div class="pname">${burgerList[i].name}</div>
						<div class="pprice">${burgerList[i].price.toLocaleString()}원</div>
						</div>
					</div>`
				}
			}
	//3.출력[대입]
	productbox.innerHTML=html
	
}
//5.제품 선택해서 카트에 담는 함수 [ 실행 조건 : 1. 제품 이미지 클릭 하면]
function productSelect(productNo){	//어떤 제품을 카트에 담은건지??
	//1. 선택된 버거의 인덱스를 배열에 저장 [ 버거 모든 정보 저장 필요없다]
	cartList.push(productNo); console.log(cartList);
	
	carPrint();
	
}

//6. 카드내 버거들을 출력함수
		//카트를 클릭시(5)! 카트내 제품이 삭제시(7,8)
function carPrint(){				//인수판단 :: 모든 카트내 제품출력


	//어디에??
	let cartbottom=document.querySelector('.cartbottom')
	
	//무엇을?? 카트내 [배열내] 모든 제품 출력
	let html=``;
		let totalPrice = 0;;
		for(let i = 0 ; i<cartList.length ; i++){
		
			//1. 카트내 버거의 인덱스
			let bugerIndex=cartList[i];
			
			html+=`<div	class="citem">
									<div class="iname">${burgerList[bugerIndex].name}</div>		
									<div class="iprice">${burgerList[bugerIndex].price.toLocaleString() }원</div>				
									<span  onclick="productCancel(${i})"   class="icencel">X</span>					
						</div>`
						totalPrice +=burgerList[bugerIndex].price
	}
	//출력/대입
	cartbottom.innerHTML=html;
	//* 카트내 제품수
	document.querySelector('.ccount').innerHTML=`${cartList.length}`;
	
	//* 카트내 제품 총가격
	console.log( document.querySelector('.ctotal')  )
	console.log(totalPrice )
	
	document.querySelector('.ctotal').innerHTML=`${totalPrice.toLocaleString()}원`;
	//*만약에 카트내 제품이 많아서 가로 스크롤 생성 되었을때 가장오른쪽으로 이동
	cartbottom.scrollLeft = 10000;
}
//7. 카드내 버거 부분 취소 함수		
	//x표시 클릭시! 배열에 있는 내용 splice 카트 -1 총금액 -금액제거
function productCancel(cartIndex){	//전체취소:인수x 부분취소:
	//1. 선택된 카트배열내 인덱스 삭제
	cartList.splice(cartIndex,1); alert('버거 취소 했습니다.');
	carPrint(); // 화면에 업데이트
}
//8. 카드내 전체 취소 함수[실행 조건 : 취소하기 버튼을 클릭했을때, 주문완료 되었을때]		
function cartCanel(){	//전체취소 : 모두취소 : 인수x
	cartList.splice(0);

	carPrint();		//화면에 업데이트
	
}

//9. 카트내 저장된 버거 주문(등록) 함수 []
function  productOrder(){
	alert('주문 했습니다.')	
	//*주문번호 만들기		//마지막인덱스 : 배열명.length-1
	let ono=orderList[ orderList.length-1].ono;		//주문배열내 마지막주문의 번호
	
	//*카트(전역변수)에 있던 버거인덱스를 새로운 배열내 저장
	let products=[];	//주문이 들어가는 버거들인덱스
	let totalPrice=0;
	for(let i = 0 ; i<cartList.length ; i++){
		products.push(cartList[i]);
		totalPrice +=burgerList[cartList[i]]	.price			//i번째 버거의 인덱스 가격
	}
	//1. 주문객체 생성
	let order={
		oro:  ono+1,					//주문번호 생성 해서 저장[마지막 주문번호+1]
		date : new Date(),			//현재날짜/시간 구해주는 함수를 이용해서 자동으로 대입
		pay : totalPrice	,						
		products : products,
		state: 0							//주문객체 생성시 ' 주문요청'으로 상태 초기화
		
	}
	orderList.push(order);		alert('주문완료')
	
	cartCanel();	//전체취소 함수와 동일하기 때문에 재호출
	
	
	console.log(orderList)

}



















