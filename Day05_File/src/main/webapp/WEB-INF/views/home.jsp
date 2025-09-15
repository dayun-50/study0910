<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	<fieldset>
		<legend>Upload</legend>
			<form action="/file/upload" method="post" enctype="multipart/form-data">
				<input type="text" name="text" placeholder="아무 텍스트 랍니다"><br>
				<input type="file" name="files" multiple>
				<button>전송</button>
			</form>
	</fieldset>
	
	<button id="list">파일 목록 가져오기</button>
	<fieldset>
	<legend>File List</legend>
	<div id="files"></div>
	</fieldset>
	
	<script>
		$("#list").on("click", ()=>{
			$.ajax({
				url:"/file/list"
			}).done((resp)=>{
				for(let i of resp){//이게 forEach래
					let a = $("<a>");
					a.html(i.oriname);
					a.attr("href","/file/download?sysname="+i.sysname+"&oriname="+i.oriname);
					
					let line = $("<div>");
					line.append(a);
					
					$("#files").append(line);
				}
			})
		});
		
	</script>
</body>
</html>