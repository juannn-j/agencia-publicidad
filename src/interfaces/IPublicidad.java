package interfaces;

import java.sql.SQLException;
import java.util.List;

import entidades.Publicidad;

public interface IPublicidad {
	List<Publicidad> cargar() throws SQLException;
}
