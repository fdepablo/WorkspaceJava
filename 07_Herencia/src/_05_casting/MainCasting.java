package _05_casting;

import java.util.ArrayList;

public class MainCasting {

	public static void main(String[] args) {
		Docente d1 = new Docente();
		d1.salario = 2000;
		d1.setNombre("Dr. Bacterio");
		d1.setEdad(56);
		
		Alumno a1 = new Alumno();
		a1.setNombre("Felipe");
		a1.setEdad(21);
		a1.curso = "Entornos de desarrollo";
		
		Persona p1 = d1;
		System.out.println(p1.getEdad());
		//System.out.println(p1.salario);
		System.out.println(d1.salario);
		
		ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
		listaPersonas.add(a1);
		listaPersonas.add(d1);
		//listaPersonas.forEach(p -> p.presentarse());
		for(Persona p : listaPersonas) {
			p.presentarse();
		}
		
		metodoRecibirLista(listaPersonas);
		
	}

	private static void metodoRecibirLista(ArrayList<Persona> listaPersonas) {
		//queremos mostrar todos los datos de los objetos
		Persona p1 = listaPersonas.get(0);
		//System.out.println(p1.curso);//Este mando a distancia NO tiene "curso"
		
		//Si queremos accder a todos los métodos y atributos de un objeto
		//demos usar el mando a distancia del objeto. Para ello aplicamos
		//el "casting" que vimos en el T1
		//Con el "casting" cambiamos una referencia de tipo
		Alumno a1 = (Alumno)p1;
		System.out.println(a1.curso);
		
		//Problema, java no sabe en tiempo de ejecución a que objeto estas
		//apuntando, por lo que queda a nuestra responsabilidad hacer el 
		//"casting" bien
		//En este caso, java te deja en tiempo de compilación hacer un
		//"casting" a una referncia de tipo Docente, lo que ocurre
		//es que al ser un objeto de tipo Alumno, no podemos usar
		//una referencia de tipo "Docente" para apuntar, en este caso
		//dará una excepción "ClassCastException"
		//Docente d1 = (Docente)p1;
		
		//Para saber la clase de un objeto podemos y evitar "ClassCastException"
		//podemos usar la palabra reservada "instanceof"
		if(p1 instanceof Alumno) {
			//System.out.println(p1.curso);//NO
			Alumno a2 = (Alumno)p1;//ESTO NUNCA ME VA A DAR ERROR
			System.out.println(a2.curso);
		}
		
		//dicho de otra manera, podemos recorrer el array preguntando
		//de que tipo es cada objeto
		System.out.println("Entrando en foreach");
		for(Persona p : listaPersonas) {
			//mediante el polimorfismo
			p.presentarse();
			if(p instanceof Alumno) {
				Alumno a = (Alumno)p;
				System.out.println(a.curso);
			}
			
			if(p instanceof Docente) {
				Docente d = (Docente)p;
				System.out.println(d.salario);
			}
		}
	}
	
	

}
