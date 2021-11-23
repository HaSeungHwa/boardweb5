<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String err = (String) request.getAttribute("err");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <style>
        .err { color: red; margin-bottom: 5px }
        #login { line-height: 50px; }
        #login form { min-width: 363px; line-height: 16px; display: inline-block; }
        #login form div { width: 250px; display: inline-block; vertical-align: middle; }
        #login form div input { width: 100%; height: 31px; display: inline-block; }
        #login form div input:first-child { margin-bottom: 3px; }
        #login form > input { width: 100px; height: 77px; font-size: 20px;
            radius: 4px; margin-left: 7px; vertical-align: middle; }
    </style>
</head>
<body>
    <h1>로그인</h1>
    <% if(err != null) { %>
        <div class="err"><%=err%></div>
    <% } %>
    <div id="login">
        <form action="/user/login" method="post">
            <div>
                <input type="text" name="inputId" placeholder="아이디" value="kim">
                <input type="password" name="inputPw" placeholder="비밀번호" value="kimp">
            </div>
            <input type="submit" id="loginBtn" value="login">
        </form>
        <div>
            <a href="/user/join">회원가입</a>
        </div>
    </div>
</body>
</html>