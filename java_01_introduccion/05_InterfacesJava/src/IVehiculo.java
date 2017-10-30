
public interface IVehiculo {
	public int getVelocidad();
	public void acelerar(int velocidadIncremento);
	public void frenar(int velocidadDeFrenada);
	public int getNumPlazas();
	public int getVelocidadMaxima();
	public String getMatricula();
}
