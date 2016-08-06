<%@page import="java.util.HashMap"%>
<%@page import="java.awt.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.hand.dao.impl.FilmDaoImpl"%>
<%@page import="com.hand.dao.FilmDao"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.hand.conn.JdbcConnection"%>
<%@page import="com.hand.entities.Film"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>电影列表</title>
</head>
<body>
	<a href="index.jsp">返回首页</a>
	<table>
		<tr>
			<td width=10% >电影ID</td>
			<td width=10% >电影名</td>
			<td width=20% >描述</td>
			<td width=20% >语言</td>
		</tr>
		<%
			try {
				Film film = new Film();
				FilmDao filmDao = new FilmDaoImpl();
				Connection conn = new JdbcConnection().getConnection();
				String sql = "select film_id,title,description,language_id from film order by film_id desc;";
				String sql2 = "select language_id,name from language;";
				PreparedStatement pst = conn.prepareStatement(sql);
				PreparedStatement pst2 = conn.prepareStatement(sql2);
				ResultSet rs = pst.executeQuery();
				ResultSet rs2 = pst2.executeQuery();
				Map<Integer,List> map = new HashMap();
				
				while (rs.next()) {
					java.sql.PreparedStatement pst1;
					String sql1 = "select name from language where language_id=" + rs.getString(4)+";";
					pst1 = conn.prepareStatement(sql1);
					ResultSet rs1 = pst1.executeQuery();
					while (rs1.next()) {
		%>
		<tr>
			<td width=10% ><%=rs.getString(1)%></td>
			<td width=10% ><%=rs.getString(2)%></td>
			<td width=20% ><%=rs.getString(3)%></td>
			<td width=20% ><%=rs1.getString(1)%></td>
			<td width=5% >
			
			
			<form action="<%=request.getContextPath()%>/DeleteFilmServlet" method="post">
				<input  name="id" value="<%=rs.getInt(1)%>" style="display: none;">
				<input type="submit" value="删除">
			</form>
		</td>
		</tr>
		<%
					}
					rs1.close();
				}
			
				rs.close();
				pst.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		%>
	</table>
	

	

</body>
</html>