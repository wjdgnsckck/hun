
let output=''; 					//출력용 변수[모든 문제에서 사용]
//문제1) 입력받은 수 만큼 * 출력 
console.log('-----------ex1--------');
let value1 =prompt( '문제1:')
for(let i = 1; i<=value1 ; i++){		//for start
	//i는 1부터 입력받은 수까지 1씩증가 반복
	output +='*';
}	//for end
console.log(output)
//문제2)
console.log('-----------ex2--------');
output=''
let value2 =prompt( '문제2:')
for(let i = 1; i<=value2 ; i++){
	output +='*';
	//만약에 i값이 3배수 이면 줄바꿈처리
	if(i%3==0){output+=`\n`}		//\ 제어문자(이스케이프문자) \t :들여쓰기 \n: 줄바꿈
	
	
}
console.log(output) 

//문제3) 입력받은 줄 수 만큼 * 출력  [ ex) 5 ]
console.log('-----------ex3--------');
output=''
let value3 =prompt( '문제3:')
for(let i=1; i<=value3 ; i++){
	//[별찍기]
	for(let s = 1; s<=i; s++ ){
		output+='*'
	}
	
	//[줄바꿈]
	output += `\n`;
		
}
console.log(output)
//문제4) 입력받은 줄 수 만큼 * 출력 [ ex) 5 ]
console.log('-----------ex4--------');
output=''
let line2 =prompt( '문제4:')
for(let i=1; i<=line2 ; i++){
	
	for (let s = line2 ; s>=i ; s--){
		output +='*'
		}
		
		output+='\n'
}
console.log(output)
/* 강사님 두번째 for 방법
	for(let s = 1 ; s<=line2-i+1 ; s++)
*/
//문제5) 입력받은 줄 수 만큼 * 출력 [ ex) 5 ]
console.log('-----------ex5--------');
output=''
let line3 =prompt('문제5:')
for(let i=1; i<=line3 ; i++){
	//[공백]
	for(let b = 1; b<=line3-i ; b++){
		output+=' '
	}for(let s = 1; s<=i ; s++){
		output+='*'
	}
	
	//[줄바꿈]
	output += `\n`;
}

console.log(output)
 
// 문제6) 입력받은 줄 수 만큼 * 출력 
console.log('-----------ex6--------');
output=''
let line4 =prompt('문제6:')
for(let i = 1 ; i<=line4 ; i++){
	//공백
	for(let b = 1 ; b <=i-1; b++){output+=' '}
	//별
	for(let s=1; s<=line4-i+1; s++){output+='*'}
	//줄바꿈
	output+=`\n`;
}
console.log(output) 


// 문제7) 입력받은 줄 수 만큼 * 출력 
console.log('-----------ex7--------');
output=''
let line5 =prompt('문제7:')
for(let i = 1; i<=line5 ; i++){
	//공백
	for(let b=1 ; b<=line5-i ; b++){output+=' '}
	//별
	for(let s=1 ; s<=i*2-1; s++){output+='*'
}

	//줄바꿈
	output+=`\n`
	
}

console.log(output)
// 문제8) 입력받은 줄 수 만큼 * 출력 
console.log('-----------ex8--------');
output=''
let line6 =prompt('문제8:')
for( let i = 1; i<=line6 ; i++){
	//공백
	for(let b = 1; b<=i-1 ; b++){
		output+=' '
	
	}
	//별
	for(let s = 1 ; s<s*(5-i); s++){
		output+='*'
	}
	output+=`\n`
}
console.log(output)

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 