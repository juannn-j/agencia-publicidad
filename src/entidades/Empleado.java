package entidades;

public class Empleado {
	// Entidad Empleado para mostrar
	private int id_emp;
	private String nombre;
	private String usuario;
	private String passwd;
	
	public Empleado() {
		super();
	}

	public Empleado(int id_emp, String nombre, String usuario, String passwd) {
		super();
		this.id_emp = id_emp;
		this.nombre = nombre;
		this.usuario = usuario;
		this.passwd = passwd;
	}

	public int getId_emp() {
		return id_emp;
	}

	public void setId_emp(int id_emp) {
		this.id_emp = id_emp;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
}
