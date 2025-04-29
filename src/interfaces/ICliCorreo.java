package interfaces;

import java.sql.SQLException;
import java.util.List;

import entidades.CliCorreo;

public interface ICliCorreo {
	void guardar(CliCorreo clicorreo) throws SQLException;
	void modificar(CliCorreo clicorreo) throws SQLException;
	void eliminar(String id) throws SQLException;
	
	List<CliCorreo> cargar() throws SQLException;
}
