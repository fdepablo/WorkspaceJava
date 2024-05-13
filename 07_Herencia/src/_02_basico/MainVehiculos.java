package _02_basico;

import java.util.ArrayList;

public class MainVehiculos {

	public static void main(String[] args) {
		Avion avion = new Avion();
		avion.setFechaFabricacion("23/12/2009");
		System.out.println(avion.esAntiguo());
		
		Moto moto = new Moto();
		moto.setFechaFabricacion("23/12/2009");
		System.out.println(moto.esAntiguo());
		
		Barco barco = new Barco();
		barco.setEsPirata(true);
		barco.setFechaFabricacion("23/12/2003");
		barco.setMarca("La sirena feliz");
		barco.setPeso(3500);
		barco.setVelocidad(20);
		
		//La capacidad de que una referencia ejecute un método u otro
		//dependiendo del objeto al que estamos apuntando se llama
		//polimorfismo.
		System.out.println(avion);
		System.out.println(moto);
		System.out.println(barco);
		
		//IMPORTANTE
		//Con una referencia de una clase superior (o padre) podemos
		//apuntar a cualquier objeto inferior (o hijo)
		//Ojo, no podemos hacerlo al reves, es decir, con una referencia
		//inferior (o hija) no podemos apuntar a un objeto superior (o padre)
		Vehiculo v1 = new Coche();
		//VehiculoTerrestre vt = new Moto();//SI
		//Moto m1 = new Coche()//NO
		//Moto m1 = new Vehiculo();
		//Vehiculo v2 = new VehiculoTerrestre()//SI
		
		//Importante! Aunque con una referencia superior podemos apuntar a objetos
		//inferiores. Solo podemos usar los métodos o atributos que tenga 
		//la referencia!!!!
		Vehiculo v2 = new VehiculoTerrestre();//SI
		//v2.getTipoMoto();//NO
		//v2.getMatricula()//NO
		Vehiculo v3 = new Moto();
		v3.getVelocidad();//SI
		//v3.getTipoMoto();//
		
		//Nos podriamos preguntar, para que vamos a usar
		//una referencia padre en vez de la hija. La respuesta
		//es, aunque no podamos usar todas los métodos
		//del objeto hijo, ganamos en versatilidad, es decir
		//podemos apuntar (con todo lo que conlleva) y utilizar
		//todos métodos de la referencia.
		
		//Imaginaos, que os pido guardar todos los objetos
		//que cree un usuario en memoria, tendriamos que
		//crear una lista para cada entidad.
		
		ArrayList<Moto> listaMotos = new ArrayList<>();
		listaMotos.add(moto);
		//listaMotos.add(avion);
		
		ArrayList<Avion> listaAviones = new ArrayList<Avion>();
		listaAviones.add(avion);
		
		//Con una lista de vehiculos, podemos guardar cualquier
		//objeto que herede de Vehiculo
		ArrayList<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
		listaVehiculos.add(moto);
		listaVehiculos.add(avion);
		listaVehiculos.add(barco);
		
		System.out.println("******************");
		for(Vehiculo v : listaVehiculos) {
			//Mediante el polimorfismo, el método que se 
			//ejecutará será el del objeto al que estamos
			//apuntando, no el método de la refencia
			
			//En este ejemplo, dependendiendo del objeto
			//al que estemos apuntado, se ejecutará su
			//método toString o esAntiguo del propio objeto
			//Ver dibujo "02_basico_polimorfismo.png"
			System.out.println(v.toString());
			System.out.println(v.esAntiguo());
			//System.out.println(v.esPirata());//NO
		}
		
		
	}

}
