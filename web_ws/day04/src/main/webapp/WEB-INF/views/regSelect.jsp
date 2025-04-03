<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function check(){
		let frm = document.frm;
		let kind = frm.kind.value;
		
		if( kind==""){
			alert(" 종류를 선택하세요");
			return false;
		}else{
			return true;
		}		
	}
</script>
</head>
<body>	
	<form name="frm" action="/day04/regSelect"  method="post"   onsubmit="return check()">
		<select name="kind">
			<option value="">선택하시오</option>
			<option value="V">보컬</option>
			<option value="D">댄스</option>
			<option value="R">랩</option>			
		</select>
		<button>전송</button>
	</form>
</body>
</html>