package com.ibm.sf.dao;

import com.ibm.sf.service.domain.User;
import com.ibm.sf.service.exception.UserException;

public interface UserDAO {
	public abstract Integer addNewUser(User user) throws UserException;
	public abstract Integer getNewUserId() throws UserException;
	public abstract Boolean isValidUser(String username,String password) throws UserException;
	public abstract User getUserDetails(String username,String password) throws UserException;
}
