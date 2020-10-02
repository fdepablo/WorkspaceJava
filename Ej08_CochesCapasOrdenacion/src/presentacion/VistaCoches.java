package presentacion;

import java.util.List;
import java.util.Scanner;

import modelo.entidades.Coche;
import modelo.negocio.CochesNegocio;
import modelo.negocio.comparadores.CompararCocheMarca;
import modelo.negocio.comparadores.CompararCocheModelo;

public class VistaCoches {

	private Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		VistaCoches vc = new VistaCoches();
		vc.arrancar();
	}

	private void arrancar() {
		int opcion = 0;
		do {
			opcion = mostrarMenuCoche();
			switch (opcion) {
			case 0:
				altaCoche();
				break;
			case 1:
				listarCoches();
				break;
			case 2:
				mostrarCochesOrdenados(null);
				break;
			case 3:
				mostrarCochesOrdenados("marca");
				break;
			case 4:
				mostrarCochesOrdenados("modelo");
				break;
			case 5:
				buscarCochePorMatricula();
				break;
			default:
				break;
			}
		}while(opcion != 6);
	}

	
	
	private void buscarCochePorMatricula() {
		CochesNegocio cn = new CochesNegocio();
		String matricula = pedirDato("matricula");
		Coche coche = cn.buscarPorMatricula(matricula);
		if(coche != null) {
			mostrarCoche(coche);
		}else {
			System.out.println("El coche con esa matricula no existe");
		}
	}

	private void mostrarCochesOrdenados(String tipoOrden) {
		CochesNegocio cn = new CochesNegocio();
		if(tipoOrden == null) {
			cn.getListaCochesOrdenada(null);
		}else if(tipoOrden.equals("modelo")) {
			cn.getListaCochesOrdenada(new CompararCocheModelo());
		}else if(tipoOrden.equals("marca")) {
			cn.getListaCochesOrdenada(new CompararCocheMarca());
		}
		listarCoches();
	}

	private void listarCoches() {
		CochesNegocio cn = new CochesNegocio();
		List<Coche> arrayCoches = cn.getListaCoches();
		for(Coche c : arrayCoches) {
			mostrarCoche(c);
		}
		
	}

	private void mostrarCoche(Coche c) {
		System.out.println("Matricula: " + c.getMatricula() +
						 "Modelo: " + c.getModelo() +
						 "Marca: " + c.getMarca() +
						 "Kilometros: " + c.getKilometros());
		
	}

	private void altaCoche() {
		int correcto = 0;
		do {
			Coche coche = pedirDatosCoche();
			CochesNegocio cn = new CochesNegocio();
			correcto = cn.addCoche(coche);
			if(correcto == 1) {
				System.out.println("Array lleno no entran más");
			}else if(correcto == 0) {
				System.out.println("Se va a insertar el siguiente coche:");
				mostrarCoche(coche);
			}else if(correcto == 2){
				System.out.println("Introduzca de nuevo la matricula (tiene que tener 7 caracteres)");
			}else {
				System.out.println("El coche ya existe, otra matricula por favor");
			}
		}while(correcto > 1);
	}

	private Coche pedirDatosCoche() {
		String matricula = pedirDato("matricula");
		String marca = pedirDato("marca");
		String modelo = pedirDato("modelo");
		String sKilometros = pedirDato("kilometros");
		double dKilometros = Double.parseDouble(sKilometros);
		
		Coche coche = new Coche();
		coche.setMatricula(matricula);
		coche.setMarca(marca);
		coche.setModelo(modelo);
		coche.setKilometros(dKilometros);
		
		return coche;
	}

	private String pedirDato(String string) {
		
		System.out.println("Introduzca: " + string);
		String cadena = sc.next();
		return cadena;
	}

	private int mostrarMenuCoche() {
		System.out.println("Bienvenidos a nuestra aplicacion");
		System.out.println("--------------------------------");
		System.out.println("0 - Alta de coche");
		System.out.println("1 - Listar coches");
		System.out.println("2 - Ordenar coches por Matricula");
		System.out.println("3 - Ordenar coches por Marca");
		System.out.println("4 - Ordenar coches por modelo");
		System.out.println("5 - Buscar coche por matricula");
		System.out.println("6 - Salir");
		int opcion = sc.nextInt();
		return opcion;
	}

}
