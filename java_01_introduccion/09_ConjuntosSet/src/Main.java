import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		Set<Empleado> conjuntoEmpleados = new TreeSet<Empleado>();

		Empleado e1 = new Empleado("Juan", "Pérez", 10000, "123456J","ES421122334455");
		Empleado e2 = new Empleado("María", "Pérez", 10000, "123456J","ES421122334455");
		
		System.out.println(e1.getNombre()+", "+e2.getNombre()+" ¿equals? = "+e1.equals(e2));
		
		
		conjuntoEmpleados.add(e1);
		conjuntoEmpleados.add(e2);
		
		Iterator<Empleado> it = conjuntoEmpleados.iterator();
		while(it.hasNext()) {
			Empleado e = it.next();
			System.out.println(e);
			
		}
		
		System.out.println("Empleado 1 en conjunto? "+conjuntoEmpleados.contains(e1));
		conjuntoEmpleados.remove(e1);
		System.out.println("Empleado 1 en conjunto? "+conjuntoEmpleados.contains(e1));
	}

}
