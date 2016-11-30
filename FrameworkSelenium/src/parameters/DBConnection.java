package parameters;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DBConnection {

	public static Map<String, String> sgbd = new HashMap<String, String>();
	public static Map<String, String> serverName = new HashMap<String, String>();
	public static Map<String, String> portNumber = new HashMap<String, String>();
	public static Map<String, String> dataBaseName = new HashMap<String, String>();
	public static Map<String, String> userName = new HashMap<String, String>();
	public static Map<String, String> password = new HashMap<String, String>();
	
	public static void setConnection(){	
		for (int i = 0; i < Parameters.numberOfDatabase; i++){
			sgbd.put("sgbd"+i, Parameters.vSgbd[i]);
			serverName.put("serverName"+i, Parameters.vServerName[i]);
			portNumber.put("portNumber"+i, Parameters.vPortNumber[i]);
			dataBaseName.put("dataBaseName"+i, Parameters.vDataBaseName[i]);
			userName.put("userName"+i, Parameters.vUserName[i]);
			password.put("password"+i, Parameters.vPassword[i]);
		}

		if(Parameters.numberOfDatabase < Parameters.vSgbd.length){
			System.out.println("The parameter 'numberOfDatabase' were informed incorrectly");
		}
	}
		
	public static java.sql.Connection getConnection(int selectedDatabase) {
	
		setConnection();
		
		Connection connection = null;		

		try {
			String driverName = null;
			String url = null;
			
			switch (Integer.parseInt(sgbd.get("sgbd" + selectedDatabase))) {
			case 0:
				driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
				url = "jdbc:sqlserver://" + serverName.get("serverName" + selectedDatabase) + "/" + dataBaseName.get("dataBaseName" + selectedDatabase);
				break;
			case 1:
				driverName = "com.mysql.jdbc.Driver";
				url = "jdbc:mysql://" + serverName.get("serverName" + selectedDatabase) + "/" + dataBaseName.get("dataBaseName" + selectedDatabase);
				break;
			case 2:
				driverName = "oracle.jdbc.driver.OracleDriver";
				url = "jdbc:oracle:thin:@" + serverName.get("serverName" + selectedDatabase) + ":" + portNumber.get("portNumber" + selectedDatabase) + ":" + dataBaseName.get("dataBaseName" + selectedDatabase);
				break;
			default:
				System.out.println("Error: 'DBConnection.getConnection()'\nSGBD unknown! Enter 0 (SQL Server), 1 (MySQL) or 2 (Oracle)");
				break;
			}
			
			Class.forName(driverName);

			connection = DriverManager.getConnection(url, userName.get("userName" + selectedDatabase), password.get("password" + selectedDatabase));

			return connection;
		}

		catch (ClassNotFoundException e) {
			System.out.println("The driver was not found!");
			return null;
		}
		
		catch (SQLException e) {
			System.out.println("Could not connect in the database!");
			return null;
		}
	}

	public static boolean closeConnection(int selectedDatabase) {
		try {
			getConnection(selectedDatabase).close();
			return true;
		}
		catch (SQLException e) {
			return false;
		}
	}

}