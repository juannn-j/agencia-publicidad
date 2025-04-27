package interfaces;

import java.sql.SQLException;
import java.util.List;

import entidades.ReporteCorrRed;

public interface IReporteCorrRed {
	List<ReporteCorrRed> cargar() throws SQLException;
}
