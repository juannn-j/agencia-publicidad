package interfaces;

import java.sql.SQLException;
import java.util.List;

import entidades.Cliente2;

public interface ICliente2 {
	List<Cliente2> cargar() throws SQLException;
}
