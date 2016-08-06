package com.hand.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hand.dao.FilmDao;
import com.hand.entities.Film;

public class FilmDaoImpl implements FilmDao{

	public void delete(Connection conn, Film film) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pst = conn
				.prepareCall("delete from film where film_id=?;");
		pst.setInt(1, film.getFilm_id());
		pst.execute();		
		
	}

	public void add(Connection conn, Film film) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pst = conn
				.prepareCall("insert into film(title,description,language_id) values(?,?,?)");
		pst.setString(1,film.getTitle());
		pst.setString(2, film.getDescription());
		pst.setInt(3, film.getLanguage_id());
		pst.execute();
	}
	

}
