<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>

	<form action="registerAction" method="post">
		<h3>登录信息</h3>
		<s:textarea name="registerDto.username">用户名：</s:textarea>
		<s:password name="registerDto.password_first">请输入密码：</s:password>
		<s:password name="registerDto.password_second">请再次输入密码：</s:password>
		<s:textarea name="registerDto.realName">真实姓名：</s:textarea>
		<h3>个人信息</h3>
		<s:textarea name="registerDto.sex">性别</s:textarea>
		<s:textarea name="registerDto.birthday">生日</s:textarea>
		<s:textarea name="registerDto.idCard">身份证号</s:textarea>
		<s:textarea name="registerDto.profession">职业</s:textarea>
		<s:textarea name="registerDto.phoneNum">电话号</s:textarea>
		<s:textarea name="registerDto.email">邮箱</s:textarea>
		<h3>汽车信息</h3>
		<s:textarea name="carDto.brand">品牌</s:textarea>
		<s:textarea name="carDto.model">汽车型号</s:textarea>
		<s:textarea name="carDto.licenseNum">车牌号</s:textarea>
		<s:textarea name="carDto.motorcycleType">车型</s:textarea>
		<s:textarea name="carDto.drivingLicenseNum">驾驶证号</s:textarea>
		<s:textarea name="carDto.registrationNum">行驶证号</s:textarea>
		<s:textarea name="carDto.expectPeopleNum">期望载客数</s:textarea>
		
		<s:submit name="submit">提交</s:submit>

	</form>
</body>
</html>