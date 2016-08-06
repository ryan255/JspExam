package com.hand.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.entities.Customer;


public class LoginServlet extends HttpServlet{

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String lastName = req.getParameter("name");
		RequestDispatcher rd = null;
		String forward = null;
		
		if (lastName.isEmpty()) {
			req.setAttribute("msg", "用户名是空的");
			rd = req.getRequestDispatcher("/index.jsp");
			rd.forward(req, resp);
		} else {
			Customer customer = new Customer();
			customer.setLastName(lastName);
			CheckName checkName = new CheckName();
			boolean b = checkName.check(customer);
			if(b){
				rd = req.getRequestDispatcher("/success.jsp");
				rd.forward(req, resp);
			}else{
				req.setAttribute("msg","密码或用户名错误");
				rd = req.getRequestDispatcher("/error.jsp");
				rd.forward(req,resp);
			}
		}
		
	}
	
	
}
