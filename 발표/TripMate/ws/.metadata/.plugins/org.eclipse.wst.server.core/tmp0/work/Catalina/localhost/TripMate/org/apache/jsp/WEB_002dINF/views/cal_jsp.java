/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.102
 * Generated at: 2025-04-23 00:55:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cal_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\"\r\n");
      out.write("	content=\"width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no\">\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\r\n");
      out.write("<link href=\"https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/locales-all.min.js\"></script>\r\n");
      out.write("<link href=\"css/cal.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"css/header.css\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<header>\r\n");
      out.write("	<div class=\"logo\">\r\n");
      out.write("		<a href=\"");
      out.print(request.getContextPath());
      out.write("/main\"><img class=\"logoImg\" src=\"image/logo.png\"\r\n");
      out.write("			alt=\"\"></a>\r\n");
      out.write("	</div>\r\n");
      out.write("	<div>\r\n");
      out.write("		<a href=\"");
      out.print(request.getContextPath());
      out.write("/myTrip\">여행일정</a>\r\n");
      out.write("	</div>\r\n");
      out.write("	<div>\r\n");
      out.write("		<a href=\"");
      out.print(request.getContextPath());
      out.write("/mainsearch\">관광지</a>\r\n");
      out.write("\r\n");
      out.write("	</div>\r\n");
      out.write("	<div>\r\n");
      out.write("		<a href=\"");
      out.print(request.getContextPath());
      out.write("/mainblog\">블로그</a>\r\n");
      out.write("\r\n");
      out.write("	</div>\r\n");
      out.write("	<div>\r\n");
      out.write("		<a href=\"");
      out.print(request.getContextPath());
      out.write("/myPage\">마이페이지</a>\r\n");
      out.write("\r\n");
      out.write("	</div>\r\n");
      out.write("</header>\r\n");
      out.write("	<div class=\"container\">\r\n");
      out.write("		<div id=\"calendar-container\">\r\n");
      out.write("			<div id=\"calendar\"></div>\r\n");
      out.write("		</div>\r\n");
      out.write("\r\n");
      out.write("		<div id=\"info-panel\">\r\n");
      out.write("			<h2>선택한 기간</h2>\r\n");
      out.write("			<div id=\"selected-dates\">선택한 날짜 없음</div>\r\n");
      out.write("\r\n");
      out.write("			<form id=\"date-form\" method=\"post\" action=\"");
      out.print(request.getContextPath());
      out.write("/tripCal\">\r\n");
      out.write("				<input type=\"hidden\" name=\"startDate\" id=\"startDate\">\r\n");
      out.write("				<input type=\"hidden\" name=\"endDate\" id=\"endDate\">\r\n");
      out.write("				<button type=\"submit\" id=\"next-button\">다음</button>\r\n");
      out.write("			</form>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("	<script>\r\n");
      out.write("		(function() {\r\n");
      out.write("			$(function() {\r\n");
      out.write("				var calendarEl = $('#calendar')[0];\r\n");
      out.write("				var firstClick = null;\r\n");
      out.write("				var highlightEvent = null;\r\n");
      out.write("				let selectedStart = null;\r\n");
      out.write("				let selectedEnd = null;\r\n");
      out.write("\r\n");
      out.write("				var calendar = new FullCalendar.Calendar(calendarEl, {\r\n");
      out.write("					height: '100%',\r\n");
      out.write("					expandRows: true,\r\n");
      out.write("					headerToolbar: {\r\n");
      out.write("						left: 'prev,next today',\r\n");
      out.write("						center: 'title',\r\n");
      out.write("						right: ''\r\n");
      out.write("					},\r\n");
      out.write("					initialView: 'dayGridMonth',\r\n");
      out.write("					initialDate: new Date(),\r\n");
      out.write("					navLinks: false,\r\n");
      out.write("					editable: false,\r\n");
      out.write("					selectable: false,\r\n");
      out.write("					nowIndicator: true,\r\n");
      out.write("					dayMaxEvents: true,\r\n");
      out.write("					locale: 'ko',\r\n");
      out.write("\r\n");
      out.write("					events: [\r\n");
      out.write("						{\r\n");
      out.write("							title: '제주도 여행',\r\n");
      out.write("							start: '2025-04-05',\r\n");
      out.write("							end: '2025-04-07',\r\n");
      out.write("							color: '#607D8B'\r\n");
      out.write("						},\r\n");
      out.write("						{\r\n");
      out.write("							title: '우도 여행',\r\n");
      out.write("							start: '2025-04-06',\r\n");
      out.write("							end: '2025-04-11',\r\n");
      out.write("							color: '#607D8B'\r\n");
      out.write("						}\r\n");
      out.write("					],\r\n");
      out.write("\r\n");
      out.write("					dateClick: function(info) {\r\n");
      out.write("						if (highlightEvent) {\r\n");
      out.write("							highlightEvent.remove();\r\n");
      out.write("							highlightEvent = null;\r\n");
      out.write("						}\r\n");
      out.write("\r\n");
      out.write("						if (!firstClick) {\r\n");
      out.write("							firstClick = info.dateStr;\r\n");
      out.write("							$('#selected-dates').html(\"시작 날짜: \" + firstClick + \"<br>종료 날짜를 선택하세요.\");\r\n");
      out.write("							selectedStart = firstClick;\r\n");
      out.write("							selectedEnd = null;\r\n");
      out.write("						} else {\r\n");
      out.write("							let start = new Date(firstClick);\r\n");
      out.write("							let end = new Date(info.dateStr);\r\n");
      out.write("\r\n");
      out.write("							if (start > end) {\r\n");
      out.write("								[ start, end ] = [ end, start ];\r\n");
      out.write("							}\r\n");
      out.write("\r\n");
      out.write("							const startStr = start.toISOString().split('T')[0];\r\n");
      out.write("							const endStr = end.toISOString().split('T')[0];\r\n");
      out.write("							const diffTime = Math.abs(end - start);\r\n");
      out.write("							const diffDays = Math.floor(diffTime / (1000 * 60 * 60 * 24)) + 1;\r\n");
      out.write("\r\n");
      out.write("							let endDate = new Date(end);\r\n");
      out.write("							endDate.setDate(endDate.getDate() + 1);\r\n");
      out.write("							const endStrPlus = endDate.toISOString().split('T')[0];\r\n");
      out.write("\r\n");
      out.write("							$('#selected-dates').html(\r\n");
      out.write("								\"선택한 기간:<br>\" + startStr + \" ~ \" + endStr +\r\n");
      out.write("								\"<br><br>총 <strong>\" + diffDays + \"</strong>일\"\r\n");
      out.write("							);\r\n");
      out.write("\r\n");
      out.write("							highlightEvent = calendar.addEvent({\r\n");
      out.write("								start: startStr,\r\n");
      out.write("								end: endStrPlus,\r\n");
      out.write("								display: 'background',\r\n");
      out.write("								backgroundColor: '#FFEB3B'\r\n");
      out.write("							});\r\n");
      out.write("\r\n");
      out.write("							selectedStart = startStr;\r\n");
      out.write("							selectedEnd = endStr;\r\n");
      out.write("							firstClick = null;\r\n");
      out.write("						}\r\n");
      out.write("					}\r\n");
      out.write("				});\r\n");
      out.write("\r\n");
      out.write("				calendar.render();\r\n");
      out.write("\r\n");
      out.write("				$('#next-button').on('click', function(e) {\r\n");
      out.write("					if (selectedStart && selectedEnd) {\r\n");
      out.write("						$('#startDate').val(selectedStart);\r\n");
      out.write("						$('#endDate').val(selectedEnd);\r\n");
      out.write("					} else {\r\n");
      out.write("						e.preventDefault(); // 제출 막기\r\n");
      out.write("						alert('날짜를 먼저 선택해 주세요.');\r\n");
      out.write("					}\r\n");
      out.write("				});\r\n");
      out.write("			});\r\n");
      out.write("		})();\r\n");
      out.write("	</script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
