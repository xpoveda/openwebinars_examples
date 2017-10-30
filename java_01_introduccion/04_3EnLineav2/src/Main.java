import java.util.Scanner;

public class Main {
	public static String nombreJugador1, nombreJugador2;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("[:\\s]");
		
		System.out.println("*** NUEVA PARTIDA ***\n"
				+ "1) 2 jugadores\n"
				+ "2) Jugar contra la máquina\n"
		);
		
		seleccionarJugadores();
		
		mostrarTablero();
		
	}

	private static void seleccionarJugadores() {

		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("[:\\s]");
		
		System.out.print("Indique el tipo de juego:");
		int tipoJuego = sc.nextInt();
		
		if(tipoJuego==1) {
			System.out.print("Indique nombre jugador 1:");
			nombreJugador1 = sc.next();
			
			System.out.print("\nIndique nombre jugador 2:");
			nombreJugador2 = sc.next();
			
		} else {
			System.out.print("Indique su nombre:");
			nombreJugador1 = sc.nextLine();
		}
		
	}

	private static void mostrarTablero() {
		System.out.println("Juego de "+nombreJugador1+" VS "+nombreJugador2);
		
		int numeroCasilla = 1;
		for(int fila=0; fila<3; fila++) {
			for(int columna=0; columna<3; columna++) {
				System.out.print("_ ("+numeroCasilla+")");
				numeroCasilla++;
			}
			System.out.println("");
		}
		
	}

}
