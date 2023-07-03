//배열선언
let board1 = []

//처음 9개 버튼설정
for(let i=1; i<=9; i++){
	document.querySelector('#inputBox').innerHTML +=
	`<button class = "input" onclick="inputNumber(${i})"></button>`
	
	if(i%3==0){
		document.querySelector('#inputBox').innerHTML += '<br/>'
	}
}

//클릭시 클릭값 등록
function inputNumber(num){
	if(board1.indexOf(num) != -1) {
		
	alert('중복입니다.')
} else{board1.push(num)
	
	console.log(board1)}
	
	if(board1.length==6){
		board1.splice(0)
		alert('무승부입니다.')
	}
	
	computer()
}
document.querySelector('#inputbox').innerHTML +=
	`<button>${O}</button>`
//틱택토 난수 구현
function computer(){
	alert('컴퓨터차례입니다.')
	for(let i = 0 ; i<=8 ; i++){
		let computerNumber=(parseInt(Math.random()*8))
		if(board1.indexOf(computerNumber)==-1){
			board1.push(computerNumber);
			return;
		}
	}
}
console.log(board1)

	
