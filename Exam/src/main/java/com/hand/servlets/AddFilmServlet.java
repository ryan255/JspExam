package com.hand.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.dao.FilmDao;
import com.hand.dao.impl.FilmDaoImpl;
import com.hand.conn.JdbcConnection;
import com.hand.entities.Film;

/**
 * Servlet implementation class AddFilmServlet
 */
public class AddFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFilmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String des = request.getParameter("description");
		String lan = request.getParameter("language");
		int lan_id = Integer.parseInt(lan);
		Film film = new Film();
		film.setTitle(name);
		film.setDescription(des);
		film.setLanguage_id(lan_id);
		Connection conn= new JdbcConnection().getConnection();
		FilmDao filmDao = new FilmDaoImpl();
		try {
			filmDao.add(conn, film);
			response.sendRedirect(request.getContextPath()+"/film.jsp");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
