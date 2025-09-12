<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
    }
    .container {
        max-width: 800px;
        margin: 50px auto;
        padding: 30px;
        background: white;
        border: 2px solid #1E3A8A;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0,0,0,0.1);
    }
    h2 {
        text-align: center;
        color: #1E3A8A;
        margin-bottom: 20px;
        font-size: 28px;
    }
    .info {
        margin-bottom: 15px;
        font-size: 16px;
    }
    .info label {
        font-weight: bold;
        color: #1E3A8A;
        display: inline-block;
        width: 80px;
    }
    .content {
        border: 1px solid #ccc;
        padding: 15px;
        min-height: 200px;
        background-color: #fafafa;
        white-space: pre-wrap;
    }
    .buttons {
        margin-top: 20px;
        text-align: center;
    }
    .buttons a {
        padding: 8px 20px;
        margin: 0 5px;
        border-radius: 5px;
        color: white;
        text-decoration: none;
        transition: 0.3s;
    }
    .btn-edit { background-color: #1D4ED8; }
    .btn-edit:hover { background-color: #F59E0B; transform: scale(1.05); }
    .btn-delete { background-color: #DC2626; }
    .btn-delete:hover { background-color: #F59E0B; transform: scale(1.05); }
    .btn-list { background-color: #047857; }
    .btn-list:hover { background-color: #F59E0B; transform: scale(1.05); }
</style>
</head>
<body>
<div class="container">
    <h2>게시글 상세보기</h2>
    <div class="info"><label>제목:</label> ${board.title}</div>
    <div class="info"><label>작성자:</label> ${board.writer}</div>
    <div class="info"><label>등록일:</label> ${board.regDate}</div>
    <div class="content">${board.content}</div>

    <div class="buttons">
        <!-- 작성자 본인만 수정/삭제 버튼 표시 -->
        <c:if test="${not empty user and user.id == board.writer}">
            <a class="btn-edit" href="/board/edit/${board.seq}">수정</a>
            <a class="btn-delete" href="/board/delete/${board.seq}">삭제</a>
        </c:if>
        <a class="btn-list" href="/board/list">목록</a>
    </div>
</div>
</body>
</html>
