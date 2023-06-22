/*
 
 
	  반복문 : 어디서부터 어디까지
			1. 
			for ( 1.초기값; 2. 조건문; 4.증감식  ){
			 3.	실행문;
		 }
				1. 초기값 : 반복의 처음값
					; : 구역구분
				2. 조건문 : 조건이 true이면 {}실행 아니면 {}실행 안함
					; : 구역 구분
				3. 실행문 : 반복시 실행될 코드
				4. 증감식 : 반복변수 증가/감소 단위
			ex) 1부터 10까지 1씩증가 반복
				for(let i = 1; i <=10 ; 1++){}
			ex) 1부터 100까지 홀수만 반복
				for(let i = 1; i<=100 ; 1+=2){}	
	  	
 */
// 1.
// let i = 0 ; // 1. 초기값 (i는 반복시 사용되는 증감변수 = 임의변수명)
// i<10		   // 2. 조건문 ( { } 실행되는 조건)
// i++ 		   // 3. 증감식 ( { } 실행후 다음으로 증감변수 계산식 )
for (let i = 0; i < 3; i++) {		//for s
	// i 는 0부터 10미만까지 1씩증가 반복
	console.log('반복횟수 :' + i)
}

// 2. 배열( 인덱스 )과 반복문
let 상자 = ['사과', '포도', '딸기']
// 1. 반복문 없을때	[인덱스 다수일때 힘듬]
console.log(상자[0]);
console.log(상자[1]);
console.log(상자[2]);

//2. 반복문 사용할때	[i반복변수를 인덱스 대신 사용]		//*배열 인덱스는 0부터 시작
for (let i = 0; i < 상자.length; i++) {	//for s
	console.log(상자[i]);
}		//for end


console.log('------------ex-------------------');
// 예제1) i는 1부터 10이하까지 1씩 증가 반복	한줄씩 표시
for(let i = 1 ; i<=10 ; i++){
	console.log(i)
}

// 예제2) i는 1부터 10이하까지 1씩 증가 반복[ 한줄에 표시]
console.log('------------ex2-------------------');
let output =''								//문자열 누적 output 선언
for(let i = 1 ; i<=10 ; i++){				//f s
	output += `${i}  `						//(+=) i변수를 output변수에 추가
}											//f end
console.log(output)

// 예지 3) i는 1부터 10이하까지 1씩 증가 반복[HTML 표시]

console.log('------------ex3-------------------');
output = ''								//위에 서 선언문 output변수를 재선언 하지 않고 공백으로 대입(초기화)
for(let i = 1 ; i<=10 ; i++){
	output += `<p>	${i}	</p>`
}
document.write(output);

//예제4)i는 1부터 10이하까지 1씩 증가 반복(누적합계)
console.log('------------ex4-------------------');
let sum = 0;
for(i=1 ; i<=10 ; i++){//for start
	//sum=sum+i 랑 똑같음
	sum +=i	//(+=) sum변수에 i를 더한값을 sum번수 에 대입
 	
}	//for end
console.log(sum)


//예제5) i는 1부터 100까지 7배수 누적 합계
console.log('------------ex5-------------------');
		//1.7씩 증가방식
sum=0;
for (let i=0 ; i<=100 ; i+=7){
	sum +=i
}	
console.log(sum)	
		//2.if(i%7==0)
sum=0;
for(let i=0 ; i<=100 ; i++){
	if(i%7==0){
		sum+=i
	}
}
console.log(sum)

//예제6)  [구구단] 2단
console.log('------------ex6-------------------');
const two=2;
for(i=1; i<10 ; i++){	//f	start				//변수는 문자처리x
	console.log(`${two} x ${i} = ${two*i}`)		//문자열${변수}
	console.log(two+'x'+i+'='+two*i)			//문자열+변수
}		//f end

//예제7) [구구단]		for(){for(){}}		변수 두개 단,뒤에 곱 지정
console.log('------------ex7-------------------');

for(let 단 = 2 ; 단<=9 ; 단++){//단 for start
	
	for(let 곱 = 1 ; 곱<=9 ; 곱 ++){//곱 for start
		
		console.log(`${단} x ${곱} = ${단*곱}`)
		
		} //곱 for end
}//단 for end





/*
순서도 = 알고리즘 != 자료구조
		// 알고리즘 연습방법 = * 생활속 순서도,백준,프로그램개발 순서
	
1.	let i = 0 			=> i=0
2.  i<3					=> true			=>{}
3.console.log();		=> 0출력
------
4. i++ 					=> i=1
5.	i<3					=>true			=>{}
6.console.log();		=>1출력
---	
7. i++ 					=> i=2
8.	i<3					=>true			=>{}
9.console.log();		=>2출력
----
10. i++					=> i=3
11. i<3 				=>false => 못들어감
12. 반복문 종료
}	//for end
 
*/

























