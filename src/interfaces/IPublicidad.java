package interfaces;

import java.sql.SQLException;
import java.util.List;

import entidades.Publicidad;

public interface IPublicidad {
	void guardar(Publicidad publicidad) throws SQLException;
	void modificar(Publicidad publicidad) throws SQLException;
	void borrar(Publicidad publicidad) throws SQLException;
	
	List<Publicidad> cargar() throws SQLException;
}
