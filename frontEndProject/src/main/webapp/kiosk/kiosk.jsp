<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="/frontEndProject/css/kiosk.css" rel="stylesheet">
</head>
<body>
	<%@include file="../header.jsp"%>


	<div class="kioskwrap">
		<!--키오스크 start  -->
		<div class="kioskheader">
			<!--헤더 : 광고이미지/카테고리출력 표시되는 구역  -->
			<img class="himg" src="../img/himg1.png" />
			<!--카테고리  -->
			<ul class="categorymenu">
			<!--categoryPrint 함수가 html 넣어주는 위치  -->
		
			</ul>
		</div>
		<!--헤더 end  -->

		<div class="kioskcontent">
			<!-- 본문 : 제품출력/카트출력 구역 -->

			<div class="productbox">
				<!--제품구역start  -->
				<div class="product">
					<img src="../img/헬로디아블로와퍼.png" />
					<!-- 제품이미지 -->
					<div class="pinfo">
						<div class="pname">헬로 디아블로 와퍼</div>
						<!-- 제품이름 -->
						<div class="pprice">13,000원</div>
						<!--제품 가격  -->
					</div>

				</div>




			</div>
			<!-- 제품구역 end -->

			<div class="cartbox">						<!--카트 구역start  -->
						<div class="cartcontent">				<!--제품개수/가격,제품정보 출력  -->
						
							<div class="carttop">							<!-- 제품개수/총가격 -->
								<div>카트<span class="ccount">3</span></div>
								<div>총 주문 금액 <span class="ctotal">31,000</span></div>
							</div>
							
							<div	class="cartbottom">						<!--제품정보 출력 구역  -->
								<div	class="citem">
									<div class="iname">더블비프불고기버거</div>		<!-- 제품명 -->
									<div class="iprice">12,000원</div>				<!-- 제품가격 -->
									<span class="icencel">X</span>					<!-- 제품 개별 취소 -->
								</div>
								
								
								
								
							
							</div>
						
						</div>
						<div	class="cartbtn">		<!--버튼 구역  -->					
							<button class="cancelbtn">취소하기</button>
							<button class="orderbth">주문하기</button>		
						</div>
			</div>
			<!--제품구역 end  -->



		</div>
		<!-- 본문end-->

	</div>
	<!-- 키오스크 end -->

	<%@include file="../footer.jsp"%>
	<!-- 
		HTTP 상태 404 - 찾을 수 없음
		 		- 페이지 못찾았다 [ 1. 경로문제 2. 오타 3. 존재하지 않는 파일 ]등등
		 		
		
	 -->
	<script src="/frontEndProject/js/kiosk.js" type="text/javascript"></script>
</body>
</html>