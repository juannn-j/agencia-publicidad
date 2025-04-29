package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datos.DB;
import entidades.ReportePubCli;
import entidades.ReportePubCli2;
import interfaces.IReportePubCli;
import interfaces.IReportePubCli2;

public class LReportePubCli2 implements IReportePubCli2 {
	Connection cn;
	PreparedStatement ps;
	ResultSet rs;
	DB db;

	@Override
	public List<ReportePubCli2> cargar(String nombre_cli) throws SQLException {
		// TODO Auto-generated method stub
		List<ReportePubCli2> reppubclis2 = new ArrayList<>();
		db = new DB();
		cn = db.conectar();
		String sql = "SELECT id_cli, cliente, id_pub, descripcion_anuncio, tipo, fecha FROM pubclientes2 where cliente=?";
		ps = cn.prepareStatement(sql); 
		ps.setString(1, nombre_cli);
		rs = ps.executeQuery();
		while (rs.next()) {
			ReportePubCli2 repcrd = new ReportePubCli2(
				rs.getInt(1),
				rs.getString(2),
				rs.getInt(3),
				rs.getString(4),
				rs.getString(5),
				rs.getString(6)
			);
			reppubclis2.add(repcrd);
		}
		if (rs != null) rs.close();
		if (ps != null) ps.close();
		if (cn != null) cn.close();

		return reppubclis2;
	}

}
