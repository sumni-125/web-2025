<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
 
<script>
function check(){
	let frm = document.frm;
	let hobby  = frm.hobby ;		
	let flag=false;	  
	for( let i=0; i<hobby.length ; i++){
		if( hobby[i].checked){
			flag=true;
			break;
		}
	}	
	
    if (!flag) {
        alert(" 취미를 선택해 주세요!");
        return false;
    } else {
        return true;
    }
}
</script> 
<body>

<h2>등록</h2>

 
<form name="frm" action="/day04/regCheck" method="post"   onsubmit="return check()">
		<label><input type="checkbox" value="book"  name="hobby">독서</label>
        <label><input type="checkbox" value="movie" name="hobby">영화</label>
        <label><input type="checkbox" value="sleep" name="hobby">잠자기</label>        
		<button >전송</button>
 </form>

 

</body>
</html>