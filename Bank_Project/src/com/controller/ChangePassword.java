package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Model;



@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		try 
		{
			String op = req.getParameter("op");
			String np = req.getParameter("np");
			String cnp = req.getParameter("cnp");
			HttpSession hs = req.getSession();
			int accno = (int)hs.getAttribute("accno");
			
			Model m = new Model();
			//OLD PASSWORD
			//NEW PASSWORD
			//ACCOUNT NO.
			m.setAccount_number(accno);
			m.setPassword(op);
			boolean status=m.changepassword(np);
			if (status==true) 
			{
				res.sendRedirect("/Bank_Project/login.html");
			}
			else {
				res.sendRedirect("Bank_Project/changepassfail.html");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
}
