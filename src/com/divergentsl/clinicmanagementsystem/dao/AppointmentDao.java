package com.divergentsl.clinicmanagementsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.divergentsl.clinicmanagementsystem.IDatabaseManager;

public class AppointmentDao {
	
IDatabaseManager databaseManager;
	
	
	public AppointmentDao(IDatabaseManager databaseManager) {
	this.databaseManager=databaseManager;	
	}
	
	public ResultSet showAssignedAppointment(String dId)throws SQLException
	{
			Connection connection=databaseManager.getConnection();
			Statement st = connection.createStatement();
			String sqlretrive = "SELECT * from patient where doctor_id='"+dId+"'";
			ResultSet rsretrive =st.executeQuery(sqlretrive);
			return rsretrive;
	}
	
	public int addPrescription(String pid,String pres) throws SQLException
	{
		Connection connection=databaseManager.getConnection();
		Statement st = connection.createStatement();
		PreparedStatement statement;
		String sql="update patient SET prescription=? where patient_id='"+pid+"'";
		statement =connection.prepareStatement(sql);
		statement.setString(1,pres);
		return statement.executeUpdate();
	}
	
	public ResultSet patHistory(String pId) throws SQLException
	{
		Connection connection=databaseManager.getConnection();
		Statement st = connection.createStatement();
	
		String sqlretrive = "SELECT * from patient where patient_id='"+pId+"'";
		return st.executeQuery(sqlretrive);
				
	}
	
	public int addAppointment(String pid,String did, String problem,String date,String time) throws SQLException
	{
		Connection connection=databaseManager.getConnection();
		Statement st = connection.createStatement();
		PreparedStatement statement;
		String sql="INSERT INTO appointment (patient_id,doctor_id,problem,app_date,time) "+" VALUES(?,?,?,?,?)";
		statement =connection.prepareStatement(sql);
		statement.setString(1,pid);
		statement.setString(2,did);
		statement.setString(3,problem);
		statement.setString(4,date);
		statement.setString(5,time);
		return st.executeUpdate(sql);
	}
	
	public  ResultSet invoice()throws SQLException 
	{
		 Connection connection=databaseManager.getConnection();			
		 Statement st = connection.createStatement();
			
		String sqlretrive = "SELECT patient.name,patient.age,patient.patient_id,patient.weight,patient.problem,patient.app_date,patient.contact,patient.doctor_id,patient.prescription,doctor.name,doctor.fees,doctor.specializatio,doctor.prescription FROM patient JOIN doctor ON patient.doctor_id=doctor.doctor_id\r\n";
		return st.executeQuery(sqlretrive);
	}

}
