package com.divergentsl.clinicmanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.divergentsl.clinicmanagementsystem.IDatabaseManager;

public class PatientDao {
	
IDatabaseManager databaseManager;
	
	
	public PatientDao(IDatabaseManager databaseManager) {
	this.databaseManager=databaseManager;	
	}
	public int insertPatient(String name,String patient_age,String pId,String weight,String problem,String app_date,String contact)throws SQLException
		{
		Connection connection=databaseManager.getConnection();
		PreparedStatement statement;
	
		String sql="INSERT INTO patient (name,age,patient_id,weight,problem,app_date,contact) "+" VALUES(?,?,?,?,?,?,?)";
		statement =connection.prepareStatement(sql);
		statement.setString(1,name);
		statement.setString(2,patient_age);
		statement.setString(3,pId);
		statement.setString(4,weight);
		statement.setString(5,problem);
		statement.setString(6,app_date);
		statement.setString(7,contact);
		return statement.executeUpdate();
		}

	public ResultSet showPatient() throws SQLException
	{
		String sqlretrive = "SELECT * from patient";
		Connection connection=databaseManager.getConnection();
		Statement st=connection.createStatement();
		ResultSet rsretrive =st.executeQuery(sqlretrive);
		return rsretrive;
	}
	public int updateName(String dname,String id) throws SQLException
	{
		Connection connection=databaseManager.getConnection();
		PreparedStatement statement = null;
		
		String sqlupdate = "UPDATE patient SET name=? WHERE patient_id=? ";
		
		
		statement = connection.prepareStatement(sqlupdate);
		statement.setString(1, dname);
		statement.setString(2, id);
		return statement.executeUpdate();
	}
	
	public int updateAge(String age,String id) throws SQLException
	{
		Connection connection=databaseManager.getConnection();
		PreparedStatement statement = null;
		String sqlupdate = "UPDATE patient SET age=? WHERE patient_id=? ";
		statement = connection.prepareStatement(sqlupdate);
		statement.setString(1, age);
		statement.setString(2, id);
		
		return statement.executeUpdate();
	}
	
	public int updateWieght(String weight,String id)throws SQLException
	{

		Connection connection=databaseManager.getConnection();
		PreparedStatement statement = null;
		String sqlupdate = "UPDATE patient SET weight=? WHERE patient_id=? ";
		
		statement = connection.prepareStatement(sqlupdate);
		statement.setString(1, weight);
		statement.setString(2, id);
		return statement.executeUpdate();
	}
	
	public int updateProblem(String problem,String id)throws SQLException
	{

		Connection connection=databaseManager.getConnection();
		PreparedStatement statement = null;
		String sqlupdate = "UPDATE patient SET problem=? WHERE patient_id=? ";
		statement = connection.prepareStatement(sqlupdate);
		statement.setString(1, problem);
		statement.setString(2, id);
		return statement.executeUpdate();
	}
	
	public int updateAppDate(String app,String id)throws SQLException
	{

		Connection connection=databaseManager.getConnection();
		PreparedStatement statement = null;
		String sqlupdate = "UPDATE patient SET app_date=? WHERE patient_id=? ";
		statement = connection.prepareStatement(sqlupdate);
		statement.setString(1, app);
		statement.setString(2, id);
		return statement.executeUpdate();
	}
	
	public int updateContact(String contact,String id)throws SQLException
	{

		Connection connection=databaseManager.getConnection();
		PreparedStatement statement = null;
		String sqlupdate = "UPDATE patient SET contact=? WHERE patient_id=? ";
		statement = connection.prepareStatement(sqlupdate);
		statement.setString(1, contact);
		statement.setString(2, id);
		return statement.executeUpdate();
	}
	
	public int deletePatient(String pId)throws SQLException
	{
		Connection connection=databaseManager.getConnection();
		PreparedStatement statement = null;
		statement =connection.prepareStatement("DELETE from patient where patient_id=?");
		statement.setString(1, pId);
		return statement.executeUpdate();
		
	}
}
