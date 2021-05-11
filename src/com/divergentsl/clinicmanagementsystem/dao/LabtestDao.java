package com.divergentsl.clinicmanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.divergentsl.clinicmanagementsystem.IDatabaseManager;

public class LabtestDao {
	
IDatabaseManager databaseManager;
	
	public LabtestDao(IDatabaseManager databaseManager) {
		this.databaseManager=databaseManager;	
		}
	public int insertLabtest(String name,String drug_id,String drug_price) throws SQLException
	{
		Connection connection=databaseManager.getConnection();
		PreparedStatement statement;
		String sql="INSERT INTO labtest (name,labtest_id,labtest_price) "+" VALUES(?,?,?)";
		statement =connection.prepareStatement(sql);
		statement.setString(1,name);
		statement.setString(2,drug_id);
		statement.setString(3,drug_price);
		return statement.executeUpdate();
	}
	
	public ResultSet showLabtest()throws SQLException
	{
		Connection connection=databaseManager.getConnection();
		Statement st=connection.createStatement();
		String sqlretrive = "SELECT * from labtest";
		ResultSet rsretrive =st.executeQuery(sqlretrive);
		return rsretrive;
	}
	
	public int updateName(String dname,String id) throws SQLException
	{
		Connection connection=databaseManager.getConnection();
		PreparedStatement statement = null;
		
		String sqlupdate = "UPDATE labtest SET name=? WHERE labtst_id=? ";
		
		
		statement = connection.prepareStatement(sqlupdate);
		statement.setString(1, dname);
		statement.setString(2, id);
		return statement.executeUpdate();
	}
	
	public int updatePrice(String price,String id) throws SQLException
	{
		Connection connection=databaseManager.getConnection();
		PreparedStatement statement = null;
		String sqlupdate = "UPDATE labtest SET labtest_price=? WHERE labtest_id=? ";
		statement = connection.prepareStatement(sqlupdate);
		statement.setString(1, price);
		statement.setString(2, id);
		
		return statement.executeUpdate();
	}
}
