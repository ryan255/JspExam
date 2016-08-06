<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.sql.Connection"
    import="com.hand.entities.*"
    import="com.hand.dao.*"
    import="com.hand.conn.*"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>电影</title>
</head>
<body>
<table>
		<tr>
			<td width=10% align="center">电影ID</td>
			<td width=10% align="center">电影名</td>
			<td width=20% align="center">描述</td>
			<td width=20% align="center">语言</td>
		</tr>
		<%
			try {
				Film film = new Film();
				FilmDao filmDao = new FilmDaoImpl();
				Connection conn = new DBCon().getDBCon();
				String sql = "select film_id,title,description,language_id from film;";
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
		%>
		<tr>
			<td width=10% align="center"><%=rs.getString(1)%></td>
			<td width=10% align="center"><%=rs.getString(2)%></td>
			<td width=20% align="center"><%=rs.getString(3)%></td>
			<td width=20% align="center"><%=rs.getString(4)%></td>
			<td width=5% align="center"><input type="button" name="del" id="2" value="删除"
		onClick="aa(<%=rs.getInt(1)%>)" /></td>
		</tr>
		<%
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