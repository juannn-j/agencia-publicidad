package interfaces;

import java.sql.SQLException;
import java.util.List;

import entidades.ReportePubCli;
import entidades.ReportePubCli2;

public interface IReportePubCli2 {
	List<ReportePubCli2> cargar(String nombre_cli) throws SQLException;
}
