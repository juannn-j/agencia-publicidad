package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import datos.DB;
import interfaces.IEmpleado;

public class LEmpleado implements IEmpleado {
	Connection cn;
	PreparedStatement ps;
	ResultSet rs;
	DB db;
	
	@Override
	public boolean validar(String usuario, String passwd) throws SQLException {
		db = new DB();
		cn = db.conectar();
		
		String sql = "SELECT usuario, passwd FROM empleado WHERE usuario = ? AND passwd = ?";
		ps = cn.prepareStatement(sql);
		ps.setString(1, usuario);
		ps.setString(2, passwd);
		rs = ps.executeQuery();
		
		boolean existe = rs.next(); // si hay un resultado, el login es correcto
		
		// Cerramos conexiones
		if (rs != null) rs.close();
		if (ps != null) ps.close();
		if (cn != null) cn.close();
		
		return existe;
	}

}
