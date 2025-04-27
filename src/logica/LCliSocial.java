package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datos.DB;
import entidades.CliSocial;
import interfaces.ICliSocial;

public class LCliSocial implements ICliSocial {
	Connection cn;
	PreparedStatement ps;
	ResultSet rs;
	DB db;
	
	@Override
	public void guardar(CliSocial clisocial) throws SQLException {
		// TODO Auto-generated method stub
		db = new DB();
		cn = db.conectar();
		String sql = "insert into cliente_social (usuario, proveedor, id_cli) values (?,?,?)";
		ps = cn.prepareStatement(sql);
		ps.setString(1, clisocial.getUser());
		ps.setString(2, clisocial.getProveedor());
		ps.setInt(3, clisocial.getId_cli());
		ps.execute();
		cn.close();		
	}

	@Override
	public void modificar(CliSocial clisocial) throws SQLException {
		// TODO Auto-generated method stub
		db = new DB();
		cn = db.conectar();
		String sql = "update cliente_social set usuario=?, proveedor=?, id_cli=? where id_cli_soc=?";
		ps = cn.prepareStatement(sql);
		ps.setString(1, clisocial.getUser());
		ps.setString(2, clisocial.getProveedor());
		ps.setInt(3, clisocial.getId_cli());
		ps.setInt(3, clisocial.getId_cli_soc());
		ps.execute();
		cn.close();		
	}

	@Override
	public void eliminar(String id) throws SQLException {
		// TODO Auto-generated method stub
		db = new DB();
		cn = db.conectar();
		String sql = "delete from cliente_social where id_cli_soc=?";
		ps = cn.prepareStatement(sql);
		ps.setInt(1, Integer.parseInt(id));
		ps.executeUpdate();
		cn.close();
	}

	@Override
	public List<CliSocial> cargar() throws SQLException {
		// TODO Auto-generated method stub
		List<CliSocial> clisocials = new ArrayList<CliSocial>();
		db = new DB();
		cn = db.conectar();
		String sql = "select id_cli_soc, usuario, proveedor, id_cli from cliente_social";
		ps = cn.prepareStatement(sql);
		rs = ps.executeQuery();
		while (rs.next()) {
			CliSocial clisoc = new CliSocial();
			clisoc.setId_cli_soc(rs.getInt(1));
			clisoc.setUser(rs.getString(2));
			clisoc.setProveedor(rs.getString(0));
			clisoc.setId_cli(rs.getInt(4));
			clisocials.add(clisoc);
		}
		cn.close();
		return clisocials;
	}

}
