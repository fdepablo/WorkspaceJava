package modelo.entidades;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Direccion direccionPropietario = new Direccion();
		direccionPropietario.setTipoVia(TipoVia.CALLE);
		direccionPropietario.setNombreVia("Serrano");
		direccionPropietario.setCP("28234");
		direccionPropietario.setNumero(108);
		
		Persona propietario = new Persona();
		propietario.setNombre("Harry Potter");
		propietario.setTelefono("Sangung");
		propietario.setDni("4567890g");
		propietario.setDireccion(direccionPropietario);
		
		ArrayList<Persona> listaInquilinos = new ArrayList<>();
		Persona inquilino1 = new Persona();
		inquilino1.setNombre("hernion");
		inquilino1.setDni("45678902s");
		inquilino1.setTelefono("aifone");
		
		Direccion direccionCasa = new Direccion();
		direccionCasa.setTipoVia(TipoVia.AVENIDA);
		direccionCasa.setNombreVia("jog�ards");
		direccionCasa.setCP("09876");
		direccionCasa.setNumero(1);
		
		inquilino1.setDireccion(direccionCasa);
		
		Persona inquilino2 = new Persona();
		inquilino2.setNombre("ron");
		inquilino2.setDni("9876543s");
		inquilino2.setTelefono("+3491234567");
		inquilino2.setDireccion(direccionCasa);
		
		listaInquilinos.add(inquilino1);
		listaInquilinos.add(inquilino2);
		//listaInquilinos.remove(inquilino2);
		//listaInquilinos.remove(0);
		Persona i1 = listaInquilinos.get(1);
		for(Persona p1 : listaInquilinos){
			System.out.println(p1);
		}
		
		ArrayList<Habitacion> listaHabitaciones = new ArrayList<>();
		Habitacion habitacionSalon = new Habitacion();
		habitacionSalon.setTipoHabitacion(TipoHabitacion.SALON);
		habitacionSalon.setMetros(200);
		
		Habitacion habitacionBanio = new Habitacion();
		habitacionBanio.setTipoHabitacion(TipoHabitacion.BANIO);
		habitacionBanio.setMetros(10);
		
		listaHabitaciones.add(habitacionSalon);
		listaHabitaciones.add(habitacionBanio);
		
		Casa joguard = new Casa();
		joguard.setPrecio(20000);
		joguard.setDireccion(direccionCasa);
		joguard.setListaHabitaciones(listaHabitaciones);
		joguard.setListaInquilinos(listaInquilinos);
		joguard.setPropietario(propietario);
		
		System.out.println(joguard);
		
		System.out.println("Seleccione un tipo de habitacion:");
		int i = 1;
		for(TipoHabitacion th : TipoHabitacion.values()){
			System.out.println(i++ + "-" + th);
		}
		
		Scanner sc = new Scanner(System.in);
		int seleccion = sc.nextInt();
		TipoHabitacion th = TipoHabitacion.values()[seleccion -1];
		System.out.println("Ha seleccionado: " + th);
		sc.close();
	}
}
