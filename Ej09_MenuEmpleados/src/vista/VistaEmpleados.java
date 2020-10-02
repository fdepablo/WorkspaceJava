package vista;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.entidades.Directivo;
import modelo.entidades.Empleado;
import modelo.entidades.Jefe;
import modelo.entidades.Trabajador;
import modelo.negocio.GestorEmpleados;

public class VistaEmpleados {
	
	private Scanner sc = null;
	private GestorEmpleados ge = null;
	
	public void arrancar() {
		sc = new Scanner(System.in);
		ge = new GestorEmpleados();
		ArrayList<Empleado> listaEmpleado = null;
		int opcion = 0;
		do{
			opcion = mostrarMenu();
			switch (opcion) {
			case 1://alta
				crearEmpleado();
				break;
	
			case 2://baja
				String nombre = pedirNombre();
				ge.baja(nombre);
				break;
			
			case 3://listar
				listaEmpleado = ge.getListaEmpleados();
				mostrarListaEmpleados(listaEmpleado);
				break;
			case 4://mostra salario
				listaEmpleado = ge.getListaEmpleados();
				mostrarSalarios(listaEmpleado);
				break;			
			}
		}while(continuar(opcion));
		
		System.out.println("Fin del programa");
	}

	private boolean continuar(int opcion) {
		// TODO Auto-generated method stub
		if(opcion == 5)
			return false;
		else
			return true;
	}

	private void mostrarSalarios(ArrayList<Empleado> listaEmpleado) {
		for(Empleado empleado : listaEmpleado){
			System.out.println("Empleado: " + empleado.getNombre() +
						" Salario:" + empleado.calcularSueldo());//polimorfismo
		}
		
	}

	private void mostrarListaEmpleados(ArrayList<Empleado> listaEmpleado) {
		for(Empleado empleado : listaEmpleado){
			System.out.println(empleado);
		}
	}

	/**
	 * Metodo que pide un nombre al usuario para borrar
	 * @return String con el nombre a borrar
	 */
	private String pedirNombre() {
		System.out.println("Introduzca el nombre del empleado a borrar");
		String nombre = sc.next();
		return nombre;
	}

	/**
	 * Metodo que crea un empleado a partir de los datos
	 * introducidos por pantalla del usuario
	 * @return El empleado creado que puede ser Trabajador,Jefe,Director
	 */
	private void crearEmpleado() {
		int opcion = menuEmpleados();
		Empleado empleado = null;
		boolean altaCorrecta = true;
		while (altaCorrecta) {
			switch (opcion) {
			case 1://Trabajador
				empleado = crearTrabajador();
				break;
	
			case 2://Jefe
				empleado = crearJefe();
				break;
			case 3://Director
				empleado = crearDirector();
				break;
			}
			altaCorrecta = ge.alta(empleado);
			if(!altaCorrecta) {
				System.out.println("El nombre del empleado no puede estar vacio");
			}
		}
	}

	private Empleado crearDirector() {
		System.out.println("Introduzca el nombre:");
		String nombre = sc.next();
		System.out.println("Introduzca la nomina:");
		double nomina = sc.nextDouble();
		Directivo directivo = new Directivo();
		directivo.setNombre(nombre);
		directivo.setNomina(nomina);
		ArrayList<Empleado> empleadosACargo = seleccionarEmpleados();
		directivo.setListaEmpleadosACargo(empleadosACargo);
		return directivo;
	}

	private ArrayList<Empleado> seleccionarEmpleados() {
		ArrayList<Empleado> empleadosSeleccionados = new ArrayList<>();
		
		ArrayList<Empleado> listaEmpleados = ge.getListaEmpleados();
		System.out.println("Seleccione los empleados a cargo");
		int i = 0;
		for(Empleado empleado : listaEmpleados){
			System.out.println(i++ + " - " + empleado);
		}
		System.out.println("Elija los empleados separados por coma");
		String sEmpleados = sc.next();
		String arrayEmpleados[] = sEmpleados.split(",");//1,2,3
		for(String empleado : arrayEmpleados){
			int seleccion = Integer.valueOf(empleado);//String 1 -> Int 1
			Empleado e = listaEmpleados.get(seleccion);
			empleadosSeleccionados.add(e);
		}
		return empleadosSeleccionados;
	}

	private Empleado crearJefe() {
		System.out.println("Introduzca el nombre:");
		String nombre = sc.next();
		System.out.println("Introduzca la nomina:");
		double nomina = sc.nextDouble();
		System.out.println("Introduzca el incentivo:");
		double incentivo = sc.nextDouble();
		Jefe jefe = new Jefe();
		jefe.setNombre(nombre);
		jefe.setNomina(nomina);
		jefe.setIncentivo(incentivo);
		return jefe;
	}

	private Empleado crearTrabajador() {

		System.out.println("Introduzca el nombre:");
		String nombre = sc.next();
		System.out.println("Introduzca la nomina:");
		double nomina = sc.nextDouble();
		Trabajador trabajador = new Trabajador();
		trabajador.setNombre(nombre);
		trabajador.setNomina(nomina);
		return trabajador;
	}

	private int menuEmpleados() {
		System.out.println("Introduzca el empleado que quiere crear");
		System.out.println("1 - Trabajador");
		System.out.println("2 - Jefe");
		System.out.println("3 - Directivo");
		int opcion = sc.nextInt();
		return opcion;
	}

	private int mostrarMenu() {
		System.out.println("Introduzca la opcion que quiere realizar");
		System.out.println("1 - Alta empleado");
		System.out.println("2 - Baja empleado");
		System.out.println("3 - Listar empleados");
		System.out.println("4 - Mostrar salarios");
		System.out.println("5 - Salir del programa");
		int opcion = sc.nextInt();
		return opcion;
	}
}
