<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

 <%
 
  //연결정보  
     String driver="oracle.jdbc.driver.OracleDriver";
	 String url  ="jdbc:oracle:thin:@localhost:1521:testdb";
	 String user="scott";
	 String password="tiger"; 
	 
	 Class.forName(driver);
	 Connection  con  =DriverManager.getConnection(url, user, password);
	 if( con != null) out.println("ok");
	  
 %>