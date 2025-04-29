package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import datos.DB;
import entidades.PubCliente;
import interfaces.IPubCliente;

public class LPubCliente implements IPubCliente {
	Connection cn;
	PreparedStatement ps;
	ResultSet rs;
	DB db;
	
	@Override
	public void guardar(PubCliente pubcliente) throws SQLException {
	    String sql = "INSERT INTO pub_emp_cli (fecha, id_emp, id_cli, id_pub) VALUES (?, ?, ?, ?)";
	    if (pubcliente.getId_emp() <= 0 || pubcliente.getId_cli() <= 0 || pubcliente.getId_pub() <= 0) {
	        throw new SQLException("Error: El ID de empleado, cliente o publicidad no puede ser cero o negativo.");
	    }

	    if (pubcliente.getFecha() == null) {
	        throw new SQLException("Error: La fecha no puede ser nula.");
	    }

	    try (Connection cn = new DB().conectar();
	         PreparedStatement ps = cn.prepareStatement(sql)) {

	        ps.setDate(1, new java.sql.Date(pubcliente.getFecha().getTime()));
	        ps.setInt(2, pubcliente.getId_emp());
	        ps.setInt(3, pubcliente.getId_cli());
	        ps.setInt(4, pubcliente.getId_pub());

	        ps.executeUpdate();
	    } catch (SQLException e) {
	        throw new SQLException("Error al guardar PubCliente", e);
	    }
	}



	@Override
	public void modificar(PubCliente pubcliente) throws SQLException {
		// TODO Auto-generated method stub
		db = new DB();
		cn = db.conectar();
		String sql = "update pub_emp_cli set fecha=?, id_emp=?, id_cli=?, id_pub=? where id_pub_cli=?";
		ps = cn.prepareStatement(sql);
		ps.setDate(1, new java.sql.Date(pubcliente.getFecha().getTime()));
		ps.setInt(2, pubcliente.getId_emp());
		ps.setInt(3, pubcliente.getId_cli());
		ps.setInt(4, pubcliente.getId_pub());
		ps.setInt(5, pubcliente.getId_pub_cli());
		ps.execute();
		cn.close();
	}

	@Override
	public void eliminar(String id) throws SQLException {
		// TODO Auto-generated method stub
		db = new DB();
		cn = db.conectar();
		String sql = "delete from pub_emp_cli where id_pub_cli=?";
		ps = cn.prepareStatement(sql);
		ps.setInt(1, Integer.parseInt(id));
		ps.executeUpdate();
		cn.close();
	}

	@Override
	public List<PubCliente> cargar() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
