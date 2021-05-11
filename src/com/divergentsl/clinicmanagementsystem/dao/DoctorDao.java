package com.divergentsl.clinicmanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.divergentsl.clinicmanagementsystem.IDatabaseManager;

public class DoctorDao {
	
	IDatabaseManager databaseManager;
	
	
	public DoctorDao(IDatabaseManager databaseManager) {
	this.databaseManager=databaseManager;	
	}
	
	
	public void insertDoctor(String name,String doctor_id,String fees,String degree,String prescription)throws SQLException{
		Connection connection=databaseManager.getConnection();
		PreparedStatement statement;
		
		String sql="INSERT INTO doctor (name,doctor_id,fees,degree,prescription) "+" VALUES(?,?,?,?,?)";
		statement =connection.prepareStatement(sql);
		statement.setString(1,name);
		statement.setString(2,doctor_id);
		statement.setString(3,fees);
		statement.setString(4,degree);
		statement.setString(5,prescription);
		int rowinsert= statement.executeUpdate();
		
		if(rowinsert>0)
		{
			System.out.println("new doctor information added\n");
		}
	}
	
	public ResultSet showDoctor() throws SQLException
	{
		Connection connection=databaseManager.getConnection();
		Statement st=connection.createStatement();
		String sqlretrive = "SELECT * from doctor";
		ResultSet rsretrive =st.executeQuery(sqlretrive);
		return rsretrive;
	}
	
	public int updateName(String dname,String id) throws SQLException
	{
		Connection connection=databaseManager.getConnection();
		PreparedStatement statement = null;
		
		String sqlupdate = "UPDATE doctor SET name=? WHERE doctor_id=? ";
		
		
		statement = connection.prepareStatement(sqlupdate);
		statement.setString(1, dname);
		statement.setString(2, id);
		return statement.executeUpdate();
	}
	
	public int updateSpecialization(String dspec,String id) throws SQLException
	{
		Connection connection=databaseManager.getConnection();
		PreparedStatement statement = null;
		String sqlupdate = "UPDATE doctor SET specialization=? WHERE doctor_id=? ";
		statement = connection.prepareStatement(sqlupdate);
		statement.setString(1, dspec);
		statement.setString(2, id);
		
		return statement.executeUpdate();
	}
	
	public int updateFees(String dfees,String id)throws SQLException
	{

		Connection connection=databaseManager.getConnection();
		PreparedStatement statement = null;
		String sqlupdate = "UPDATE doctor SET fees=? WHERE doctor_id=? ";
		
		statement = connection.prepareStatement(sqlupdate);
		statement.setString(1, dfees);
		statement.setString(2, id);
		return statement.executeUpdate();
	}
	
	public int updateDegree(String ddegree,String id)throws SQLException
	{

		Connection connection=databaseManager.getConnection();
		PreparedStatement statement = null;
		String sqlupdate = "UPDATE doctor SET degree=? WHERE doctor_id=? ";
		statement = connection.prepareStatement(sqlupdate);
		statement.setString(1, ddegree);
		statement.setString(2, id);
		return statement.executeUpdate();
	}
	
	public int updatePrescription(String dpres,String id)throws SQLException
	{

		Connection connection=databaseManager.getConnection();
		PreparedStatement statement = null;
		String sqlupdate = "UPDATE doctor SET prescription=? WHERE doctor_id=? ";
		statement = connection.prepareStatement(sqlupdate);
		statement.setString(1, dpres);
		statement.setString(2, id);
		return statement.executeUpdate();
	}
	public int deleteDotor(String idd)throws SQLException
	{
		Connection connection=databaseManager.getConnection();
		PreparedStatement statement = null;
		statement =connection.prepareStatement("DELETE from doctor where doctor_id=?");
		statement.setString(1, idd);
		return statement.executeUpdate();
	}
}
