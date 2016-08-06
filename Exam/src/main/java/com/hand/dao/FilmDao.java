package com.hand.dao;
import java.sql.Connection;
import java.sql.SQLException;

import com.hand.entities.Film;

public interface FilmDao {
	public void delete(Connection conn,Film Film) throws SQLException;
	public void add(Connection conn,Film Film) throws SQLException;
}
