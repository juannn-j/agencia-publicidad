package interfaces;

import java.sql.SQLException;
import java.util.List;

import entidades.ReporteCorrRed;

public interface IReporteCorrRed {
	void guardar(ReporteCorrRed reportecorrred) throws SQLException;
	void modificar(ReporteCorrRed reportecorrred) throws SQLException;
	void borrar(ReporteCorrRed reportecorrred) throws SQLException;
	
	List<ReporteCorrRed> cargar() throws SQLException;
}
