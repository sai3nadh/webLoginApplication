package com.ibm.sf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.ibm.sf.service.domain.User;
import com.ibm.sf.service.exception.UserException;

public class UserDaoImpl implements UserDAO{
	private Logger daoLogger=Logger.getLogger(UserDaoImpl.class);
	
	@Override
	public Integer addNewUser(User user) throws UserException {
		
		Connection connection=null;
		try {
			Context context= 
					(Context)new InitialContext().lookup("java:comp/env");
			DataSource dataSource= (DataSource) context.lookup("jdbc/userDB");
			connection=dataSource.getConnection();
			PreparedStatement preparedStatement=
					connection.prepareStatement(QueryMapper.ADD_USER);
			populatePreparedStatement(user,preparedStatement);
			int status=preparedStatement.executeUpdate();
			if(status>0) {
				daoLogger.info("New user: "+user.getUserId()+" added to database");
				return user.getUserId();
			}else {
				throw new UserException("Unable to add user");
			}
		}catch(SQLException e) {
			daoLogger.error(e.getMessage());
			throw new UserException(e.getMessage());
		}catch(Exception e) {
			daoLogger.error(e.getMessage());
			throw new UserException(e.getMessage());
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		
	}

	private void populatePreparedStatement(User user, PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setInt(1, user.getUserId());
		preparedStatement.setString(2, user.getUserName());
		preparedStatement.setString(3, user.getPassword());
		//java.time.LocalDate->java.sql.Date
		preparedStatement
		.setDate(4, java.sql.Date.valueOf(user.getCreateDate()));
		preparedStatement.setString(5, user.getEmail());
	}

	@Override
	public Integer getNewUserId() throws UserException {
		Connection connection=null;
		try {
			Context context= 
					(Context)new InitialContext().lookup("java:comp/env");
			DataSource dataSource= (DataSource) context.lookup("jdbc/userDB");
			connection=dataSource.getConnection();
			PreparedStatement preparedStatement=
					connection.prepareStatement(QueryMapper.NEW_USER_ID);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				return resultSet.getInt(1);
			}else {
				throw new UserException("Unable to generate new userid");
			}
		}catch(SQLException e) {
			throw new UserException(e.getMessage());
		}catch(Exception e) {
			throw new UserException(e.getMessage());
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
	}

	@Override
	public Boolean isValidUser(String username, String password) throws UserException {
		Connection connection=null;
		try {
			Context context= 
					(Context)new InitialContext().lookup("java:comp/env");
			DataSource dataSource= (DataSource) context.lookup("jdbc/userDB");
			connection=dataSource.getConnection();
			PreparedStatement preparedStatement=
					connection.prepareStatement(QueryMapper.VERIFY_USER);
			preparedStatement.setString(1,username);
			preparedStatement.setString(2, password);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				return true;
			}else {
				return false;
			}
		}catch(SQLException e) {
			daoLogger.error(e.getMessage());
			throw new UserException(e.getMessage());
		}catch(Exception e) {
			daoLogger.error(e.getMessage());
			throw new UserException(e.getMessage());
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
	}

	@Override
	public User getUserDetails(String username, String password) throws UserException {
		Connection connection=null;
		try {
			Context context= 
					(Context)new InitialContext().lookup("java:comp/env");
			DataSource dataSource= (DataSource) context.lookup("jdbc/userDB");
			connection=dataSource.getConnection();
			PreparedStatement preparedStatement=
					connection.prepareStatement(QueryMapper.GET_USER);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				User user=new User();
				populateUser(resultSet,user);
				return user;
			}else {
				throw new UserException("Unable to generate new userid");
			}
		}catch(SQLException e) {
			throw new UserException(e.getMessage());
		}catch(Exception e) {
			throw new UserException(e.getMessage());
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
	}

	private void populateUser(ResultSet resultSet, User user) throws SQLException {
		user.setUserId(resultSet.getInt("USER_ID"));
		user.setUserName(resultSet.getString("USER_NAME"));
		user.setEmail(resultSet.getString("EMAIL"));
		user.setPassword(resultSet.getString("PASSWORD"));
		//java.sql.Date->java.time.LocalDate
		user.setCreateDate(resultSet.getDate("CREATE_DATE").toLocalDate());
		
	}

}
