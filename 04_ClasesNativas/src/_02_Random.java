import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class _02_Random {
	public static void main(String[] args) {
		Random rd = new Random();
		
		boolean b = rd.nextBoolean();//true o false
		int i = rd.nextInt();//Entre el rango
		double d = rd.nextDouble();//entre 0.0(incluido) y 1.0(excluido)
	
		System.out.println(b);
		System.out.println(i);
		System.out.println(d);
		System.out.println("-----------");
		
		//Entre un rango de 0(incluido) y un numero(excluido)
		//entre 0 y 9
		i = rd.nextInt(10);		
		System.out.println(i);
		
		//Si queremos entre 1 y 10
		i = rd.nextInt(10) + 1;
		System.out.println(i);
		
		//Si queremos otros numeros podemos usar la siguiente
		//formula
		//argumento = numero mayor - numero menor + 1
		//suma = numero menor
		//Un numero aleatorio entre 10 y 80
		//argumento = 80 - 10 + 1 = 71
		//suma = 10
		i = rd.nextInt(71) + 10;
		System.out.println(i);
		
		//Desde la 1.7
		//Entre el 10 y el 80
		i = ThreadLocalRandom.current().nextInt(10,81);
		System.out.println(i);
		
		System.out.println("-------------------");
		//Con la misma semilla obtenemos la misma secuencia
		//Si no decimos nada coje la de la fecha del sistema
		rd = new Random(20L);
		System.out.println(rd.nextInt());
		System.out.println(rd.nextInt());
		System.out.println(rd.nextInt());
		System.out.println(rd.nextInt());
		System.out.println("-------------------");
		
		rd = new Random(10L);
		System.out.println(rd.nextInt());
		System.out.println(rd.nextInt());
		System.out.println(rd.nextInt());
		System.out.println(rd.nextInt());
		
		System.out.println("-------------------");
		rd = new Random(20L);
		System.out.println(rd.nextInt());
		System.out.println(rd.nextInt());
		System.out.println(rd.nextInt());
		System.out.println(rd.nextInt());
	}
}
