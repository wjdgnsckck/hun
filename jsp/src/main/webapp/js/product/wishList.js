
ProductView();


let checkList=document.querySelectorAll('.checkbox');
		console.log(checkList)

checkList[0].addEventListener('click',(e)=>{
	
	if(checkList[0].checked==true){
		checkList.forEach((check)=>{check.checked=true;} )
	}else{
		checkList.forEach((check)=>{check.checked=false;})
	}
})
if(loginState==false){alert('로그인후 사용가능한 페이지');location.href = "/jspweb/member/login.jsp"}


function ProductView() {
	$.ajax({
		url: "/jspweb/PwishListController",
		method: "get",
		async:	false,
		data: { type: "findByAll" },
		success:jsonArray => {
			
			let table=document.querySelector('.table');
			
			let html = `<tr>
	  				<th width="5%"><input class="checkbox" type="checkbox"></th>
	  				<th width="5%"> 이미지 </th>
	  				<th width="40%"> 제품 정보 </th>
	  				<th width="10%"> 가격 </th>
	  				<th width="10%"> 비고 </th>
	  					</tr>`;
	  			
				jsonArray.forEach((p)=>{
				html+=`<tr>
		  					<td><input  class="checkbox"  type="checkbox"></td>
		  					<td><img src = "/jspweb/product/img/${Object.values(p.imgList)[0]}" height="100%"> </td>
		  					<td> ${p.pcname}</td>
		  					<td> ${p.pprice.toLocaleString()}</td>
		  					<td> <button type="button">X</button></td>
	  					</tr>`
	  				
				})
				table.innerHTML=html;
			
			
		},
		error: e => { console.log(e) }

	})
}