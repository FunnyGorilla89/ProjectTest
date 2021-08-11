<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="com.jh.*" %>
<%
	String id = (String)(session.getAttribute("id"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main page</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<style>
	#nav-bar{
		display: flex;
	    justify-content: space-between;
	    align-items: center;
	}
	
	#center {
		display: flex;
    	justify-content: space-between;
	}

	.span-area {
		text-align: center;
	}
	
	#bottom-area {
		margin-top: 185px;
		display: flex;
    	justify-content: flex-end;
	}
	
</style>
<body>
	<input type="hidden" name="id" value="<%=id%>">
	<div id="nav-bar">
		<div id="header-left"><h1>메인페이지</h1></div>
		<div id="header-right">${userName}(<%=id %>)님&nbsp;안녕하세요.<input type="button" name="Logout" id="btn-logout" value="로그아웃" onClick="location.href='logoutAction'"/><p>포인트 : ${userPoint} 점</p></div>
	</div>
	<div id="container">
		<h3>구입할 컨텐츠를 선택하세요</h3>
		<div id="center">
			<div>
				<a href="#"><img src="resources/img/Intro_350_408.png"/></a><br/>
				<div class="span-area"><span>100,000포인트</span></div>
			</div>
			<div>
				<a href="#"><img src="resources/img/Java_350_408.png"/></a><br/>
				<div class="span-area"><span>500,000포인트</span></div>
			</div>
			<div>
				<a href="#"><img src="resources/img/Cpp_350_408.png"/></a><br/>
				<div class="span-area"><span>300,000포인트</span></div>
			</div>
		</div>
	</div>
	<div id="bottom-area">
		<a href="pointGet"><img src="resources/img/korea_it.png"/></a>
	</div>
</body>
<%
	if(request.getAttribute("msg")!=null){
%>
	<script>alert('${msg}');</script>
<%		
	}
%>
</html>