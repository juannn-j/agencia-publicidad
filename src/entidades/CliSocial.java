package entidades;

public class CliSocial {
	// entidad para registrar redes sociales
	private int id_cli_soc;
	private String user;
	private String proveedor;
	private int id_cli;
	
	public CliSocial(int i, String string, String string2, String string3, String string4) {
		super();
	}

	public CliSocial(int id_cli_soc, String user, String proveedor, int id_cli) {
		super();
		this.id_cli_soc = id_cli_soc;
		this.user = user;
		this.proveedor = proveedor;
		this.id_cli = id_cli;
	}

	public int getId_cli_soc() {
		return id_cli_soc;
	}

	public void setId_cli_soc(int id_cli_soc) {
		this.id_cli_soc = id_cli_soc;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
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
