<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>login.jsp</title>
</head>
<body>
	<h3>用户登录</h3>
   <form name="frmreg" method="post"  action="user.do?op=login">
   	用户名：<input name="username" type="text"/><br/>
   	密码：<input name="password" type="password"/><br/>
   	真实名字：<input name="realname" type="text"/><br/>
   <input type="submit" name="btnreg" value="确认"/>
   </form>
</body>
</html>