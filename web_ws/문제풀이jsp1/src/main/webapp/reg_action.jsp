<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="dbcon.jsp" %>
 
 <%
    //사용자 정보 꺼내오기 
    request.setCharacterEncoding("UTF-8");
 
 	String  s_id = request.getParameter("s_id");
 	String  s_name = request.getParameter("s_name"); 	
	String  teacher_id = request.getParameter("teacher_id");
	String  s_grade = request.getParameter("s_grade");	
	String  weekday = request.getParameter("weekday");	
	int  start_h =  Integer.parseInt(request.getParameter("start_h"));
	int  end_h = Integer.parseInt(request.getParameter("end_h"));
	
	
	out.println( s_id);
	out.println( s_name);
	out.println( teacher_id);
	out.println( s_grade);
	out.println( weekday);
	out.println( start_h);
	out.println( end_h);	
	
	// 
	String sql=" insert into tbl_course_300 values(?,?,?,?,?,?,?)";
	PreparedStatement pst  =con.prepareStatement(sql);
	pst.setString(1, s_id);
	pst.setString(2, s_name);
	pst.setString(3, s_grade);
	pst.setString(4, teacher_id);
	pst.setString(5, weekday);
	pst.setInt(6, start_h);
	pst.setInt(7, end_h);	
	
	pst.executeUpdate();
	pst.close();
	con.close();
	
	response.sendRedirect("index.jsp"); 
 	
 
  
 %>