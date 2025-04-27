package interfaces;

import java.sql.SQLException;
import java.util.List;

import entidades.ReportePubCli;

public interface IReportePubCli {
	void guardar(ReportePubCli reportepubclie) throws SQLException;
	void modificar(ReportePubCli reportepubclie) throws SQLException;
	void borrar(ReportePubCli reportepubclie) throws SQLException;
	
	List<ReportePubCli> cargar() throws SQLException;
}
