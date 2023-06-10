package com.ibm.sf.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			HttpSession session=request.getSession(false);
			if(session!=null) {
				session.removeAttribute("username");
				session.invalidate();
				out.println("<html<body><h3>"+"You have logged out"+
						"</h3></body></html>");
			}else {
				out.println("<html<body><h3>"+"You have already logged out"+
									"</h3></body></html>");				
			}
			out.println("<h3><font color=\"cyan\"><a href=\"login.html\">Login</a></font></h3>");
		}catch(Exception e) {
			response.sendError(HttpServletResponse.SC_NO_CONTENT,e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
