package datos;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	private String url = "jdbc:postgresql://localhost/agenpub2";
	private String user = "postgres";
	private String password = "123";
	
	public Connection conectar() throws SQLException {
		Connection cn = DriverManager.getConnection(url,user,password);
		return cn;
	}
}
