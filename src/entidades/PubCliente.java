package entidades;

public class PubCliente {
	// Entidad para asignar publiciddades a clientes por empleado
	private int id_pub_cli;
	private String fecha;
	private int id_emp;
	private int id_cli;
	private int id_pub;
	
	public PubCliente() {
		super();
	}

	public PubCliente(int id_pub_cli, String fecha, int id_emp, int id_cli, int id_pub) {
		super();
		this.id_pub_cli = id_pub_cli;
		this.fecha = fecha;
		this.id_emp = id_emp;
		this.id_cli = id_cli;
		this.id_pub = id_pub;
	}

	public int getId_pub_cli() {
		return id_pub_cli;
	}

	public void setId_pub_cli(int id_pub_cli) {
		this.id_pub_cli = id_pub_cli;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getId_emp() {
		return id_emp;
	}

	public void setId_emp(int id_emp) {
		this.id_emp = id_emp;
	}

	public int getId_cli() {
		return id_cli;
	}

	public void setId_cli(int id_cli) {
		this.id_cli = id_cli;
	}

	public int getId_pub() {
		return id_pub;
	}

	public void setId_pub(int id_pub) {
		this.id_pub = id_pub;
	}
	
}
