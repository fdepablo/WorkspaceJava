package negocio;

import entidades.Direccion;
import entidades.Persona;

public class Main {

	public static final String CONSTANTE = 
			"variable que no cambia";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona p1 = new Persona();
		p1.nombre = "Marta";
		p1.edad = 34;
		p1.peso = 70;
		
		Persona p2 = new Persona();
		p2.nombre = "Pepe";
		p2.edad = 30;
		p2.peso = 90.5;
		
		Persona p3 = p2;
		p3.peso = 50;
		p3.setDni("567498393s");
		
		p1.correr(30);
		p2.correr(50);
		p1.correr(100);
		
		System.out.println("La persona " + p1.nombre + " esta en "
				+ "la posicion" + p1.getPosicion());
		
		System.out.println(p1);
		
		p3 = new Persona("Felix",37,90,"3456789l",50);
		Persona p4 = new Persona("Felix",37,90,"3456789l",50);
		//p3.edad = 5;
		
		Persona arrayPersonas[] = new Persona[5];
		arrayPersonas[0] = p1;
		arrayPersonas[1] = p3;
		//ambas maneras cambian la edad del objeto a 45,
		//ya que ambas referencias apuntan al mismo objeto
		p3.edad = 45;
		arrayPersonas[1].edad = 45;
		
		Direccion direccion = new Direccion();
		direccion.setTipoVia("CALLE");
		direccion.setNombreVia("Serrano");
		direccion.setNumero(108);
		direccion.setCP("28045");
		
		p3.setDireccion(direccion);
		System.out.println(p3);
		System.out.println(Persona.getNumeroPersonas());
		
		Persona personaMayor = p1.esMayor(p3);
		System.out.println(personaMayor);
	}

}

