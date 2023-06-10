package com.ibm.sf.dao;

public interface QueryMapper {
	public static final String ADD_USER="insert into users_ibm values(?,?,?,?,?)";
	public static final String NEW_USER_ID="select users_ibm_seq.nextval from dual";
	public static final String VERIFY_USER="select * from users_ibm where user_name=? and password=?";
	public static final String GET_USER="select * from users_ibm where user_name=? and password=?";
}
