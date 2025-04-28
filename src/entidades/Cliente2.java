package entidades;

public class Cliente2 {
	private int id_cli;
	private String nombre;
	private String gusto;
	
	public Cliente2() {
		super();
	}

	public Cliente2(int id_cli, String nombre, String gusto) {
		super();
		this.id_cli = id_cli;
		this.nombre = nombre;
		this.gusto = gusto;
	}

	public int getId_cli() {
		return id_cli;
	}

	public void setId_cli(int id_cli) {
		this.id_cli = id_cli;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGusto() {
		return gusto;
	}

	public void setGusto(String gusto) {
		this.gusto = gusto;
	}
	
	
}
