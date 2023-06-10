package com.ibm.sf.service;

import com.ibm.sf.service.domain.User;
import com.ibm.sf.service.exception.UserException;

public interface UserService {
	public abstract Integer addNewUser(User user) throws UserException;
	public abstract Boolean isValidUser(String username,String password) throws UserException;
	public abstract User getUserDetails(String username,String password) throws UserException;
}
