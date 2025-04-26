package entidades;

public class ReportePubCli {
	// reporte dinamico para mostrar las publicidades 
	// asignadas a clientes, y busqueda por cliente
	private int id_cli;
	private String nombre_cli;
	private int id_pub;
	private String desc_pub;
	private String tipo_pub;
	private String fecha;
	
	public ReportePubCli() {
		super();
	}

	public ReportePubCli(int id_cli, String nombre_cli, int id_pub, String desc_pub, String tipo_pub, String fecha) {
		super();
		this.id_cli = id_cli;
		this.nombre_cli = nombre_cli;
		this.id_pub = id_pub;
		this.desc_pub = desc_pub;
		this.tipo_pub = tipo_pub;
		this.fecha = fecha;
	}

	public int getId_cli() {
		return id_cli;
	}

	public void setId_cli(int id_cli) {
		this.id_cli = id_cli;
	}

	public String getNombre_cli() {
		return nombre_cli;
	}

	public void setNombre_cli(String nombre_cli) {
		this.nombre_cli = nombre_cli;
	}

	public int getId_pub() {
		return id_pub;
	}

	public void setId_pub(int id_pub) {
		this.id_pub = id_pub;
	}

	public String getDesc_pub() {
		return desc_pub;
	}

	public void setDesc_pub(String desc_pub) {
		this.desc_pub = desc_pub;
	}

	public String getTipo_pub() {
		return tipo_pub;
	}

	public void setTipo_pub(String tipo_pub) {
		this.tipo_pub = tipo_pub;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
}
