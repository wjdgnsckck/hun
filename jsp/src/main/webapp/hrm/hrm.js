function preimg(object){console.log('사진 선택 변경')
	console.log(object) 
	
	console.log(object.files[0]); 
	
	
	let file = new FileReader(); 
	
	file.readAsDataURL(object.files[0]); 
	console.log(file)
	
	file.onload = e => { 
	console.log(e)  
		console.log(e.target.result)
		document.querySelector('.preimg').src=e.target.result}
	
	
	
}// f end

function regis () {
	let hrmForm = document.querySelectorAll('.hrmForm')[0];
	
	
	let hrmdata= new FormData(hrmForm);

	console.log(hrmdata)
	$.ajax({
		url:"/jspweb/HrmController",
		method:"post",
		data: hrmdata,
		contentType:false,
		processData:false,
		success : r =>{
			
			if(r){alert('등록완료');hread()}
			else{alert('등록실패')}
			
		},
		error : e =>{console.log("에러")}
	})
}
hread()
function hread(){
	$.ajax({
      url : "/jspweb/HrmController",
      method : "get",
      data : "" ,
      success : r=>{console.log(r)
	let output=document.querySelector('.hrmbtn')
	let html=``;
	for(let i =0 ; i<r.length ; i++ ){
		
		 html+=`<div class="hrmbtn"> 
					<div class="readid">${r[i].hname}</div>
					<div class="readph">${r[i].hphone}</div>
					<div class="readrk">${r[i].hrank}</div>
					<div class="readdate">${r[i].hdate}</div>
					<img class="box_himg" src="/jspweb/hrm/img/${r[i].himg}">
					<button type="button">수정</button>
					<button type="button">삭제</button>
				</div>`
	}
	output.innerHTML=html;
	
	  } ,
      error : e=>{
		  
	  }
   })

	
}