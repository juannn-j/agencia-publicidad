package interfaces;

import java.sql.SQLException;
import java.util.List;

import entidades.Empleado;

public interface IEmpleado {
	void guardar(Empleado empleado) throws SQLException;
	void modificar(Empleado empleado) throws SQLException;
	void borrar(Empleado empleado) throws SQLException;
	
	List<Empleado> cargar() throws SQLException;
}
