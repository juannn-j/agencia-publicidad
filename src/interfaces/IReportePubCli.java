package interfaces;

import java.sql.SQLException;
import java.util.List;

import entidades.ReportePubCli;

public interface IReportePubCli {
	List<ReportePubCli> cargar() throws SQLException;
}
