<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<a href="getWechat?username=1&password=2">点此跳转</a>
	<br><br>
	<form action="getWechat" method="post">
	appid:<br>
	<input type="text" name="appId"><br>
	appsecret:<br>
	<input type="text" name="appSecret"><br>
	token:<br>
	<input type="text" name="token"><br>
	<input type="submit" value="submit"> 
	</form>
	
	<hr>
	添加关键字回复规则
	<form action="addRuleOfReply" method="post">
		正则表达式:<br>
		<input type="text" name="key"><br>
		回复内容:<br>
		<input type="text" name="replyText"><br>
		<input type="submit" value="submit"> 
	</form>
	<hr>
	<a href="getbaiduToken">获取百度token</a>
	
	<hr>
	<form action="getBookInfoByName" method="get">
		查询内容:<br>
		<input type="text" name="name"><br>
		<input type="submit" value="submit"> 
	</form>
	
</body>
</html>