package com.hand.servlets;

import java.sql.Connection;
import java.sql.ResultSet;

import com.hand.conn.JdbcConnection;
import com.hand.dao.CustomerDao;
import com.hand.dao.impl.CustomerDaoImpl;
import com.hand.entities.Customer;

public class CheckName {
	private CustomerDao customerDao = new CustomerDaoImpl();

	public boolean check(Customer customer) {
		Connection conn = null;

		try {
			conn =new JdbcConnection().getConnection();
			conn.setAutoCommit(false);

			ResultSet resultSet = customerDao.get(conn, customer);

			while (resultSet.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();

			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
		}
		return false;

	}

}
