<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="index.css" rel="stylesheet">
<title>Insert title here</title>
<script src="reg.js"></script>
</head>
<body>

<header>
<h1>정보처리산업기사</h1>
</header>

<nav>
<a href="">등록</a>
<a href="">조회</a>
<a href="">홈으로</a> 
</nav>

<section>

 <form name="frm" action="reg_action.jsp" method="POST">
 <table> 
 <tr>
 <td>교과목코드</td>
 <td><input type="text"  name="s_id"></td>
 </tr>
 <tr>
 <td>교과명</td>
 <td><input type="text"  name="s_name"></td>
 </tr>
 <tr>
 <td>담당강사</td>
 <td>
 <select name="teacher_id">
 <option value="">선택하세요</option>
 <option value="1">정국교수</option>
 <option value="2">뷔교수</option>
 <option value="3">지민교수</option>
 <option value="4">제이홉교수</option>
 <option value="5">슈가교수</option>
 <option value="6">진교수</option>
 <option value="7">RM교수</option>
 </select>
 </td>
 </tr>
 <tr>
 <td>학점</td>
 <td><input type="text"  name="s_grade"></td>
 </tr>
 <tr>
 <td>요일</td>
 <td>
 <input type="radio"  name="weekday" value="M">월 
 <input type="radio"  name="weekday" value="TU">화
 <input type="radio"  name="weekday" value="W">수
 <input type="radio"  name="weekday" value="TH">목
 <input type="radio"  name="weekday" value="F">금
 <input type="radio"  name="weekday" value="S">토
 
 </td>
 </tr>
 <tr>
 <td>수업시작시간</td>
 <td><input type="text"  name="start_h"></td>
 </tr>
 <tr>
 <td>수업종료시간</td>
 <td><input type="text"  name="end_h"></td>
 </tr>
 <tr> 
 <td colspan="2">
  <input type="button" value="목록" >
  <input type="button" value="저장"   onclick="check()">
 </td>
 </tr>
 </table>
 </form> 

</section>

<footer>
<h2>HRD Korea</h2>
</footer>
</body>
</html>