<%@page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Write</title>
    <style>
        #write form { line-height: 30px; }
        #title { width: 200px; }
        #ctntArea { width: 202px; resize: vertical; }
        #button input { width: 100px; }
    </style>
</head>
<body>
    <h1>글작성</h1>
    <div id="write">
        <form action="/board/write" method="post">
            <div><input type="text" id="title" name="writeTitle" placeholder="제목입력"></div>
            <div><textarea name="writeCtnt" id="ctntArea" placeholder="내용입력"></textarea></div>
            <div id="button">
                <input type="submit" value="등록">
                <input type="reset" value="초기화">
            </div>
        </form>
    </div>

</body>
</html>