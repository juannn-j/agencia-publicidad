package entidades;

public class CliCorreo {
	// entidad para registrar correos
	private int id_cli_cor;
	private String correo;
	private String proveedor;
	private int id_cli;
	
	public CliCorreo(int i, String string, String string2, String string3, String string4) {
		super();
	}

	public CliCorreo() {
		super();
		this.id_cli_cor = id_cli_cor;
		this.correo = correo;
		this.proveedor = proveedor;
		this.id_cli = id_cli;
	}

	public int getId_cli_cor() {
		return id_cli_cor;
	}

	public void setId_cli_cor(int id_cli_cor) {
		this.id_cli_cor = id_cli_cor;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public int getId_cli() {
		return id_cli;
	}

	public void setId_cli(int id_cli) {
		this.id_cli = id_cli;
	}
	
	
}
