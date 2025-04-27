package interfaces;

import java.sql.SQLException;
import java.util.List;

import entidades.ReporteEmpCli;

public interface IReporteEmpCli {
	void guardar(ReporteEmpCli reporteempcli) throws SQLException;
	void modificar(ReporteEmpCli reporteempcli) throws SQLException;
	void borrar(ReporteEmpCli reporteempcli) throws SQLException;
	
	List<ReporteEmpCli> cargar() throws SQLException;
}
