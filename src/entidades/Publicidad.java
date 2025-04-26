package entidades;

public class Publicidad {
	// Entidad para mostrar las publicidades
	private int id_pub;
	private String desc_pub;
	private String tipo_pub;
	private String telefono;
	private String image_pub;
	
	public Publicidad() {
		super();
	}

	public Publicidad(int id_pub, String desc_pub, String tipo_pub, String telefono, String image_pub) {
		super();
		this.id_pub = id_pub;
		this.desc_pub = desc_pub;
		this.tipo_pub = tipo_pub;
		this.telefono = telefono;
		this.image_pub = image_pub;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getImage_pub() {
		return image_pub;
	}

	public void setImage_pub(String image_pub) {
		this.image_pub = image_pub;
	}
	
}
