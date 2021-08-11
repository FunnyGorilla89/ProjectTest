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
	<title>회원가입</title>
</head>
<style>
#btn-submit{width: 100%;}
</style>
<body>
	<h1>회원가입</h1>
	<form action="registerAction" method="post">
	<table>
	<tr>
		<td>ID:</td><td><input type="text" name="id"/></td>
	</tr>
	<tr>
		<td>PW:</td><td><input type="password" name="pw"/></td>
	</tr>
	<tr>
		<td>NAME:</td><td><input type="text" name="name"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" id="btn-submit" value="작성완료"/>	
		</td>
	</tr>
	</table>
	</form>
</body>
</html>
