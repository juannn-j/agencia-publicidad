package entidades;

public class Cliente {
	private int id_cli;
	private String nombre;
	private String apellido;
	private String birthdate;
	private String telefono;
	private String direccion;
	private String dni;
	private String sexo;
	private String gusto;
		
	public Cliente() {
		super();
	}

	public Cliente(int id_cli, String nombre, String apellido, String telefono, String direccion, String dni,
			String sexo, String birthdate, String socialmedia, String gusto) {
		super();
		this.id_cli = id_cli;
		this.nombre = nombre;
		this.apellido = apellido;
		this.birthdate = birthdate;
		this.telefono = telefono;
		this.direccion = direccion;
		this.dni = dni;
		this.sexo = sexo;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getBirthDate() {
		return birthdate;
	}

	public void setBirthDate(String birthdate) {
		this.birthdate = birthdate;
	}
	
	public String getGusto() {
		return gusto;
	}
	
	public void setGusto(String gusto) {
		this.gusto = gusto;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nombre;
	}
}