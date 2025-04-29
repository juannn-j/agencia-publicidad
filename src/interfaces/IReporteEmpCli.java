package interfaces;

import java.sql.SQLException;
import java.util.List;

import entidades.ReporteEmpCli;

public interface IReporteEmpCli {
	List<ReporteEmpCli> cargar(String nombre_emp) throws SQLException;
}
