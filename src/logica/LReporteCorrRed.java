package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datos.DB;
import entidades.ReporteCorrRed;
import interfaces.IReporteCorrRed;

public class LReporteCorrRed implements IReporteCorrRed {
	Connection cn;
	PreparedStatement ps;
	ResultSet rs;
	DB db;
	
	@Override
	public List<ReporteCorrRed> cargar() throws SQLException {
		// TODO Auto-generated method stub
		List<ReporteCorrRed> repcoreds = new ArrayList<>();
		db = new DB();
		cn = db.conectar();
		String sql = "SELECT id_cli, cliente, correos, redes_sociales FROM redcorclientes";
		ps = cn.prepareStatement(sql); 
		rs = ps.executeQuery();
		while (rs.next()) {
			ReporteCorrRed repcrd = new ReporteCorrRed(
				rs.getInt(1),
				rs.getString(2),
				rs.getString(3),
				rs.getString(4)
			);
			repcoreds.add(repcrd);
		}
		if (rs != null) rs.close();
		if (ps != null) ps.close();
		if (cn != null) cn.close();

		return repcoreds;
	}

}
