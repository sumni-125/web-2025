<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>

<script>
function getData(){
	
	
	let page  =  $("#page").val(); 
	page=  parseInt(page);
	page = page+1; 
	
	
	$.ajax( 
	{
		type: "get",			 
		url: "/ajaxPaging/foodPage"  ,	
		data:{page: page},		
		success: function( data){
			 			
			console.log(data);	
			//
			let list = data.list;
			
			let str="<ul>";
			for(let i=0; i< list.length; i++){
				let item  = list[i];
				str+= "<li>"+ item.name +  item.price + "</li>"
			}
			str+= "</ul>";
			
			
			// $("#result").html( str );		
			  $("#result").append( str );		
			 $("#page").val( data.page );
			 
		},
		error: function(err ){	
			 //
			 alert("요청에 실패했습니다");
			 console.log( err);
		}
	 }
   );     
	
	
}

 
  
</script>
</head>
<body  onload="getData()">


Main화면




<div  id="result"> 결과</div>
<button onclick="getData()">더보기</button>


<!--  hidden  바꾼다 -->
<input type="text"  id="page" value=0>
</body>
</html>