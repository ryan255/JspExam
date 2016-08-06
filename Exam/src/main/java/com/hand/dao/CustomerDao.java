package com.hand.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.entities.Customer;;

public interface CustomerDao {
	public ResultSet get(Connection conn,Customer customer) throws SQLException;
}

	

