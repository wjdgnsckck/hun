<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--부트스탭 CSS  -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>

	<!--jspweb파일안에 다른 jspweb 파일 import 하기  -->
	<%@include file="header.jsp"%>
	
	<!--이미지 슬라이드 start  -->
	<div id="carouselExample" class="carousel slide carousel-fade"
		data-bs-ride="carousel">
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="0" class="active" aria-current="true"
				aria-label="Slide 1"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="1" aria-label="Slide 2"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="2" aria-label="Slide 3"></button>
		</div>
		<div class="carousel-inner">
			<div class="carousel-item active" data-bs-interval="1000">
				<img src="/jspweb/img/쇼핑몰.png" class="d-block w-100" alt="...">
				<div class="carousel-caption d-none d-md-block">
					<h5>First slide label</h5>
					<p>Some representative placeholder content for the first slide.</p>
				</div>
			</div>
			<div class="carousel-item">
				<img src="/jspweb/img/쇼핑몰1.png" class="d-block w-100" alt="...">
				<div class="carousel-caption d-none d-md-block">
					<h5>추석</h5>
					<p>명절선물 사야겠지?</p>
				</div>
			</div>
			<div class="carousel-item">
				<img src="/jspweb/img/쇼핑몰2.png" class="d-block w-100" alt="...">
				<div class="carousel-caption d-none d-md-block">
					<h5>기프트카드</h5>
					<p>나도 줘!</p>
				</div>
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExample" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> 
			<span class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExample" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> 
			<span class="visually-hidden">Next</span>
		</button>
	</div><!-- 이미지 슬라이드 end -->
	
	<!-- 카드(bs) : 다양한 컨텐츠를 표시하는 컨테이너[구역]  -->
	<div class="container">
		<div class="row row-cols-1 row-cols-md-4 g-4">
		  	<div class="col">
				<div class="card" style="width: 18rem;">
				 	 <img src="/jspweb/img/명절선물.png" class="card-img-top" alt="...">
				 	 <div class="card-body">
					  	  <h5 class="card-title">국내산 1++등급 한우</h5>
					   	  <p class="card-text">1++ 투뿔 한우선물세트 꽃등심 특수부위 소고기 구이 추석 설 명절 부모님 선물 등바구니</p>
					   	  <p class="card-text">117,990원</p>
					   	 <a href="#" class="btn btn-primary">구매하러 가기</a>
				 	 </div>
				</div>
			</div>
			
			<div class="col">
				<div class="card" style="width: 18rem;">
				 	 <img src="/jspweb/img/명절선물.png" class="card-img-top" alt="...">
				 	 <div class="card-body">
					  	  <h5 class="card-title">국내산 1++등급 한우</h5>
					   	  <p class="card-text">1++ 투뿔 한우선물세트 꽃등심 특수부위 소고기 구이 추석 설 명절 부모님 선물 등바구니</p>
					   	  <p class="card-text">117,990원</p>
					   	 <a href="#" class="btn btn-primary">구매하러 가기</a>
				 	 </div>
				</div>
			</div>
			<div class="col">
				<div class="card" style="width: 18rem;">
				 	 <img src="/jspweb/img/명절선물.png" class="card-img-top" alt="...">
				 	 <div class="card-body">
					  	  <h5 class="card-title">국내산 1++등급 한우</h5>
					   	  <p class="card-text">1++ 투뿔 한우선물세트 꽃등심 특수부위 소고기 구이 추석 설 명절 부모님 선물 등바구니</p>
					   	  <p class="card-text">117,990원</p>
					   	 <a href="#" class="btn btn-primary">구매하러 가기</a>
				 	 </div>
				</div>
			</div>
			<div class="col">
				<div class="card" style="width: 18rem;">
				 	 <img src="/jspweb/img/명절선물.png" class="card-img-top" alt="...">
				 	 <div class="card-body">
					  	  <h5 class="card-title">국내산 1++등급 한우</h5>
					   	  <p class="card-text">1++ 투뿔 한우선물세트 꽃등심 특수부위 소고기 구이 추석 설 명절 부모님 선물 등바구니</p>
					   	  <p class="card-text">117,990원</p>
					   	 <a href="#" class="btn btn-primary">구매하러 가기</a>
				 	 </div>
				</div>
			</div>
		</div>
	</div>

	<!--jspweb파일안에 다른 jspweb 파일 import 하기  -->
	<%@include file="footer.jsp"%>
	<!--부트 스탭 JS  -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>