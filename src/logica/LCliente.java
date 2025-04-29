package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datos.DB;
import entidades.Cliente;
import interfaces.ICliente;

public class LCliente implements ICliente{
	Connection cn;
	PreparedStatement ps;
	ResultSet rs;
	DB db;
	
	@Override
	public void guardar(Cliente cliente) throws SQLException {
		// TODO Auto-generated method stub
		db=new DB();
		cn=db.conectar();
		String sql = "insert into cliente (nombre, apellido, birthdate, telefono, direccion, dni, sexo, gusto) values(?,?,?,?,?,?,?,?)";
		ps = cn.prepareStatement(sql);
		ps.setString(1, cliente.getNombre());
		ps.setString(2, cliente.getApellido());
		ps.setDate(3, new java.sql.Date(cliente.getBirthDate().getTime()));
		ps.setString(4, cliente.getTelefono());
		ps.setString(5, cliente.getDireccion());
		ps.setString(6, cliente.getDni());
		ps.setString(7, cliente.getSexo());
		ps.setString(8, cliente.getGusto());
		ps.execute();
		cn.close();
	}

	@Override
	public void modificar(Cliente cliente) throws SQLException {
		// TODO Auto-generated method stub
		db=new DB();
		cn=db.conectar();
		String sql = "update cliente set nombre=?, apellido=?, birthdate=?, telefono=?, direccion=?, dni=?, sexo=?, gusto=? where id_cli=? ";
		ps = cn.prepareStatement(sql);
		ps.setString(1, cliente.getNombre());
		ps.setString(2, cliente.getApellido());
		ps.setDate(3, new java.sql.Date(cliente.getBirthDate().getTime()));
		ps.setString(4, cliente.getTelefono());
		ps.setString(5, cliente.getDireccion());
		ps.setString(6, cliente.getDni());
		ps.setString(7, cliente.getSexo());
		ps.setString(8, cliente.getGusto());
		ps.setInt(9, cliente.getId_cli());
		ps.execute();
		cn.close();
	}

	@Override
	public void eliminar(String id) throws SQLException {
		db = new DB();
		cn = db.conectar();
		String sql = "delete from cliente where id_cli=?";
		ps = cn.prepareStatement(sql);
		ps.setInt(1, Integer.parseInt(id));
		ps.executeUpdate();
		cn.close();
	}

	@Override
	public List<Cliente> cargar() throws SQLException {
		// TODO Auto-generated method stub
		List<Cliente> clientes = new ArrayList<Cliente>();
		db=new DB();
		cn=db.conectar();
		String sql = "select id_cli, nombre, apellido, birthdate, telefono, direccion, dni, sexo, gusto from cliente";
		ps = cn.prepareStatement(sql);
		rs = ps.executeQuery();
		while (rs.next()){
			Cliente cli = new Cliente(); //  , , rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9) );
			cli.setId_cli(rs.getInt(1));
			cli.setNombre(rs.getString(2));
			cli.setApellido(rs.getString(3));
			cli.setBirthDate(rs.getDate(4));
			cli.setTelefono(rs.getString(5));
			cli.setDireccion(rs.getString(6));
			cli.setDni(rs.getString(7));
			cli.setSexo(rs.getString(8));
			cli.setGusto(rs.getString(9));
			clientes.add(cli);
		}
		cn.close();
		return clientes;
	}

}
