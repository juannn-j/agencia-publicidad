package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datos.DB;
import entidades.ReportePubCli;
import interfaces.IReportePubCli;

public class LReportePubCli implements IReportePubCli {
	Connection cn;
	PreparedStatement ps;
	ResultSet rs;
	DB db;

	@Override
	public List<ReportePubCli> cargar() throws SQLException {
		// TODO Auto-generated method stub
		List<ReportePubCli> reppubclis = new ArrayList<>();
		db = new DB();
		cn = db.conectar();
		String sql = "SELECT id_pub_cli, id_cli, cliente, id_pub, descripcion_anuncio, tipo, fecha FROM pubclientes;";
		ps = cn.prepareStatement(sql); 
		rs = ps.executeQuery();
		while (rs.next()) {
			ReportePubCli repcrd = new ReportePubCli(
				rs.getInt(1),
				rs.getInt(2),
				rs.getString(3),
				rs.getInt(4),
				rs.getString(5),
				rs.getString(6),
				rs.getString(7)
			);
			reppubclis.add(repcrd);
		}
		if (rs != null) rs.close();
		if (ps != null) ps.close();
		if (cn != null) cn.close();

		return reppubclis;
	}

}
