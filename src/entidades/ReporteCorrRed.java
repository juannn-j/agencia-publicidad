package entidades;

public class ReporteCorrRed {
	private int id_cli;
	private String cliente;
	private String correos;
	private String redes;
	
	public ReporteCorrRed() {
		super();
	}

	public ReporteCorrRed(int id_cli, String cliente, String correos, String redes) {
		super();
		this.id_cli = id_cli;
		this.cliente = cliente;
		this.correos = correos;
		this.redes = redes;
	}

	public int getId_cli() {
		return id_cli;
	}

	public void setId_cli(int id_cli) {
		this.id_cli = id_cli;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getCorreos() {
		return correos;
	}

	public void setCorreos(String correos) {
		this.correos = correos;
	}

	public String getRedes() {
		return redes;
	}

	public void setRedes(String redes) {
		this.redes = redes;
	}
		
}
