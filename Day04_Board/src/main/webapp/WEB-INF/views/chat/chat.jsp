<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>
<!-- 제이쿼리 -->
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
   integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
   crossorigin="anonymous"></script>
<style>
* {
   box-sizing: border-box;
}

.container {
   width: 400px;
   height: 500px;
   margin: 0 auto;
   overflow: hidden;
   border: 1px solid black;
   position: relative;
}

#text2 {
   width: 100%;
   height: 80%;
   padding: 10px;
   overflow-y: auto;
   border: 1px solid black;
   display: flex;
   flex-direction: column;
   align-items: flex-start;
}

#comment {
   width: 100%;
   height: 20%;
   float: left;
   border: 1px solid black;
}

#comment #text1 {
   width: 70%;
   height: 100%;
   float: left;
   overflow-y: auto;
   padding: 10px;
}

#comment .b {
   width: 30%;
   height: 100%;
   float: left;
   border-radius: 50px;
}

#comment button {
   width: 100%;
   height: 100%;
}

.emoji-panel {
   position: absolute;
   bottom: -120px;
   left: 0;
   width: 100%;
   height: 120px;
   background-color: #f9f9f9;
   border-top: 1px solid #ccc;
   display: grid;
   grid-template-columns: repeat(4, 1fr);
   /* 한 줄에 4개 */
   gap: 5px;
   justify-items: center;
   align-items: center;
   transition: bottom 0.3s ease;
   z-index: 10;
}

.emoji-panel.open {
   bottom: 0;
}

.emoji-panel img.emoji {
   width: 80px;
   height: 80px;
   cursor: pointer;
   object-fit: contain;
}

.co {
   display: inline-block;
   max-width: 80%;
   padding: 10px 15px;
   background-color: #f0f0f0;
   border-radius: 15px;
   font-size: 14px;
   line-height: 1.5;
   word-wrap: break-word;
   white-space: pre-wrap;
   margin: 5px 0;
}
</style>
</head>

<body>
   <div class="container">
      <div class="registration" id="text2"></div>

      <div id="comment">
         <div contenteditable="true" class="input" id="text1"></div>
         <div class="b">
            <button type="button" class="btn1">icon</button>
         </div>
      </div>
    
   </div>
   <script>
   		let ws = new WebSocket("ws://10.5.5.9/chat"); //엔드포인트 패키지에 클레스 안에있는 URL이랑 맞춰야함
   
   		function dislayChat(chat){
   			let line = $("<div>").addClass("co")
				line.html(chat);
				$(".registration").append(line);
   		}
   		
   		ws.onmessage = (e)=>{
   			let data = JSON.parse(e.data);
   			
   			if(data.type == "chat"){
   				dislayChat(data.data);
   			}else if(data.type=="history"){
   				for(let i of data.data){
   					dislayChat(i.userName + " : " + i.message +"<br>"+i.mDate);
   				}
   			}
   		}
   
      $("#text1").on(
            "keydown",
            function(e) {
               if (e.key === "Enter" && !e.shiftKey) {
                  e.preventDefault(); // 줄바꿈 방지
                  let textMy = $(".input").html().trim();
                  if (!textMy)
                     return;
                  
                  ws.send(textMy); //서버에 전송

                  $(this).html(""); // 입력창 초기화
                  $(".registration").scrollTop(
                        $(".registration")[0].scrollHeight);
               }
            });

    
   </script>
</body>
</body>
</html>