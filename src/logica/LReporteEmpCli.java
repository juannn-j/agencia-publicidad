package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datos.DB;
import entidades.ReporteEmpCli;
import interfaces.IReporteEmpCli;

public class LReporteEmpCli implements IReporteEmpCli {
	Connection cn;
	PreparedStatement ps;
	ResultSet rs;
	DB db;
	
	@Override
	public List<ReporteEmpCli> cargar() throws SQLException {
		// TODO Auto-generated method stub
		List<ReporteEmpCli> repempclis = new ArrayList<>();
		db = new DB();
		cn = db.conectar();
		String sql = "SELECT id_emp, empleado, id_cli, cliente, fecha FROM cliempleados;";
		ps = cn.prepareStatement(sql); 
		rs = ps.executeQuery();
		while (rs.next()) {
			ReporteEmpCli repcrd = new ReporteEmpCli(
				rs.getInt(1),
				rs.getString(2),
				rs.getInt(3),
				rs.getString(4),
				rs.getString(5)
			);
			repempclis.add(repcrd);
		}
		if (rs != null) rs.close();
		if (ps != null) ps.close();
		if (cn != null) cn.close();

		return repempclis;
	}

}
