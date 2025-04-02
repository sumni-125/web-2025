<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        * {
            padding: 0px;
            margin: 0px;
            font-family: 'S-CoreDream-3Light';
            src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_six@1.2/S-CoreDream-3Light.woff') format('woff');
            font-weight: normal;
            font-style: normal;
            text-decoration: none;
            color: black;
        }

        H1 {
            padding-bottom: 15px;
        }

        .wrap {
            height: 100vh;
            padding: 100px;
            background-image: url("https://i.pinimg.com/736x/46/66/be/4666bee6ca72a45b6407463d3c846484.jpg");
            background-position: center;
            background-size: cover;
            box-sizing: border-box;
        }

        .login_wrap {
            padding: 50px 100px;
            width: 500px;
            height: 700px;
            box-sizing: border-box;
            margin: 0 auto;
            background-color: rgba(255, 255, 255, 0.82);
            border-radius: 25px;
            border: 2px solid rgba(107, 107, 107, 0.144);
            text-align: center;
        }

        form {
            text-align: center;
        }

        label {
            display: block;
        }

        .inputbox {
            width: 300px;
            box-sizing: border-box;
            border: 1px solid rgba(107, 107, 107, 0.144);
            padding: 15px;
            margin-top: 10px;
        }

        .log-btn {
            background-color: rgb(218, 235, 255);
            box-sizing: border-box;
        }

        p {
            box-sizing: border-box;
            margin-top: 15px;
            padding: 10px;
        }

        a {
            text-decoration: none;
            color: black;
            padding-left: 10px;
        }

        label {
            display: block;
            padding-top: 10px;
            box-sizing: border-box;
            width: 300px;
            font-size: 20px;
        }
    </style>
</head>
<body>


	<div class="wrap">
        <div class="login_wrap">
        <form method="post">
            <h1>사칙연산</h1>
            
          
            <label>수1</label>
            <input class="inputbox" name="su1" required><br><br>  
            <label>수2</label>
            <input class="inputbox" name="su2" required><br><br>
            <select class="inputbox" name="a">
                <option value="+">+</option>
                <option value="-">-</option>
                <option value="*">*</option>
                <option value="/">/</option>
            </select>
            <button class="inputbox calc_btn" type="submit">계산하기</button>  
		</form>
        </div>
    </div>
   
<%

if( request.getParameter("su1")!=null && request.getParameter("su2")!=null && request.getParameter("a") !=null ){
	try{
		String su_1 = request.getParameter("su1");
		String su_2 = request.getParameter("su2");
		String a = request.getParameter("a");
		
		int su1 = Integer.parseInt(su_1);
		int su2 = Integer.parseInt(su_2);

		int result;

		switch(a) {

		case "+":
			result = su1+su2;
			break;
		case "-":
			result = su1-su2;
			break;
		case "*":
			result = su1*su2;
			break;
		case "/":
			if(su2!=0){
				result = su1/su2;
			}else{
				System.out.println("0으로 나눌 수 없습니다");
				result=0;
			}
			
			break;
		default :
			result=0;

		}	
%>
		<script>
			alert("사칙연산 (<%=a%>) 결과는 <%=result%>");
    	</script>
 <% 
	}catch(NullPointerException e1){
		
	}catch(NumberFormatException e2){
		
	}
}





%>
	
</body>
</html>