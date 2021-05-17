package com.divergentsl.clinicmanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.divergentsl.clinicmanagementsystem.IDatabaseManager;
@Repository
public class DoctorDao {
	
	/*
	IDatabaseManager databaseManager;
	
	public DoctorDao(IDatabaseManager databaseManager) {
	this.databaseManager=databaseManager;	
	}
	*/
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//@Autowired
	//NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	


	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	public void insertDoctor(String name,String doctor_id,String fees,String degree,String prescription)throws SQLException{
		
		String sql="INSERT INTO doctor VALUES(?,?,?,?,?)";
	
		int rowinsert= jdbcTemplate.update(sql,name,doctor_id,fees,degree,prescription);
		
		if(rowinsert>0)
		{
			System.out.println("new doctor information added\n");
		}
	}
	
	public ResultSet showDoctor() throws SQLException
	{
	//	Connection connection=databaseManager.getConnection();
	//	Statement st=connection.createStatement();
		String sqlretrive = "SELECT * from doctor";
		ResultSet rsretrive =jdbcTemplate.queryForObject(sqlretrive,ResultSet.class);
		return rsretrive;
	}
	
	public int updateName(String dname,String id) throws SQLException
	{
		//Connection connection=databaseManager.getConnection();
		//PreparedStatement statement = null;
		
		String sqlupdate = "UPDATE doctor SET name=? WHERE doctor_id=? ";
		//statement = connection.prepareStatement(sqlupdate);
		//statement.setString(1, dname);
		//statement.setString(2, id);
		return jdbcTemplate.update(sqlupdate,dname,id);
	}
	
	public int updateSpecialization(String dspec,String id) throws SQLException
	{
		//Connection connection=databaseManager.getConnection();
		//PreparedStatement statement = null;
		String sqlupdate = "UPDATE doctor SET specialization=? WHERE doctor_id=? ";
		//statement = connection.prepareStatement(sqlupdate);
		//statement.setString(1, dspec);
		//statement.setString(2, id);
		
		return jdbcTemplate.update(sqlupdate,dspec,id);
	}
	
	public int updateFees(String dfees,String id)throws SQLException
	{

		//Connection connection=databaseManager.getConnection();
		//PreparedStatement statement = null;
		String sqlupdate = "UPDATE doctor SET fees=? WHERE doctor_id=? ";
		//statement = connection.prepareStatement(sqlupdate);
		//statement.setString(1, dfees);
		//statement.setString(2, id);
		return jdbcTemplate.update(sqlupdate,dfees,id);
	}
	
	public int updateDegree(String ddegree,String id)throws SQLException
	{

		//Connection connection=databaseManager.getConnection();
		//PreparedStatement statement = null;
		String sqlupdate = "UPDATE doctor SET degree=? WHERE doctor_id=? ";
		//statement = connection.prepareStatement(sqlupdate);
		//statement.setString(1, ddegree);
		//statement.setString(2, id);
		return jdbcTemplate.update(sqlupdate,ddegree,id);
	}
	
	public int updatePrescription(String dpres,String id)throws SQLException
	{

		//Connection connection=databaseManager.getConnection();
		//PreparedStatement statement = null;
		String sqlupdate = "UPDATE doctor SET prescription=? WHERE doctor_id=? ";
		//statement = connection.prepareStatement(sqlupdate);
		//statement.setString(1, dpres);
		//statement.setString(2, id);
		return jdbcTemplate.update(sqlupdate,dpres,id);
	}
	public int deleteDotor(String idd)throws SQLException
	{
		//Connection connection=databaseManager.getConnection();
		//PreparedStatement statement = null;
		//statement =connection.prepareStatement("DELETE from doctor where doctor_id=?");
		//statement.setString(1, idd);
		return jdbcTemplate.update("DELETE from doctor where doctor_id=?",idd);
	}
	
}
