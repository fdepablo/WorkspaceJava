package _04_lambdas;

import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

//En este ejemplo vamos a crear funciones lambdas a partir de las interfaces funcionales
//que nos proporciona java 1.8
public class _02_Lambdas {
	public static void main(String[] args) {
		//Recordemos que Supplier se usa para generar objetos de un tipo sin argumentos
		//de entrada. En este caso vamos a generar un objeto de tipo Integer
		Supplier<Integer> sup;
		//La primera funcion lambda sería que siempre genere un 2, por ejemplo
		sup = () -> 2;
		Integer numero = sup.get();
		System.out.println(numero);
		
		//Podemos asignar todas las funciones que se nos ocurran
		sup = () -> 3 + 4;
		System.out.println(sup.get());
		
		//Generar un numero aleatorio
		sup = () -> {
			Random rd = new Random();
			int i = rd.nextInt(21);//aleatorio entre el 0 y el 20
			return i;
		};
		System.out.println(sup.get());
		System.out.println(sup.get());
		System.out.println(sup.get());
		
		//Podemos usar Supplier para generar objetos
		Supplier<Persona> supPersona;
		supPersona = () -> {
			Persona p = new Persona();
			p.setId(1);
			p.setNombre("Tony Stark");
			p.setEdad(45);
			return p;
		};
		Persona persona = supPersona.get();
		System.out.println(persona);
		
		//Consumer, en este caso tenemos una entrada pero no tenemos salida
		Consumer<Integer> con;
		con = i -> System.out.println("El numero introducido ha sido: " + i);
		con.accept(4);
		con.accept(78);
		
		Consumer<Persona> conPersona;
		//El siguiente ejemplo tambien valdría con (p) o con (Persona p)
		conPersona = p -> {
			System.out.println("imprimiendo: " + p.getId());
			System.out.println("imprimiendo: " +p.getNombre());
			System.out.println("imprimiendo: " +p.getEdad());
		};
		conPersona.accept(supPersona.get());
		
		Function<String, Integer> func;
		//Notese que no ponemos ni los parentesis, ni el tipo, ni el return
		func = s -> Integer.parseInt(s);
		Integer numero2 = func.apply("50");
		Integer numero3 = func.apply("100");
		System.out.println(numero3 + numero2);
		
		//Funcion lambda que calcula el numero de caracteres
		Function<String,Integer> sizeOf =  s -> s.length();
		System.out.println(sizeOf.apply("Steve Rogers"));
		
		BiFunction<Integer, Integer, Integer> bifunc;
		bifunc = (i,j) -> i + j;
		System.out.println(bifunc.apply(4, 5));
		bifunc = (i,j) -> i * j;
		System.out.println(bifunc.apply(4, 5));
		bifunc = (i,j) -> i - j;
		System.out.println(bifunc.apply(10, 5));
		bifunc = (i,j) -> i / j;
		System.out.println(bifunc.apply(10, 5));
		
		Predicate<Persona> predic;
		predic = p -> {
			if(p.getEdad() > 18) {
				return true;
			}
			return false;
		};
		
		//En programcion funcional es muy habitual orientar a funciones
		System.out.println(predic.test(supPersona.get()));
	}
}
