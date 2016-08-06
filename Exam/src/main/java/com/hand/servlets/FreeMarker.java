package com.hand.servlets;

import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hand.conn.*;
import freemarker.template.*;

public class FreeMarker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Configuration cfg;

	public void init() {
		cfg = new Configuration();

		cfg.setServletContextForTemplateLoading(getServletContext(), "WEB-INF/templates");
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Build the data-model
		Map root = new HashMap();

		Connection conn = null;
		conn =new JdbcConnection().getConnection();
		String sql = "select title,description,language_id from film;";
		java.sql.PreparedStatement pst;
		try {
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				java.sql.PreparedStatement pst1;
				String sql1 = "select name from language where language_id=" + rs.getString(3)+";";
				pst1 = conn.prepareStatement(sql1);
				ResultSet rs1 = pst1.executeQuery();
				while (rs1.next()) {
					System.out.println(rs.getString(1));
					System.out.println(rs.getString(2));
					System.out.println(rs1.getString(1));
					Template t = cfg.getTemplate("test.ftl");

					root.put("title", rs.getString(1));
					root.put("description", rs.getString(2));
					root.put("language", rs1.getString(1));

					resp.setContentType("text/html; charset=" + t.getEncoding());
					Writer out = resp.getWriter();
					t.process(root, out);
				}
				rs1.close();
			}

			rs.close();
			pst.close();
			conn.close();
		} catch (TemplateException e) {
			e.printStackTrace();
		}

		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
