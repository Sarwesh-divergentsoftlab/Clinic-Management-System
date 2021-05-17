package com.divergentsl.clinicmanagementsystem;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDatabaseManager {
	
	String username = "root";

	String password = "root";

	String url = "jdbc:mysql://localhost:3306/clinicmanagement";

	public Connection getConnection() throws SQLException ;


}
