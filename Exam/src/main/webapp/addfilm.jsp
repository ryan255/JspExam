<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.hand.conn.JdbcConnection"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.hand.entities.Language"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
		<form action="<%=request.getContextPath()%>/AddFilmServlet"
			method="post">
			<table>
				<tr><td>电影名：</td>
					<td><input name="name" type="text" style="width: 200px;"></td>
				</tr>
				<tr><td>电影描述：</td>
					<td><input name="description" type="text"  style="height: 100px;width: 200px;"></td>
				</tr>
				<tr><td>语言选择：</td>
					<td>
					<select name="language">
					<%
			try {
				Language language = new Language();
				Connection conn = new JdbcConnection().getConnection();
				String sql = "select language_id,name from language;";
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
		%>
		  <option value="<%=rs.getInt(1)%>"><%=rs.getString(2) %></option>
		<%
			}
				rs.close();
				pst.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		%>
					
					
					
					
					
</select>
</td>
				</tr>
				<tr>
				<td></td>
					<td><input type="submit" value="确定">&nbsp;&nbsp;&nbsp;<input type="reset" value="取消"></td>
				</tr>
			</table>
		</form>

	</center>
</body>
</html>