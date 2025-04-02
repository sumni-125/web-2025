<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
table{
border:1px solid black;
width:800px;
margin:0 auto;
border-collapse: collapse;
}

td{
border:1px solid black;
}

</style>
</head>
<body>


<header></header>
<nav></nav>
<section>
 
 
 <table>
 
 <tr>
 <td>고객아이디</td>
 <td>비번</td>
 <td>이름</td> 
 <td>포인트</td>
 </tr>
 <%
 	String driver="oracle.jdbc.driver.OracleDriver";
	String url  ="jdbc:oracle:thin:@localhost:1521:testdb";
	String user="scott";
    String password="tiger";    
	Class.forName(driver);
	Connection con = DriverManager.getConnection(url, user, password);
	if( con !=null){
		System.out.println("ok");
		out.println("ok");
	}  
	
	 String sql =" select  m_id , m_pw, m_name, m_point from member_tbl_11";
	   
	Statement st=con.createStatement();
	ResultSet  rs  =st.executeQuery(sql);
	
	while( rs.next()){
		//System.out.print(rs.getString(1) + " ");
		//System.out.println(rs.getString(2) + " ");
		//System.out.print(rs.getString(3) + " ");					
		//System.out.println( rs.getString(4));
	 
 %>
  
 
 <tr>
 <td> <%=rs.getString(1) %> </td>
 <td> <%=rs.getString(2) %></td>
 <td> <%=rs.getString(3) %></td> 
 <td> <%=rs.getString(4) %></td>
 </tr> 
 <%} %>
 
 </table>


</section>
<footer></footer>
</body>
</html>