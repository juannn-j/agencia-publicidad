package interfaces;

import java.sql.SQLException;
import java.util.List;

import entidades.Cliente;

public interface ICliente {
	void guardar(Cliente cliente) throws SQLException;
	void modificar(Cliente cliente) throws SQLException;
	void borrar(Cliente cliente) throws SQLException;
	
	List<Cliente> cargar() throws SQLException;
}
