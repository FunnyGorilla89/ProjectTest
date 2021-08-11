<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8"%>
<%
	if(request.getAttribute("msg")!=null){
%>
	<script>alert('${msg}');</script>
<%		
	}
%>
<html>
<head>
	<title>로그인</title>
</head>
<style>
#container {width: 220px;}
.btn-group, input-group {width: 100%;}
#bottom-btn{margin-top: -10px;}
</style>
<body>
	<h1>로그인</h1>
	<div id="container">
	<form action="loginAction" method="post">
		ID : <input type="text" name="id" class="input-group" style="width:189px;"/><br/>
		PW : <input type="password" name="pw" class="input-group" style="width:180px;"/><br/>
		<input type="submit" class="btn-group" value="로그인" style="margin-top:7px;"/>
	</form>
		<a href="register"><button class="btn-group" id="bottom-btn">회원가입</button></a>
	</div>
</body>
</html>
