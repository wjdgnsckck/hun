/**
 * 
 */
let sitNumber = -1
let sitList = []
sitRender()
 function sitRender()
 {
    
    let view = document.querySelector('.sitBtnView');
    view.innerHTML = ``
    sitList=[]
        $.ajax({
      url : "/jsp/LibraryController",
      method : "get",
      async : false,
      success : function f(r){
         for(i = 0;i <r.length;i++)
         {
            sitList.push(r[i])
         }
         
      },
      error : function f(r){
         console.log('통신실패');
      }
   });

   console.log(sitList)
   for(i=1;i<sitList.length+1;i++)
   {
   
      let isOn=""
      if(sitList[i-1].lname ==null){
		  isOn = "notreservation"
	  }else{isOn="reservation"}
      view.innerHTML += `<button  class = "${isOn}"onclick="selectSit(${i})">  ${isOn} 방번호(${i}) </button>`
      if( i % 4 == 0) view.innerHTML += `</br>`

   }

   
   
 }
 
 function selectSit(lno)
 {
    
    
    sitNumber = lno
    
 }
function enterace()
 {
    let _name = document.querySelector('.nameInput')
    let _phone = document.querySelector('.phoneInput')
    if(_name.value.length == 0 || _phone.value.length == 0|| sitNumber == -1)
    {
       alert("필수정보 미기입")
       return
    }
    let info = {
       lno : sitNumber,
       lname : _name.value,
       lphonenumber :_phone.value
    }
    $.ajax({
      url : "/jsp/LibraryController",
      method : "put",
      data : info,
      success : r=>{sitRender()
        if(r==true)alert('예약완료')
        else alert('이미 예약된 자리입니다.')
        

      },
      error : function f(r){
         console.log('예약실패');
           alert('예약실패')
      }
   });
    
 }
  function leave()
 {
    
       $.ajax({
      url : "/jsp/LibraryController",
      method : "delete",
      data : {lno:sitNumber,getphone:prompt("전화번호 입력")},
      success : function f(r){
         if(r) alert('퇴실성공')
         else console.log("전화번호 불일치 or 예약되지 않은 자리")
      },
      error : function f(r){
         console.log('통신실패');
      }
   });
   
   sitRender()
 } 
 
 
function manager() { console.log('관리자')
	 let mname = document.querySelector('.mname')
	 let mpassword = document.querySelector('.mpassword')
	 let managerName= 'asdasd';
	 console.log(mname)
	 let managerPassword=1234;
	 console.log(managerPassword)
	 if(mname==managerName&&mpassword==managerPassword){
		 alert('관리자확인')
	 }
	else{alert('관리자가 아닙니다!');return }
	 
	 
	 
	 $.ajax({
      url : "/jsp/MangerController",
      method : "post",
      data : info ,
      
      success : function f(r){console.log("통신완료")} ,
      error : function f(r){}
   })
	 
 }
 