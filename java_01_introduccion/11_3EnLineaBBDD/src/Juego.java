import java.util.Scanner;

public class Juego {
	public Jugador j1, j2;
	public JugadorDao jDao;
	public String nombreJugador1, nombreJugador2;
	public boolean juegoFinalizado;
	public int jugadorGanador;
	public int numeroDeTurnos;
	public boolean esTurnoJugador1;
	public char[] tablero; 
	public final static int JUEGO_PAREJA = 1;
	public final static int JUEGO_MAQUINA = 2;
	public Scanner sc = new Scanner(System.in);


	private void seleccionOpcionMenu() {

		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("[:\\s]");
		
		System.out.println("*** 3 EN LINEA ***\n"
				+ "1) Jugar 2 jugadores\n"
				+ "2) Jugar contra la máquina\n"
				+ "3) Mostrar Ranking jugadores\n"
				+ "4) Modificar nombre jugador\n"
		);
		
		System.out.print("Indique la opción de Menú:");
		int tipoJuego = sc.nextInt();
		
		if(tipoJuego==1) {
			boolean correcto = false;
			while(!correcto) {
				System.out.print("Indique nombre jugador 1:");
				nombreJugador1 = sc.next();
				j1 = new Jugador(nombreJugador1);
				correcto = jDao.insertar(j1);
			}
			
			correcto = false;
			while(!correcto) {
				System.out.print("\nIndique nombre jugador 2:");
				nombreJugador2 = sc.next();
				j2 = new Jugador(nombreJugador2);
				correcto = jDao.insertar(j2);
			}
			
			siguienteTurno();

			
		} else if(tipoJuego==2) {
			System.out.print("Indique su nombre:");
			nombreJugador1 = sc.nextLine();
			j1 = new Jugador(nombreJugador1);
			jDao.insertar(j1);
			
			siguienteTurno();
			

		} else if(tipoJuego==3) {
			System.out.println("**** RANKING *****");
			jDao.mostrarRanking();
		} else if(tipoJuego==4) {
			System.out.print("Indique su nombre de jugador actual :");
			String nombreJugadorActual = sc.next();
			System.out.print("\nIndique su nombre de jugador nuevo :");
			String nombreJugadorNuevo = sc.next();
			jDao.modificarNombre(nombreJugadorActual, nombreJugadorNuevo);
		}
		
	}


	
	// 1 > jugar contra otro jugador, 2 > jugar contra la máquina
	public int tipoJuego;
	// | 0 | 1  | 2 | 3 | 4  | 5 | 6 | 7 | 8
	// | X | O  |   | X | O  | X |   |   | 
	
	// Definición de constructores
	public Juego() {
		nombreJugador1 = "";
		nombreJugador2 = "";
		juegoFinalizado = false;
		numeroDeTurnos = 0;
		esTurnoJugador1 = true;
		tablero = new char[9];
		tipoJuego = 1;
		sc.useDelimiter("[:\\s]");
		
		jDao = new JugadorDao();
		
		seleccionOpcionMenu();
	}
	

	
	// Declaración e implementación de los métodos de la clase
	
	// Función para establecer el turno del jugador siguiente
	public void cambiarTurnoJugador(int casillaJugada) {
		
		if(esTurnoJugador1) {
			tablero[casillaJugada] = 'X';
			esTurnoJugador1 = false;
		} else {
			tablero[casillaJugada] = 'O';
			esTurnoJugador1 = true;
		}
		
		contadorTurnos();
		mostrarTablero();
		if(!existeSolucionTablero()) {
			siguienteTurno();
		} else {
			System.out.println("PARTIDA FINALIZADA");
			if(esTurnoJugador1) {
				System.out.println("Ha ganado "+nombreJugador2);
				jDao.actualizarPartidasGanadas(nombreJugador2);
			} else { 
				System.out.println("Ha ganado "+nombreJugador1);
				jDao.actualizarPartidasGanadas(nombreJugador1);
			}
		}
	}
	
	private void mostrarTablero() {
		System.out.println("*** 3 en LÍNEA ***");
		
		for(int i=0; i<tablero.length; i++) {
			int numeroCasilla = i+1;
			if(tablero[i]=='X'){
				System.out.print(" X ");
			} else if(tablero[i]=='O') {
				System.out.print(" O ");
			} else {
				System.out.print(" _ ");
			}
			
			System.out.print("("+numeroCasilla+")");
			
			if((i+1)%3==0) {
				System.out.println("");
			}
		}
		
		System.out.println("******************");
		
	}

	// Función para contabilizar el número de turnos de una jugada
	private void contadorTurnos() {
		numeroDeTurnos++;
	}

	
	public void siguienteTurno() {
		if(tipoJuego==JUEGO_MAQUINA) {
			if(esTurnoJugador1) {
				System.out.println("Es el turno de "+nombreJugador1);
			} else {
				System.out.println("Es el turno de la Máquina");
			}
		} else if(tipoJuego==JUEGO_PAREJA) {
			if(esTurnoJugador1) {
				System.out.println("Es el turno de "+nombreJugador1);
			} else {
				System.out.println("Es el turno de "+nombreJugador2);
			}
			
			mostrarTablero();
			
			boolean jugadaCorrecta = false;
			while(!jugadaCorrecta) {
				System.out.print("Indica del 1 al 9 qué casilla deseas ocupar: ");
				int casilla = Integer.parseInt(sc.next());
	
				if(esCasillaLibre(casilla-1)) {
					jugadaCorrecta = true;			
					cambiarTurnoJugador(casilla-1);
				} else {
					System.out.print("ATENCIÓN! La casilla seleccionada está ocupada");
				}
			}
		}
		
		
	}
	
	private boolean esCasillaLibre(int casillaSeleccionada) {
		boolean casillaLibre = false;
		
		/*for(int i=0; i<tablero.length; i++) {
			if(tablero[i]!='X' && tablero[i]!='O') {
				
			}
		}*/
		
		if(tablero[casillaSeleccionada]!='X' && tablero[casillaSeleccionada]!='O') {
			casillaLibre = true;
		}
		
		return casillaLibre;
	}
	
	private boolean existeSolucionTablero() {
		boolean enc = false;
		
		// Buscando soluciones del jugador1
		if(buscaSolucion('X')) {
			jugadorGanador = 1;
			juegoFinalizado = true;
			return true;
		}
		
		// Buscando soluciones del jugador2
		if(buscaSolucion('O')) {
			jugadorGanador = 2;
			juegoFinalizado = true;
			return true;
		}
		
		return enc;
	}
	
	private boolean buscaSolucion(char caracterBusqueda) {
		boolean existe = false;
		String[] soluciones = new String[8];
		
		/*
		 * Soluciones horizontales
		| 0 |  1  |  2 > 0,1,2
		| 3 |  4  |  5 > 3,4,5
		| 6 |  7  |  8 > 6,7,8
		
		Soluciones verticales
		| 0 |  1  |  2 > 0,3,6
		| 3 |  4  |  5 > 1,4,7
		| 6 |  7  |  8 > 2,5,8
		
		Soluciones diagonales
		| 0 |  1  |  2 > 0,4,8
		| 3 |  4  |  5 > 2,4,6
		| 6 |  7  |  8 
		*/
		
		soluciones[0] = "0,1,2";
		soluciones[1] = "3,4,5";
		soluciones[2] = "6,7,8";
		soluciones[3] = "0,3,6";
		soluciones[4] = "1,4,7";
		soluciones[5] = "2,5,8";
		soluciones[6] = "0,4,8";
		soluciones[7] = "2,4,6";
		
		for(int i=0; i<soluciones.length; i++) {
			String stringSolucionActual = soluciones[i];
			String[] casillasSolucion = stringSolucionActual.split(",");
			
			boolean existeSolucionIntermedia = true;
			for(int j=0; j<casillasSolucion.length; j++) {
				int casillaActual = Integer.parseInt(casillasSolucion[j]);
				if(tablero[casillaActual]!=caracterBusqueda) {
					existeSolucionIntermedia = false;
					break;
				}
			}
			
			if(existeSolucionIntermedia) {
				return true;
			}
		}
		
		return existe;
	}}
