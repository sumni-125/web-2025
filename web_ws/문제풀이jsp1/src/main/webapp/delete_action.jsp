<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ include file="dbcon.jsp" %>
 
 <%
   String s_id = request.getParameter("s_id"); 
   out.println( s_id);
  
   String sql =" delete  from tbl_course_300 where s_id= ?" ;
   PreparedStatement  pst =  con.prepareStatement(sql);
   pst.setString(1, s_id);
   pst.executeUpdate();
   
   pst.close();
   con.close();
   
   response.sendRedirect("index.jsp"); 
 
 %>