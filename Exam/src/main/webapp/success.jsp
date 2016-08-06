<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎</title>
</head>
<body>
登录成功！<br>
欢迎：<%= request.getParameter("name") %><br>
<a href="index.jsp">返回首页</a>
<a href="films.jsp">电影</a>
</body>
</html>
