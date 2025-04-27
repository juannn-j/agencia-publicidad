package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datos.DB;
import entidades.CliCorreo;
import interfaces.ICliCorreo;

public class LCliCorreo implements ICliCorreo{
	Connection cn;
	PreparedStatement ps;
	ResultSet rs;
	DB db;	
	
	@Override
	public void guardar(CliCorreo clicorreo) throws SQLException {
		// TODO Auto-generated method stub
		db=new DB();
		cn=db.conectar();
		String sql = "insert into cliente_correo (correo, proveedor, id_cli) values (?,?,?)";
		ps.setString(1, clicorreo.getCorreo());
		ps.setString(2, clicorreo.getProveedor());
		ps.setInt(3, clicorreo.getId_cli());
		ps.execute();
		cn.close();
	}

	@Override
	public void modificar(CliCorreo clicorreo) throws SQLException {
		// TODO Auto-generated method stub
		db=new DB();
		cn=db.conectar();
		String sql = "update cliente_correo set correo=?, proveedor=?, id_cli=? where id_cli_cor=?";
		ps = cn.prepareStatement(sql);
		ps.setString(1, clicorreo.getCorreo());
		ps.setString(2, clicorreo.getProveedor());
		ps.setInt(3, clicorreo.getId_cli());
		ps.setInt(4, clicorreo.getId_cli_cor());
		ps.execute();
		cn.close();
	}

	@Override
	public void eliminar(String id) throws SQLException {
		// TODO Auto-generated method stub
		db=new DB();
		cn=db.conectar();
		String sql = " delete from cliente_correo where id_cli_cor=?";
		ps = cn.prepareStatement(sql);
		ps.setInt(1, Integer.parseInt(id));
		ps.executeUpdate();
		cn.close();
	}

	@Override
	public List<CliCorreo> cargar() throws SQLException {
		// TODO Auto-generated method stub
		List<CliCorreo> clicorreos = new ArrayList<CliCorreo>();
		db=new DB();
		cn=db.conectar();
		String sql = "select id_cli_cor, correo, proveedor, id_cli from cliente_correo )";
		ps = cn.prepareStatement(sql);
		rs = ps.executeQuery();
		while (rs.next()) {
			CliCorreo clicor = new CliCorreo();
			clicor.setId_cli_cor(rs.getInt(1));
			clicor.setCorreo(rs.getString(2));
			clicor.setProveedor(rs.getString(3));
			clicor.setId_cli(rs.getInt(4));
			clicorreos.add(clicor);
		}
		cn.close();
		return clicorreos;
	}
}
