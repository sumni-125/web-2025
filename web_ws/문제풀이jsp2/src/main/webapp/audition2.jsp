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
width:600px;
border:1px solid black;
margin:0 auto;
}
td{
border:1px solid black;
}

td:nth-child(1){
text-align: center;
}

td:nth-child(4){
text-align: right;
}


td{
padding:5px;
}
</style>
</head>
<body>
<header></header>
<nav></nav>
<section>

<table>
<tr>
<td>참가자id</td>
<td>참가자이름</td>
<td>종합점수</td>
<td>평균점수</td>
<td>순위</td>
</tr>
<%

	String driver="oracle.jdbc.driver.OracleDriver";
	String url  ="jdbc:oracle:thin:@localhost:1521:testdb";
	String user="scott";
	String password="tiger"; 

	Class.forName(driver);
	Connection con  =DriverManager.getConnection(url, user, password);
	String sql=  " select s.artistid, j.join_nm, sum(s.score), round(avg(s.score),2), rank() over(order by sum(s.score) desc) ";
		   sql+= "	from tbl_score_200 s ";
		   sql+= " join tbl_join_200 j ";
		   sql+= " on s.ARTISTID = j.JOIN_ID ";
		   sql += " group by s.artistid, j.join_nm ";
		   sql += " order by 2 ";
	
   Statement st=  con.createStatement();
   ResultSet rs=  st.executeQuery(sql);
   while( rs.next()){
	    //  rs.getString(1);
  // }
 
   

%>
	<tr>
	<td><%=rs.getString(1) %></td>
	<td><%=rs.getString(2) %></td>
	<td><%=rs.getString(3) %></td>
	<td><%=rs.getString(4) %></td>
	<td><%=rs.getString(5) %></td>
	</tr>
	
<%} %>
</table>

</section>
<footer></footer>

</body>
</html>