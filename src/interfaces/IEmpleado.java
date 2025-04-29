package interfaces;

import java.sql.SQLException;
import java.util.List;

import entidades.Empleado;

public interface IEmpleado {
	boolean validar(String usuario, String passwd) throws SQLException;
}
