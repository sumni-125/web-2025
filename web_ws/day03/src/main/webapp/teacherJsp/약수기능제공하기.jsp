<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h2> 약수 제공하기  jsp </h2>
<h2> 약수 기능을 여러번 사용하고 싶다면  매서드로 만들어서 제공해야한다. 클래스-매서드 만들어서 제공하기 </h2>
<%	

	//요청시 값을 반드시 제공해야 한다

 
	int su  =  Integer.parseInt( request.getParameter("su") );	


	int su_half = su/2;	
	System.out.println( su);
	System.out.println( su_half);		
	ArrayList<Integer> nums = new ArrayList<>();
	
	for( int i=1 ; i<=su_half ; i++) {
		 if( su % i  ==0) {
			 nums.add(i);
		 }
	}		
	nums.add(su);		 
	String divisors = nums.toString();
	System.out.println( divisors);	 
	out.println( divisors);
	 
%>

</body>
</html>