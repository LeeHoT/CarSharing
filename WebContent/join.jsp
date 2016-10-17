<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加参与信息</title>
</head>
<body>
	<h1>添加参与信息</h1>
	<form action="addAddressAction" method="post">
		<input value="<s:property value="#session.id"/>" name="addressDto.userId">
		<s:textarea name="addressDto.province">省</s:textarea>
		<br>
		<s:textarea name="addressDto.city">市</s:textarea>
		<br>
		<s:textarea name="addressDto.detailAdd">街道小区等</s:textarea>
		<br>
		<s:submit name="submit" value="提交"></s:submit>
	</form>
	<div>
		<s:if test="list.size==0">
			<table>
				<tr>
					<td
						style="width: 1300px; font-size: 18px; font: 宋体; color: #999; text-align: center;">您还没有地址
					</td>
				</tr>
			</table>
		</s:if>
		<s:else>
			<s:iterator value="list" status="st">
				<table
					style="margin: auto; width: 1200px; min-width: 800px; border: 1px solid #DDDDDD;">
					<tr style="height: 100px;">
						<td><s:property value="province" />
							<s:property value="city" />
							<s:property value="detailAdd" /></td>
						<td><a
							href="deleteAddressAction?addressDto.userId=<s:property value="userId"/>&id=<s:property value="id"/>">移出购物车</a></td>
					</tr>
				</table>
			</s:iterator>
		</s:else>
	</div>
	<form action="addJoinDetailAction" method="post">
		<input type="hidden" name="joinDetailDto.userId" value="<s:property value="#session.id"/>">
		<s:textarea name="joinDetailDto.startingPoint">起点</s:textarea>
		--
		<s:textarea name="joinDetailDto.terminalPoint">终点</s:textarea>
		<br>
		<s:textarea name="joinDetailDto.goOff_first">出发时间</s:textarea>
		--
		<s:textarea name="joinDetailDto.goOff_second"></s:textarea>
		<br>
		<s:textarea name="joinDetailDto.arrivalTime_first">到达时间</s:textarea>
		--
		<s:textarea name="joinDetailDto.arrivalTime_second"></s:textarea>
		<br>
		<s:textarea name="joinDetailDto.participateTime_first">参与时间</s:textarea>
		--
		<s:textarea name="joinDetailDto.participateTime_second"></s:textarea>
		<br>
		<s:submit name="submit" value="提交"></s:submit>

	</form>

</body>
</html>