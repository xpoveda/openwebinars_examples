import java.util.Scanner;

public class Main { 
	public static final int TAXI = 1;
	public static final int BUS = 2;
	public static final int ACELERAR = 1;
	public static final int FRENAR = 2;
	
	public static void main(String[] args) {
		IVehiculo vehiculo = null;
		
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("[:\\s]");
		
		System.out.print("Qué vehículo de nuestra flota desea utilizar:\n"
				+ "1) Taxi\n"
				+ "2) Autobús\n");
		
		int vehiculoSeleccionado = Integer.parseInt(sc.next());
		
		if(vehiculoSeleccionado==TAXI) {
			vehiculo = new Taxi("1234KNY",0,5);
		} else if(vehiculoSeleccionado==BUS) {
			vehiculo = new Autobus("5678KNY",0,50);
		}
		
		int opcionMenu = 1;
		
		while(opcionMenu!=3) {
			System.out.print("¿Qué desea hacer?:\n"
					+ "1) Acelerar\n"
					+ "2) Frenar\n"
					+ "3) Salir de la aplicación");
			opcionMenu = Integer.parseInt(sc.next());
			
			if(opcionMenu==ACELERAR) {
				vehiculo.acelerar(20);
			} else if(opcionMenu==FRENAR) {
				vehiculo.frenar(10);
			} else {
				System.out.println("Hemos aparcado el vehículo con matrícula "+vehiculo.getMatricula());
			}
		}
		
	}

}
