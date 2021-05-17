package com.divergentsl.clinicmanagementsystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.divergentsl.clinicmanagementsystem.IDatabaseManager;

@Repository
public class LoginDao {
	
IDatabaseManager databaseManager;
	
	public LoginDao(IDatabaseManager databaseManager) {
		this.databaseManager=databaseManager;	
		}
	
	public ResultSet adminLogin()throws SQLException
	{
		Connection connection=databaseManager.getConnection();
		String sqlst="Select * from login_admin";
		Statement statement=connection.createStatement();
		return statement.executeQuery(sqlst);
		
	}
	
	public ResultSet doctorLogin()throws SQLException
	{
		
		Connection connection=databaseManager.getConnection();
		String sqlst="Select * from login_doctor";
		Statement statement=connection.createStatement();
		return statement.executeQuery(sqlst);
	}

}
