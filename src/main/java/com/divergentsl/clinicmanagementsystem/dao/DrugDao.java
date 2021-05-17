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
public class DrugDao {
	
	@Autowired
	
	
//	IDatabaseManager databaseManager;
//	
//	public DrugDao(IDatabaseManager databaseManager) {
//		this.databaseManager=databaseManager;	
//		}
	
	public int insertDrug(String name,String drug_id,String drug_price) throws SQLException
	{
//		Connection connection=databaseManager.getConnection();
//		PreparedStatement statement;
		String sql="INSERT INTO drug (name,drug_id,drug_price) "+" VALUES(?,?,?)";
//		statement =connection.prepareStatement(sql);
//		statement.setString(1,name);
//		statement.setString(2,drug_id);
//		statement.setString(3,drug_price);
		return JdbcTemplate.update(sql,name,drug_id,drug_price);
		
	}
	
	public ResultSet showDrug() throws SQLException
	{
		
//		Connection connection=databaseManager.getConnection();
//		Statement st=connection.createStatement();
		String sqlretrive = "SELECT * from drug";
		ResultSet rsretrive =JdbcTemplate.queryForObject(sqlretrive,ResultSet.class);
		return rsretrive;
	}
	
	public int updatedrugName(String drugname,String id)throws SQLException
	{
//		Connection connection=databaseManager.getConnection();
//		PreparedStatement statement = null;
		String sqlupdate = "UPDATE drug SET name=? WHERE drug_id=? ";
//		statement = connection.prepareStatement(sqlupdate);
//		statement.setString(1, drugname);
//		statement.setString(2, id);
		return JdbcTemplate.update(sqlupdate,drugname,id);
	}
	
	public int updatedrugPrice(String price,String id)throws SQLException
	{
//		Connection connection=databaseManager.getConnection();
//		PreparedStatement statement = null;
		String sqlupdate = "UPDATE drug SET drug_price=? WHERE drug_id=? ";
		
//		statement = connection.prepareStatement(sqlupdate);
//		statement.setString(1, price);
//		statement.setString(2, id);
		return statement.executeUpdate();
	}

}
