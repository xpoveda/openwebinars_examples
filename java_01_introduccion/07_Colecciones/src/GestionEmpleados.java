import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class GestionEmpleados {
	private List<Empleado> listaEmpleados;
	Scanner sc = new Scanner(System.in);
	
	public GestionEmpleados() {
		super();
		sc.useDelimiter("[:\\s]");

	}

	public void mostrarMenu() {
	
		listaEmpleados = new ArrayList<Empleado>();
		
		int opcionMenu = 1;
	
		while(opcionMenu!=4) {
			System.out.println("Introduzca la opción que desee:\n"
				+ "1) Insertar un empleado\n"
				+ "2) Eliminar un empleado\n"
				+ "3) Mostrar todos los empleados\n"
				+ "4) Salir de la app\n");
		
			opcionMenu = Integer.parseInt(sc.next());
			
			switch(opcionMenu) {
				case 1: insertarEmpleado(); break;
				case 2: eliminarEmpleado(); break;
				case 3: listarEmpleados(); break;
			}
		}
	}

	private void listarEmpleados() {
		Iterator<Empleado> it = listaEmpleados.iterator();
		System.out.println("**** LISTADO DE EMPLEADOS ****");

		// Opción 1 para listar con Iterator
		/*int contador = 1;
		while(it.hasNext()) {
			System.out.println("**** EMPLEADO "+contador+" ****");
			Empleado empleadoActual = it.next();
			System.out.println(empleadoActual.toString());
			contador++;
		}*/
		
		// Opción 2 listar con buble for
		for(int i=0; i<listaEmpleados.size(); i++) {
			Empleado empleadoActual = listaEmpleados.get(i);
			System.out.println("**** EMPLEADO "+i+" ****");
			System.out.println(empleadoActual.toString());
		}
	}

	private void eliminarEmpleado() {
		System.out.print("\nIndique el nº de empleado a eliminar: ");
		int numEmpleado = Integer.parseInt(sc.next());
		
		// Eliminamos el empleado que ocupa la posicion numEmpleado
		listaEmpleados.remove(numEmpleado);
		
		// Llamamos al método que lista los Empleados
		listarEmpleados();
	}

	private void insertarEmpleado() {
		System.out.print("Nombre: ");
		String nombre = sc.next();
		
		System.out.print("\nApellidos: ");
		String apellidos = sc.next();
		
		System.out.print("\nSalario: ");
		int salario = Integer.parseInt(sc.next());
		
		System.out.print("\nNIF: ");
		String nif = sc.next();
		
		System.out.print("\nIBAN: ");
		String iban = sc.next();
		
		Empleado nuevoEmpleado = new Empleado(nombre, apellidos, salario, nif, iban);
		
		// Añadimos el empleado que acabamos de crear con los datos
		// que el usuario ha introducido, con el método add
		listaEmpleados.add(nuevoEmpleado);
		
		// Llamamos al método que lista los Empleados
		listarEmpleados();
		
	}
}
