<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- request, response, out -->
<%
String total = "";
for (int i = 1; i < 10; i++) {
    total += "3 × " + i + " = " + (3 * i) + "<br>";
}

out.println(total);
%>
<h1>3단</h1>
<p><%=total %></p>
<%out.println(total); %>

</body>
</html>