
public class Autobus implements IVehiculo{
	String matricula;
	int velocidadActual;
	int plazasVehiculo;
	public static final int VELOCIDAD_MAX_BUS = 90;
	
	public Autobus() {
		super();
		this.matricula="";
		velocidadActual = 0;
		plazasVehiculo = 0;
	}

	public Autobus(String matricula, int velocidadActual, int plazasVehiculo) {
		super();
		this.matricula = matricula;
		this.velocidadActual = velocidadActual;
		this.plazasVehiculo = plazasVehiculo;
	}

	@Override
	public int getVelocidad() {
		return this.velocidadActual;
	}

	@Override
	public void acelerar(int velocidadIncremento) {
		this.velocidadActual += velocidadIncremento;
		
		System.out.println("El bus va a "+velocidadActual+"km/h");

		if(this.velocidadActual>VELOCIDAD_MAX_BUS) {
			System.out.println("Ha excedido la velocidad máx. permitida para el Bus ("+VELOCIDAD_MAX_BUS+"km/h)");
		}
		
	}

	@Override
	public void frenar(int velocidadDeFrenada) {
		this.velocidadActual -= velocidadDeFrenada;
		
		
		if(this.velocidadActual<=0) {
			this.velocidadActual = 0;
			System.out.println("El Bus se ha parado completamente");
		} else {
			System.out.println("El bus va a "+velocidadActual+"km/h");
		}
		
	}

	@Override
	public int getNumPlazas() {
		return plazasVehiculo;
	}

	@Override
	public int getVelocidadMaxima() {
		return VELOCIDAD_MAX_BUS;
	}

	@Override
	public String getMatricula() {
		return this.matricula;
	}
	
	
	
	

}
