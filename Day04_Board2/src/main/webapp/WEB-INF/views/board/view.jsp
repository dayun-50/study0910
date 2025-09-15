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
    
    .container div input{
    	width: 85%;
    	height: 50px;
    }
    
    #commentBox{
    	border: 1px solid black;
    	width: 85%;
    	height: 50px;
    	float: left; 
    }
    
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
    
    <form action="/comment/commentInsert" method="get">
    <div class = "container">
    	<div>
    		<input type="text" placeholder="댓글작성" name="content">
    		<input type="hidden" value="${board.seq}" name="prent_seq">
    		<input type="hidden" value="${user.id }" name="writer">
    		<button>작성완료</button>
    	</div>
    </div>
    </form>
    
    <div  class = "container">
    
    <c:forEach var="b" items="${list}">
   
    	<div class="commentBox"> ${b.writer }|| ${b.coment_date } <br>${b.content } </div>
    	<c:if test="${not empty user and user.id == b.writer}">
    	
    	<div class="box1">
    	<button class="up">수정</button>
    	<form action="/comment/dle" method="get">
    		<button class="delComment">삭제</button>
    		<input type="hidden" name="prent_seq" value="${board.seq}">
    		<input type="hidden" name="seq" value="${b.seq}">
    	</form>
    	</div>
    	
    	<div class="box2">
    	 <form action="/comment/up" method="get">
    	 	<input type="hidden" name="prent_seq" value="${board.seq}">
    		<input type="hidden" name="seq" value="${b.seq}">
    		<input type="hidden" name="content" class="contentBox">
    		<input type="hidden" name = "writer" value="${user.id }">
    		<button class="update">수정완료</button>
    		<button type="button" class="back">수정취소</button>
    		</form>
    	</div>
    
    	</c:if>
    </c:forEach>
    </div>
</div>
<script>

$(document).ready(function() {
    $(".box2").hide();

    // 수정 버튼 클릭
    $(document).on("click", ".up", function() {
        let box1 = $(this).closest(".box1");
        let box2 = box1.next(".box2"); // box2는 box1 바로 다음
        let commentBox = box1.prev(".commentBox"); // commentBox는 box1 바로 위

        box2.show();
        box1.hide();
        commentBox.attr("contenteditable", "true");
    });

    // 수정완료 버튼 클릭
    $(document).on("click", ".update", function() {
        let box2 = $(this).closest(".box2");
        let box1 = box2.prev(".box1");
        let commentBox = box1.prev(".commentBox");
        let form = $(this).closest("form");

        box2.find(".contentBox").val(commentBox.text());
        form.submit();
    });

    // 수정취소 버튼 클릭
    $(document).on("click", ".back", function() {
        let box2 = $(this).closest(".box2");
        let box1 = box2.prev(".box1");
        let commentBox = box1.prev(".commentBox");

        commentBox.attr("contenteditable", "false");
        box2.hide();
        box1.show();
    });
});


</script>

</body>
</html>
