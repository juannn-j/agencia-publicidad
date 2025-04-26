package entidades;

public class ReportePubCli {
	// reporte dinamico para mostrar las publicidades 
	// asignadas a clientes, y busqueda por cliente
	private int id_pub;
	private String nombre;
	private String desc_pub;
	
	public ReportePubCli() {
		super();
	}

	public ReportePubCli(int id_pub ,String nombre, String desc_pub) {
		super();
		this.id_pub = id_pub;
		this.nombre = nombre;
		this.desc_pub = desc_pub;
	}

	public int getId_pub() {
		return id_pub;
	}

	public void setId_pub(int id_pub) {
		this.id_pub = id_pub;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDesc_pub() {
		return desc_pub;
	}

	public void setDesc_pub(String desc_pub) {
		this.desc_pub = desc_pub;
	}
	
	
}
