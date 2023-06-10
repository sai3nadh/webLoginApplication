package com.ibm.sf.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import com.ibm.sf.service.UserService;
import com.ibm.sf.service.UserServiceImpl;
import com.ibm.sf.service.domain.User;
import com.ibm.sf.service.exception.UserException;


@WebFilter(filterName="/authorize",urlPatterns="/login")
public class AuthorizationFilter implements Filter {
	private UserService service=new UserServiceImpl();
    
    public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			User user=service.getUserDetails(username, password);
			if(user.getEmail().contains("ibm")) {
				chain.doFilter(request, response);
			}else {
				throw new UserException("Privacy Protection. Unauthorized user");
			}
		}catch(UserException e) {
			HttpServletResponse resp=(HttpServletResponse)response;
			resp.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE,e.getMessage());
		}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
