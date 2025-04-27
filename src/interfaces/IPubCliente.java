package interfaces;

import java.sql.SQLException;
import java.util.List;

import entidades.PubCliente;

public interface IPubCliente {
	void guardar(PubCliente pubcliente) throws SQLException;
	void modificar(PubCliente pubcliente) throws SQLException;
	void borrar(PubCliente pubcliente) throws SQLException;
	
	List<PubCliente> cargar() throws SQLException;
}
