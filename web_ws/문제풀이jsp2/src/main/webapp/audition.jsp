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
<td>a</td>
<td>b</td>
<td>c</td>
<td>d</td>
<td>e</td>
<td>f</td>
<td>g</td>
</tr>
<%

	String driver="oracle.jdbc.driver.OracleDriver";
	String url  ="jdbc:oracle:thin:@localhost:1521:testdb";
	String user="scott";
	String password="tiger"; 

	Class.forName(driver);
	Connection con  =DriverManager.getConnection(url, user, password);
	String sql=" select score_no, artistid, join_nm, birth, score,decode(trunc(score/10) , 10,'A',9,'A',8,'B', 7, 'C', 'F') as grade, mentor_nm ";
		   sql += "	from tbl_score_200 s " ;
		   sql += " join tbl_join_200 j ";
		   sql += " on s.artistid = j.join_id ";
		   sql += " join tbl_mentor_200 m ";
		   sql += " on s.mentorid = m.mentor_Id ";
	
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
	<td><%=rs.getString(6) %></td>
	<td><%=rs.getString(7) %></td>
	</tr>
	
<%} %>
</table>

</section>
<footer></footer>

</body>
</html>