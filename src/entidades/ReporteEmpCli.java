package entidades;

public class ReporteEmpCli {
	// reporte dinamico para mostrar las clientes
	// atendidos por empleados, y busqueda por empleado
	private int id_emp;
	private String nombre_emp;
	private int id_cli;
	private String nombre_cli;
	private String fecha;
	
	public ReporteEmpCli() {
		super();
	}

	public ReporteEmpCli(int id_emp, String nombre_emp, int id_cli, String nombre_cli, String fecha) {
		super();
		this.id_emp = id_emp;
		this.nombre_emp = nombre_emp;
		this.nombre_cli = nombre_cli;
	}

	public int getId_emp() {
		return id_emp;
	}

	public void setId_emp(int id_emp) {
		this.id_emp = id_emp;
	}

	public String getNombre_emp() {
		return nombre_emp;
	}

	public void setNombre_emp(String nombre_emp) {
		this.nombre_emp = nombre_emp;
	}

	public String getNombre_cli() {
		return nombre_cli;
	}
	
	public int getId_cli() {
		return id_cli;
	}

	public void setId_cli(int id_cli) {
		this.id_cli = id_cli;
	}

	public void setNombre_cli(String nombre_cli) {
		this.nombre_cli = nombre_cli;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
}
