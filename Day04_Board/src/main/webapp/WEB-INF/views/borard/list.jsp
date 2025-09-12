<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
    }
    .container {
        max-width: 900px;
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
    .btn-write {
        display: inline-block;
        margin-bottom: 15px;
        padding: 8px 20px;
        background-color: #047857;
        color: white;
        border: none;
        border-radius: 8px;
        cursor: pointer;
        transition: 0.3s;
        text-decoration: none;
    }
    .btn-write:hover {
        background-color: #F59E0B;
        transform: scale(1.05);
        box-shadow: 0 0 8px rgba(255,165,0,0.6);
    }
    table {
        width: 100%;
        border-collapse: collapse;
    }
    th, td {
        padding: 10px;
        border: 1px solid #ccc;
        text-align: center;
    }
    th {
        background-color: #1E3A8A;
        color: white;
    }
    td a {
        color: #1E3A8A;
        text-decoration: none;
    }
    td a:hover {
        color: #F59E0B;
        text-decoration: underline;
    }
    .btn-delete, .btn-edit {
        padding: 5px 10px;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: 0.3s;
        text-decoration: none;
        margin: 0 2px;
    }
    .btn-delete { background-color: #DC2626; }
    .btn-delete:hover { background-color: #F59E0B; transform: scale(1.05); }
    .btn-edit { background-color: #1D4ED8; }
    .btn-edit:hover { background-color: #F59E0B; transform: scale(1.05); }
</style>
</head>
<body>
<div class="container">
    <h2>게시판 목록</h2>

 
        <a class="btn-write" href="/borad/write">글쓰기</a>


    <table>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>등록일</th>
            <th>관리</th>
        </tr>
        <c:forEach var="b" items="${list}">
            <tr>
                <td>${b.seq}</td>
                <td><a href="/borad/view/${b.seq}">${b.title}</a></td>
                <td>${b.writer}</td>
                <td>${b.regdate}</td>
                <td>
                    <!-- 작성자 본인만 수정/삭제 버튼 표시 -->
                    <c:if test="${not empty user and user.id == b.writer}">
                        <a class="btn-edit" href="/board/edit/${b.seq}">수정</a>
                        <a class="btn-delete" href="/board/delete/${b.seq}">삭제</a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
