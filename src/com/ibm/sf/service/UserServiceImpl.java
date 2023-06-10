package com.ibm.sf.service;

import java.time.LocalDate;

import com.ibm.sf.dao.UserDAO;
import com.ibm.sf.dao.UserDaoImpl;
import com.ibm.sf.service.domain.User;
import com.ibm.sf.service.exception.UserException;

public class UserServiceImpl implements UserService{
	private UserDAO userDAO =new UserDaoImpl();
	@Override
	public Integer addNewUser(User user) throws UserException {
		try {
			System.out.println(user);
			user.setUserId(userDAO.getNewUserId());
			user.setCreateDate(LocalDate.now());
			System.out.println(user);
			return userDAO.addNewUser(user);
		}catch(UserException e) {
			throw e;
		}
		
	}
	@Override
	public Boolean isValidUser(String username, String password) throws UserException {
		   return userDAO.isValidUser(username, password);
	}
	@Override
	public User getUserDetails(String username, String password) throws UserException {
		  return userDAO.getUserDetails(username, password);
	}

}
