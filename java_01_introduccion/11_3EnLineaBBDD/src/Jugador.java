
public class Jugador {
	private int id;
	private String nombre;
	private int partidasGanadas;

	public Jugador() {
		
	}
	
	public Jugador(String nombre) {
		this.nombre = nombre;
	}

	public Jugador(int id, String nombre, int partidasGanadas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.partidasGanadas = partidasGanadas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPartidasGanadas() {
		return partidasGanadas;
	}

	public void setPartidasGanadas(int partidasGanadas) {
		this.partidasGanadas = partidasGanadas;
	}
	
	
}
