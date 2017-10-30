
public class Empleado {
	private String nombre;
	private String apellidos;
	private int salario;
	private String nif;
	private String codigoIban;
	
	// Constructor
	public Empleado(String nombre, String apellidos, int salario, String nif, String codigoIban) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.salario = salario;
		this.nif = nif;
		this.codigoIban = codigoIban;
	}

	// Getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public int getSalario() {
		return salario;
	}


	public void setSalario(int salario) {
		this.salario = salario;
	}


	public String getNif() {
		return nif;
	}


	public void setNif(String nif) {
		this.nif = nif;
	}


	public String getCodigoIban() {
		return codigoIban;
	}


	public void setCodigoIban(String codigoIban) {
		this.codigoIban = codigoIban;
	}
	
	@Override
	public String toString() {
		return "Apellidos y nombre: "+this.apellidos+", "+this.nombre+"\n"
				+ "NIF: "+this.nif+"\n"
						+ "Salario: "+this.salario+"€ brutos/año\n"
						+ "IBAN: "+this.codigoIban;
				
	}
}
