package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datos.DB;
import entidades.Cliente2;
import interfaces.ICliente2;

public class LCliente2 implements ICliente2 {
	Connection cn;
	PreparedStatement ps;
	ResultSet rs;
	DB db;
	
	@Override
	public List<Cliente2> cargar() throws SQLException {
		// TODO Auto-generated method stub
		List<Cliente2> clientes2 = new ArrayList<Cliente2>();
		db = new DB();
		cn = db.conectar();
		String sql = "select id_cli, nombre, gusto from cliente";
		ps = cn.prepareStatement(sql);
		rs = ps.executeQuery();
		while (rs.next()) {
			Cliente2 cli2 = new Cliente2();
			cli2.setId_cli(rs.getInt(1));
			cli2.setNombre(rs.getString(2));
			cli2.setGusto(rs.getString(3));
			clientes2.add(cli2);
		}
		cn.close();
		return clientes2;
	}

}
