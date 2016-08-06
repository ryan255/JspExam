package com.hand.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.dao.CustomerDao;
import com.hand.entities.Customer;

public class CustomerDaoImpl implements CustomerDao{
	public ResultSet get(Connection conn, Customer customer) throws SQLException {
		String sql = "select * from customer where last_name = ? ";
		java.sql.PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, customer.getLastName());
		return ps.executeQuery();
	}

}
