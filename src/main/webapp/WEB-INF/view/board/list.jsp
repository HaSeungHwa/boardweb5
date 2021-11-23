<%@ page import="java.util.List" %>
<%@ page import="com.koreait.board5.model.UserVO" %>
<%@ page import="com.koreait.board5.model.BoardVO" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<BoardVO> list = (List<BoardVO>) request.getAttribute("listAll");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List</title>
</head>
<body>
    <h1>게시판</h1>
    <table>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일시</th>
        </tr>
        <% for(BoardVO listOne : list) { %>
            <tr>
                <td><%=listOne.getIbaord()%></td>
                <td><%=listOne.getTitle()%></td>
                <td><%=listOne.getWriterNm()%></td>
                <td><%=listOne.getRdt()%></td>
            </tr>
        <% } %>
    </table>
    <a href="/board/write"><input type="button" value="글작성"></a>
</body>
</html>