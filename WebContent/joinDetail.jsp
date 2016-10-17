<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>参与详情</title>
</head>
<body>
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
					<td>起点：<s:property value="startingPoint"/></td>
					<td>终点：<s:property value="terminalPoint"/></td>
					<td>出发时间：<s:property value="goOff_first"/></td>
					<td>--<s:property value="goOff_second"/></td>
					<td>到达时间：<s:property value="arrivalTime_first"/></td>
					<td>--<s:property value="arrivalTime_second"/></td>
					<td>参与时间：<s:property value="participateTime_first"/></td>
					<td>--<s:property value="participateTime_second"/></td>
						<td><a
							href="deleteJoinDetailAction?joinDetailDto.userId=<s:property value="userId"/>&id=<s:property value="id"/>">删除</a></td>
					</tr>
				</table>
			</s:iterator>
		</s:else>
	</div>
</body>
</html>