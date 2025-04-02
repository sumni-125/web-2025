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
 <td>제품명</td>
 <td>금액</td>
 
 </tr>
 <%
 	String driver="oracle.jdbc.driver.OracleDriver";
	String url  ="jdbc:oracle:thin:@localhost:1521:testdb";
	String user="scott";
    String password="1234";    
	Class.forName(driver);
	Connection con = DriverManager.getConnection(url, user, password);
	if( con !=null){
		System.out.println("ok");
		out.println("ok");
	}  
	
	String sql =" select g.PNAME 제품명,  to_char( sum(g.PRICE * o.SALE_CNT) , '999,999') || '원' 판매총합  " ;
	   sql += " from TBL_TEST_GOODS g ";
	   sql += " join TBL_TEST_ORDER o ";  
	   sql += "	on o.PCODE = g.PCODE ";
	   sql += "	group by g.pname ";
	   sql += "	order by 판매총합  DESC"; 	
	   
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
 
 </tr> 
 <%} %>
 
 </table>


</section>
<footer></footer>
</body>
</html>