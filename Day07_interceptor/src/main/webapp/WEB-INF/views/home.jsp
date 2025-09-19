<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HomePage</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	
	<c:choose>
		<c:when test="${loginID != null }">
			${loginID } 님 로그인 되었습니다.
		</c:when>
		<c:otherwise>
			로그인 되지 않았습니다.
		</c:otherwise>
	</c:choose>

	<hr>

	<a href="/member/login"><button>로그인</button></a>
	<a href="/member/logout"><button>로그아웃</button></a>
	
	<hr>
	
	<a href="/memberonly">회원전용 페이지</a><br>
	<a href="/alluser">모든 사용자 페이지</a>
</body>
</html>