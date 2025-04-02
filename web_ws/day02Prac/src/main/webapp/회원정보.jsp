<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
border: 1px solid black;
margin: 0 auto;

}
td{
border: 1px solid black;
}

</style>
</head>
<body>
<table>

<tr>
<td>아이디</td>
<td>비번</td>
<td>이름</td>
<td>포인트</td>
</tr>
<%


Connection con = null;
Statement st = null;
ResultSet rs = null;


String driver = "oracle.jdbc.driver.OracleDriver";
String url = "jdbc:oracle:thin:@localhost:1521:testdb";
String user = "scott";
String password = "tiger";

try {
	
	
	Class.forName(driver);
	
	//2. 데이터베이스 연결
	
	con = DriverManager.getConnection(url, user, password);
	
	//3. sql 작성하기
	
	String sql ="select * from acorntbl2";
	
	//4. Statement 객체 얻어오기(쿼리 실행명령 가지고있음)
	
	st = con.createStatement();
	
	rs = st.executeQuery(sql);
	
	//5. ResultSet 객체 얻어오기(쿼리 실행결과, select 쿼리결과)
	
	while(rs.next()) {

%>
<tr>
<td><%=rs.getString(1) %></td>
<td><%=rs.getString(2) %></td>
<td><%=rs.getString(3) %></td>
<td><%=rs.getString(4) %></td>
</tr>
<%
	}
	rs.close();
	st.close();
	con.close();
	
	}catch(Exception e){
		System.out.println(e.getMessage());
	}
%>
</table>

</body>
</html>