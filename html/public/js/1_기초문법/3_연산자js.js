/*-연산자 [연산/계산 시 사용되는 특수문자]
				1. 산술연산자 : 결과값으로 출력
				+ 더하기 - 빼기 *곱하기 /나누기 %나머지
				몫 : parseInt 
				2. 연결연산자 : +연결연산자
						숫자+숫자[+ 더하기]				변수1 + 변수2 [만약에 두 변수모두 숫자가 저장되어 있으면]
						숫자+'문자'[+ 연결연산자]
						'문자'+'문자' [+연결 연산자]
				3. 비교연산자 : true 혹은 false 출력
				 			>초과/크다 		<  미만/작다
				 			>=이상/크거나 같다 	<= 이하/작거나같다		=>(x)
				 			==같다[데이터비교]   ===같다[데이터형/데이터 비교]
				 			!=같지않다/아니다    !==같지않다/아니다
				4. 관계연산자 : 주로 비교연산자 2개이상일때 사용 , true 혹은 false 출력
						&& 이면서 이고 모두 그리고 and   초등학생이 사탕이면서 초콜릿 먹을래	[모두참이면 참 모두 true 이면 true]
						|| 이거나 거나 또는 하나라도 or	  초등학생이 사탕이거나 초콜릿 먹을래	[하나라도 true 이면 모두 true]
						!  반대 부정 not 조건 				!true => false / !false => true
						
				5. 대입연산자 
							= 대입 [ 오른쪽 데이터를 왼쪽 대입]
							+= [오른쪽 데이터를 왼쪽에 더한후에 왼쪽에 대입]
								*	1.변수 = 10
									2.변수 += 30	[+= 1. 더하기를 한다(30+10=>40) 2.대입한다.]
									3. console.log( 변수 )
						-= *= /= %=
				6. 증감연산자   
						++ 1 증가	[선위증가 :++변수 후위증가:변수++]
						-- 1 감소[선위감소 :--변수 후위감소:변수--]
					
				7. 삼항연산자 : 항 3개 존재하는 연산자 , 참true or 거짓false 출력
						조건 ? 참true : false
						-만약에 조건이 true이면 참 실행
						-만약에 조건이 false이면 거짓 실행
						-- 중첩가능
						조간1 ? 참1 : 조건2 ? 참2 : 거짓
 */
//------------------------------------------------------------------------//
//연산자 연습

// 1. 산술연산자
console.log('더하기 :' +10+3)		//103
console.log('더하기:'+(10+3))		//13
console.log('빼기:'+(10-3))		//7
console.log('곱하기:'+(10*3))		//30
console.log('나누기:'+(10/3))		//3.333333~
console.log('나머지:'+(10%3))		//1

/* -문제1 : 국어 , 영어 , 수학 점수를 입력받아 각 변수에 저장하고 총점 출력 , 평균 출력
   -문제2 : prompt 함수 로 반지름 입력받아서 원넓이[ 반지름*반지름*3.14 ] 출력
   -문제3 : prompt 함수 로 두 실수를 입력받아서 앞실수의 값이 뒤실수의 값의 몇%인지 출력
   			-54.5 84.3 두실수 입력시 결과 : 64%
   */
  
//1.문제1번
//1.세 과목 함수 선언
let 국어=Number(prompt('국어 점수 : '))		//입력후에 변수에 저장 안하면 사라지니까 변수에 저장/대입
let 수학=Number(prompt('수학 점수 : '))
let 영어=Number(prompt('영어 점수 : '))
     //2.세 과목 총점 연산//
let 총점 = 국어 + 영어 + 수학
let 평균 = 총점/3
console.log('총점 =' + 총점)
console.log('평균 :'+ 평균)

//2.문제2번
//1.반지름 입력받기
let 반지름 = prompt('반지름 :')
//2.원넓이
let 원넓이 = 반지름*반지름*3.14
console.log('원넓이 : '+ 원넓이)


//3.문제3번
let 실수1=prompt("실수 1 :")
let 실수2=prompt("실수 2 :")
let 백분율=(실수1/실수2) * 100
console.log('두 실수간의 비율 : ' +백분율 +"%")

// 2. 비교연산자
console.log('초과 :' + (10>3))	//true
console.log('미만 :' + (10<3))	//false
console.log('이상 :' + (10>=3))	//true
console.log('이하 :' + (10<=3))	//false
console.log('같다 :' + (10==3))	//false
console.log('같지않다 :' + (10!=3))//true


// 관계연산자	
console.log('이면서 :' + (10>3 && 20>15))	//10은 3보다 크면서 20은 15보다 크다 //true
console.log('이면서 :' + (10>3 && 20>30))	//false
console.log('이거나 :' + (10>3 || 20>15 ))//10은3보다 크거나 20은15보다 크다//true or true//true
console.log('이거나 :' + (10>3|| 20>30))// true or false // true
console.log('부정 :' + !(10>3 ))	 	  // true => false


/*
 -문제4 : prompt 함수 로 정수를 입력받아 홀수[true] / 짝수[false] 여부 출력
 : %사용 나머지 값이 0이면 짝수 1이면 홀수*/
 
let 정수1=prompt('정수1:')
console.log('짝수 :' + (정수1%2==0))
console.log('홀수 :' + (정수1%2==1))

/*-문제5 : prompt 함수 로 정수를 입력받아 7배수이면 true / 아니면 false 출력
 * : %사용 7으로 나눈 값이 0이면 true 아니면 false*/

let 정수2=prompt('정수2:')
console.log('7배수' + (정수2%7==0))

/*문제6 : prompt 함수 로 십만원 단위의 금액을 입력받아 지폐 개수 세기 
         356789      결과 : 십만원3장 만원5장 천원6장 */
         
let 금액=prompt('금액:') ;console.log('입력받은 금액:'+금액)
	//1.십만원
	//금액/100000 => 3.56789
    //parseInt(금액/100000)=>3
let 십만원=parseInt(금액/100000); console.log('십만원권:'+십만원+"장")
	//2.만원권 계산 검사 [원금에서 십만원 제외한]
let 만원= parseInt( (금액-(십만원*100000)) /10000) ;console.log('만원권:'+만원+"장")
	//3.천원권 계산 검사
let 천원= parseInt( (금액-(십만원*100000)-(만원*10000))/1000); console.log('천원권:' + 천원+"장")

/*-문제7 : prompt 함수 로 아이디와 비밀번호를 입력받아 아이디가 admin 이고 비밀번호가 1234 와 일치하면 
         결과 : true 출력 아니면 false 출력
    * : 아이디 admin이고 비밀번호 1234 =>and 사용 */
let 아이디=prompt('아이디:')
let 비밀번호=prompt('비밀번호:')
console.log('로그인:'+ (아이디=="admin" && 비밀번호==1234))

/* -문제8 : prompt 함수로 정수를 입력받아 홀수 이면서 7배수이면 true 아니면 false 출력
 	* : 정수 % 나머지가 1이면 홀수 and 정수 /7% 값이 0이면 true =>and*/
let 정수=prompt('정수:')
console.log('정수 :'+(정수%2==1&&정수%7==0))


// 3.대입연산자
let 데이터= 10	//10
console.log(데이터)				 //let키워드 (변수)로 '데이터1' 이라는 변수명으로 10을 저장
데이터 +=10 		//20
console.log(데이터)				//1. 10+10=>20 ,20 대입 
데이터 -= 5
console.log(데이터)
데이터 *= 2
console.log(데이터)

//예제1
let html='<h3> JX에서 작성된 HTML 입니다.'			//html언어를 문자열 안에서 작성한다.
html += '<p> 문단 추가 했습니다. </p>'
// html [ <h3> JS에서 작성된 HTML 입니다.'<p> 문단 추가 했습니다. </p>']
document.write(html);		//document.write:html문서에
 

 //4.증감연산자 [data+1 , data+=1 ,data++]
 let 데이터2 =10
console.log('data: '+데이터2)		//10
console.log('data: '+데이터2++)	//10+1 출력은10
console.log('data: '+데이터2)		//11
console.log('data: '+(++데이터2)) //12

console.log('data: '+(데이터2--)) //10출력 10-1
console.log('data: '+ 데이터2)	//9
console.log('data: '+(--데이터2)) //8


//5.삼항연산자 [조건 ? 참:거짓(만약에 조건이 true이면 참 false이면 거짓)]
let 나이=38
let 연령구간 = 나이<=19 ?'청소년' :'성인'
console.log('연령구간: '+ 연령구간)
let 점수 =prompt('점수:')
let 등급 = 점수>=90 ? 'A' 
					:점수>=80 ? 'B' 
								:점수>=70 ?  'C'  
											:점수>=60 ? 'D' :'F' 
console.log('등급: '+ 등급)
 
   			 
/*  문제9 : 정수 2개를 입력받아 더 큰수 를 출력
*:정수2개 입력 a정수>b정수 참일시a 거짓일시 b*/

let 정수4=Number(prompt('정수4:'))
let 정수5=Number(prompt('정수5:'))
let 큰수= 정수4>정수5 ? 정수4:정수5
console.log('큰수:'+큰수)


/*문제10 : 정수 3개를 입력받아 가장 큰수 를 출력 
    *:정수3개 입력 a,b,c a>b=저장 a>c=저장 b>c=저장 
    			max=a 지정*/
let 정수a=prompt('정수a:')
let 정수b=prompt('정수b:')
let 정수c=prompt('정수c:')
let max = 정수a
max = max<정수b ?정수b:정수a
max = max<정수c ? 정수c:정수a
console.log('최고값:'+max)


//문제11 : 정수 3개를 입력받아 오름차순 으로 출력 
let 정수_1=prompt('정수_1:')
let 정수_2=prompt('정수_2:')
let 정수_3=prompt('정수_3:')
let max1=정수_1
let mid = 정수_1
let min=정수_1
max1 = max1<정수_2 ? max1:정수_2
max1 = max1<정수_3 ? max1:정수_3
min = min > 정수_2 ? min:정수_2
min = min > 정수_3 ? min:정수_3
mid =  (정수_1+정수_2+정수_3)-(max1+min)
console.log("오름차순: "+max1,mid,min)



 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 