<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>火拼-登录</title>
</head>
<body>
	<form action="loginAction" method="post">
		用户名: <input type="text" name="loginDto.username" placeholder="请输入用户名" >
		<br> 密                 码:<input type="text" name="loginDto.password" placeholder="请输入密码"><br>
		<input type="submit" value="登录">
	</form>
</body>
</html>