package main;

import java.util.ArrayList;

import entidad.Direccion;
import entidad.Equipo;
import entidad.Jugador;

public class Principal {

	public static void main(String[] args) {
		Jugador j = new Jugador();
		j.setNombre("Cristiano Ronaldo");
		j.setEdad(35);
		j.setPeso(85);
		
		j.chutar();
		
		Direccion d = new Direccion();
		d.setNombreVia("La plata");
		d.setTipoVia("calle");
		
		//en las clases hemos definido que ambos objetos se pueden ver,
		//pero aqui establecemos el vinculo
		j.setDireccion(d);
		d.setJugador(j);
		
		//Creo un objeto en java
		Jugador j2 = new Jugador();//el objeto nace
		j2.setNombre("Messi");
		
		//aqui el objeto creado en la linea 26 MURIO! :( :( :'(
		j2 = new Jugador();
		//Aqui el objeto creado en la linea 29 MURIO!!!
		//El ciclo de vida de un objeto en java, empieza con un new
		//y acaba cuando no tiene ninguna referencia apuntandole
		//basico para entender la POO
		
		//si queremos mantener un objeto con vida, siempre hay
		//que estar apuntandelo
		//el ciclo de vida de una referencia es el bloque en el que esta declarada
		//es este la referencia j2 vive mientras este el main 
		//ejecutandose
		Jugador j3 = new Jugador();
		j3.setNombre("Luis Suarez");
		
		Jugador j4 = j3;
		j3.setEdad(34);
		
		//Ambas referencias estan apuntando al mismo objeto
		System.out.println("Edad de j4: " + j4.getEdad());
				
		j3 = new Jugador();
		System.out.println("Edad de j3: " + j3.getEdad());
		
		//Accedemos a la direccion de j3
		j3.setDireccion(new Direccion());//Si comentamos esta linea, no tenemos objeto y la linea siguiente fallara
		j3.getDireccion().setNombreVia("Calle Anton Martin");
		System.out.println("Calle: " + j3.getDireccion().getNombreVia());
		
		j3.getHistorial().setNumeroTarjetasRojas(2);
		System.out.println("Numero de tarjetas rojas" + j3.getHistorial().getNumeroTarjetasRojas());
		
		
		ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>();
		listaJugadores.add(j);
		listaJugadores.add(j3);
		
		Equipo equipo = new Equipo();
		//En este caso, si yo elimino la lista de jugadores del equipo
		//los objetos jugadores seguirian existiendo ya que
		//tienen referencias todavia apuntandoles (j y j3)
		equipo.setListaJugadores(listaJugadores);
		equipo.setNombre("Sevilla");
		//equipo.setListaJugadores(null);
		
		//las refencias solo contienen direcciones de memmoria, los valores
		//estan en los objetos
		equipo.getListaJugadores().get(0).setNombre("Ronaldo 'El gordo'");
		System.out.println(j.getNombre());
		
		Jugador j5 = j;
		j5.setNombre("Iker Casillas");
		
		System.out.println(j.getNombre());
		System.out.println(equipo.getListaJugadores().get(0).getNombre());

	}

}
