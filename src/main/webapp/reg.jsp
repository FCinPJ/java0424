<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<title>register.jsp</title>
</head>
<body>
   <h3>用户注册</h3>
   <form name="frmreg" method="post"  action="user.do?op=reg">
   
   	用户名：<input name="username" type="text"/><br/>
  	 密码：<input name="password" type="password"/><br/>
      真实名字：<input name="realname" type="text"/><br/>
   <input type="submit" name="btnreg" value="注册"/>
   </form>
</body>
</html>