<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2> jsp란</h2>


 동적인페이지를 제공하는 자바의 기술이다
 서브릿은 웹문서를 제공(응답)하기에는 불편함을 가지고 있다.
 jsp로 만든 문서는 서블릿으로 변환되어 서비스가 제공된다.
 
 
 
 jsp로 만들어 지는 내용전체가  서블릿으로 변환될 때  service 매서드 안에 생성된다
 
 
 <h2>둘의 차이는? </h2>
 
 <p>서블릿 => 자바코드   +   응답 내용 html로 작성</p>
 <p>jsp  => 응답내용   +  자바코드</p>  
 
 
 <문법>
  
  
 서블릿에 제공하는 객체를 내장객체로 제공한다  <br>
 내장객체를 외울필요없다. 
 
 request , response, out, session, application ,pageContext
 
 스크립트릿 : 자바코드 작성한다  
 표현식 : 서버가 응답하는 내용을 작성한다 



<h2>내장 객체</h2>

<ul>
<li>request => HttpServletRequest 형의 객체가 제공된다 .   클라이언트의 정보를 얻어올 때 사용함 ,
               하나의 요청이 응답하기전까지 유지해야하는 값을 저장할 저장소로 사용함</li>
<li>response => HttpServletResponse 형의 객체가 제공된다 .   클라이언트에게 응답할 때 사용한다.</li>
<li>out =>   클라이언트에게 응답할 출력용 스트림 객체가 제공된다. jsp로 출력시 out객체 사용</li>

<li>out =>   클라이언트에게 응답할 출력용 스트림 객체가 제공된다. jsp로 출력시 out객체 사용</li>
<li>session => http는 무상태 이므로 한 명의 사용자의 정보를 계속 유지해야 할 때 저장소로 사용한다.</li>
<li>application => 하나의 프로그램(웹사이트)내에서 공유해야 하는 정보를 유지해야 할 때 저장소로 사용한다</li>

</ul>
 
</body>
</html>