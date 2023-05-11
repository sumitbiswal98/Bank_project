package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ChangeNameValidation")
public class ChangeNameValidation extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		try 
		{
			String on = req.getParameter("on");
			String nn = req.getParameter("nn");
			
			if (on.length()==0 || nn.length()==0) 
			{
				res.sendRedirect("invalidchangename.html");
			}
			else 
			{
				if (on.equals(nn)) 
				{
					res.sendRedirect("namesame.html");
				}
				else 
				{
					req.getServletContext().getRequestDispatcher("/ChangeName").forward(req, res);
				}
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
