let 아이디 =[]
let 비밀번호=[]
/* 회원가입 조건 
	1.아이디 중복x
	2.비밀번호 중복x
	3.아이디 비밀번호가 같아야함	 */
function create_id(){
	let idInput = document.querySelector(".id")
	let Id=idInput.value
	아이디.push(Id)
	let pwInput = document.querySelector(".pw")
	let Pw=pwInput.value
	비밀번호.push(Pw)
	if(Id==""||Pw==""){
		
	}


console.log(아이디)
console.log(비밀번호)

