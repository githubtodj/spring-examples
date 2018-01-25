<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'login.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
  		<form action="LoginAction!login" method="post">
  			<div>
  				用户名：<input type="text" name="username">
  			</div>
  			<div>
  				密码：<input type="password" name="passwd">
  			</div>
  			<div>
  				<input type="submit" value="登录">
  			</div>
  		</form>
  </body>
</html>
