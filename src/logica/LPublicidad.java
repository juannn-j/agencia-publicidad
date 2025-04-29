package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datos.DB;
import entidades.Cliente2;
import entidades.Publicidad;
import interfaces.IPublicidad;

public class LPublicidad implements IPublicidad {
	Connection cn;
	PreparedStatement ps;
	ResultSet rs;
	DB db;
	
	@Override
	public List<Publicidad> cargar() throws SQLException {
		// TODO Auto-generated method stub
		List<Publicidad> publicidades = new ArrayList<Publicidad>();
		db = new DB();
		cn = db.conectar();
		String sql = "select id_pub,descp,tipo, contacto, imagen from publicidad";
		ps = cn.prepareStatement(sql);
		rs = ps.executeQuery();
		while (rs.next()) {
			Publicidad pbss = new Publicidad();
			pbss.setId_pub(rs.getInt(1));
			pbss.setDesc_pub(rs.getString(2));
			pbss.setTipo_pub(rs.getString(3));
			pbss.setTelefono(rs.getString(4));
			pbss.setImage_pub(rs.getString(5));
			publicidades.add(pbss);
		}
		cn.close();
		return publicidades;
	}

}
