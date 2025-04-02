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
     width:800px;
     border:1px solid black;
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
 <td>a</td>
 <td>b</td>
 <td>c</td>
 <td>d</td>
 </tr>
 
 <%
	String driver="oracle.jdbc.driver.OracleDriver";
	String url  ="jdbc:oracle:thin:@localhost:1521:testdb";
	String user="scott";
 	String password="tiger";    
 	   
 	   Class.forName(driver);
 	   Connection con  =DriverManager.getConnection(url, user, password);
 	   
 	   if( con != null){
 		   System.out.println("ok");
 	   }
 	    	   
 	   String sql =" select * from member_tbl_11 " ;
 	   
 	   
 	   Statement  st = con.createStatement();
 	   ResultSet rs =  st.executeQuery(sql);
 	   
 	   while( rs.next()){
 		  // System.out.println(  rs.getString(1));    	   
 %>
 
 <tr>
 <td> <%=rs.getString(1) %></td>
 <td></td>
 <td></td>
 <td></td>
 </tr>
 
 <%} %>
 
 </table>

</section>
<footer></footer>


</body>
</html>