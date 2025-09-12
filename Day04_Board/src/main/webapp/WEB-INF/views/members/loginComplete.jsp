<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <style>
    	body h1{
    		display: flex;
            justify-content: center;
    	}
    	
    	body table{
    		display: flex;
            justify-content: center;
    	}
    </style>
</head>
<body>
	<h1>${userName } 님 로그인 성공</h1>
	<table>
		<tr>
			<td><button id="borad">게시판</button></td>
			<td><button id="mypage">마이페이지</button></td>
			<td><button id="logout">로그아웃</button></td>
			<td><button id="secession">회원탈퇴</button></td>
		</tr>
	</table>
	
	<script>
	$("#logout").on("click", ()=>{ //로그아웃
		window.location.href = "/members/logout";
	});
	
	$("#secession").on("click", ()=>{ //탈퇴
		let result = confirm("정말로 회원 탈퇴하시겠습니까?");
  	   
  	   if(result){
  		   window.location.href = "/members/delete";
  		   alert("탈퇴 완료되셨습니다."); 
  	   }
	});
	
	$("#mypage").on("click", ()=>{ //마이페이지
		window.location.href = "/members/mypage";
	});
	
	$("#borad").on("click", ()=>{ //게시판이동
		window.location.href = "/borad/boradList";
	});
	
	</script>
	
</body>
</html>