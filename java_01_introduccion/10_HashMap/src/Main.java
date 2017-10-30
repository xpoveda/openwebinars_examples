import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		  Map<String, Empleado> mapaEmpleados = new  HashMap<String, Empleado>();
		  
		  Empleado e1 = new Empleado("Juan","Perez",10000,"1234Y","ES421234");
		  Empleado e2 = new Empleado("María","García",10000,"4567Y","ES421234");
		  Empleado e3 = new Empleado("Pepe","Fernández",10000,"1234O","ES421234");
		  Empleado e4 = new Empleado("Ana","López",10000,"8765T","ES421234");
		  
		  mapaEmpleados.put(e1.getNif(), e1);
		  mapaEmpleados.put(e2.getNif(), e2);
		  mapaEmpleados.put(e3.getNif(), e3);
		  mapaEmpleados.put(e4.getNif(), e4);
		  
		  Scanner sc = new Scanner(System.in);
		  sc.useDelimiter("[:\\s]");
		  
		  System.out.print("Introduzca el NIF del empleado: ");
		  String nifBusqueda = sc.next();
		  
		  Empleado empleadoBusqueda = mapaEmpleados.get(nifBusqueda);
		  if(empleadoBusqueda!=null) {
		  System.out.println("RESULTADO Búsqueda:\n "+empleadoBusqueda);
		  } else{
			  System.out.println("No se encontró ningún empleado con ese NIF");

		  }
		  
	}

}
