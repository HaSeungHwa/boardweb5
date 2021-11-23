<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String err = (String) request.getAttribute("err");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Join</title>
    <style>
        .err { color: red; }
        #join div { line-height: 25px; }
        #join form { min-width: 100px; line-height: 16px; }
        #joinBtn input { width: 180px; }
    </style>
</head>
<body>
    <h1>회원가입</h1>
    <% if(err != null) { %>
        <div class="err"><%=err%></div>
    <% } %>
    <div id="join">
        <form action="/user/join" method="post">
            <div><input type="text" name="joinId" placeholder="사용할 아이디"></div>
            <div><input type="password" id="joinPw" name="joinPw" placeholder="사용할 비밀번호"></div>
            <div>
                <input type="text" id="pwCheck" name="pwCheck" placeholder="비밀번호 확인">
                <span id="checkMsg"> 스크립트써서 만들기</span>
            </div>
            <div><input type="text" name="joinNm" placeholder="닉네임"></div>
            <div>
                <label>woman <input type="radio" name="gender" value="0" checked></label>
                <label>man <input type="radio" name="gender" value="1"></label>
            </div>
            <div id="joinBtn">
                <input type="submit" value="가입하기">
            </div>
        </form>
    </div>
</body>
</html>