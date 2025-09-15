<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<style>
.container {
    max-width: 600px;
    margin: 50px auto;
    padding: 30px;
    background: white;
    border-radius: 10px;
    border: 2px solid #1E3A8A;
}
h2 {
    text-align: center;
    color: #1E3A8A;
    margin-bottom: 20px;
}
input, textarea {
    width: 100%;
    margin: 10px 0;
    padding: 8px;
    border-radius: 5px;
    border: 1px solid gray;
}
button {
    padding: 10px 20px;
    background: #047857;
    color: white;
    border: none;
    border-radius: 8px;
    cursor: pointer;
}
button:hover {
    background: #F59E0B;
}
.notice {
    text-align: center;
    color: red;
    font-weight: bold;
    margin-top: 50px;
}
</style>
</head>
<body>
<div class="container">
    <c:choose>
        <c:when test="${not empty user and user.id == board.writer}">
            <h2>게시글 수정</h2>
            <form action="/board/edit/${board.seq}" method="post">
                <label>제목</label>
                <input type="text" name="title" value="${board.title}" required>
                <label>내용</label>
                <textarea name="content" rows="10" required>${board.content}</textarea>
                <button type="submit">수정 완료</button>
            </form>
        </c:when>
        <c:otherwise>
            <div class="notice">
                ⚠ 수정 권한이 없습니다.<br>
                <a href="/board/list">게시판 목록으로 돌아가기</a>
            </div>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
