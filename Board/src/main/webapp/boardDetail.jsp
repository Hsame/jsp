<%@page import="com.tst.board.BoardVO"%>
<%@page import="com.tst.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
String bno = request.getParameter("id");
BoardDAO dao = new BoardDAO();
BoardVO vo = dao.getBoard(Integer.parseInt(bno));
%>
<!-- 글번호, 제목, 내용, 작성자, 작성일자, 조회수 -->
<table>
<tr><th>--------------------------------</th></tr>
<tr><th>| 글번호 | : <%=vo.getBoardId() %></th></tr>
<tr><th>--------------------------------</th></tr>
<tr><th>|  제목 | : <%=vo.getTitle() %></th></tr>
<tr><th>--------------------------------</th></tr>
<tr><th>|  내용 | : <%=vo.getContent() %></th></tr>
<tr><th>--------------------------------</th></tr>
<tr><th>| 작성자 | : <%=vo.getWriter() %></th></tr>
<tr><th>--------------------------------</th></tr>
<tr><th>|작성일자| : <%=vo.getCreateDate() %></th></tr>
<tr><th>--------------------------------</th></tr>
<tr><th>| 조회수 | : <%=vo.getCnt() %></th></tr>
<tr><th>--------------------------------</th></tr>
</table>
<%
String loginId = (String) session.getAttribute("loginId");
if(loginId != null && loginId.equals(vo.getWriter())) {
%>
<a href="updateForm.jsp?bno=<%= vo.getBoardId()%>"><input type="button" value="수정"></a>
<a href="deleteForm.jsp?bno=<%= vo.getBoardId()%>"><input type="button" value="삭제"></a>
<%
}
%>
<a href="boardList.jsp">글목록으로</a>
</body>
</html>