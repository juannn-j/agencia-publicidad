package interfaces;

import java.sql.SQLException;
import java.util.List;

import entidades.CliSocial;

public interface ICliSocial {
	void guardar(CliSocial clisocial) throws SQLException;
	void modificar(CliSocial clisocial) throws SQLException;
	void eliminar(String id) throws SQLException;
	
	List<CliSocial> cargar() throws SQLException;
}
