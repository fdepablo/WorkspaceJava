package presentacion;

import java.util.Scanner;

import modelo.entidades.Coche;
import modelo.negocio.CochesNegocio;

public class VistaCoches {

	private Scanner sc = new Scanner(System.in);
	
	public void menu() {
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
			default:
				break;
			}
		}while(opcion != 2);
	}

	private void listarCoches() {
		CochesNegocio cn = new CochesNegocio();
		Coche[] arrayCoches = cn.getListaCoches();
		for(Coche c : arrayCoches) {
			if(c != null)
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
			}else {
				System.out.println("Introduzca de nuevo la matricula (Max 10 carac)");
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
		
		System.out.println("Introduzc: " + string);
		String cadena = sc.next();
		return cadena;
	}

	private int mostrarMenuCoche() {
		System.out.println("Bienvenidos a nuestra aplicacion");
		System.out.println("--------------------------------");
		System.out.println("0 - Alta de coche");
		System.out.println("1 - Listar coches");
		System.out.println("2 - Salir");
		int opcion = sc.nextInt();
		return opcion;
	}

}
