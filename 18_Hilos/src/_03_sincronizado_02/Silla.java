package _03_sincronizado_02;

public class Silla {
	
	//Si no pusieramos el método como sincronizado, podrían
	//entrar todos los obreros a la vez a descansar. Entonces
	//estaríamos inclumpiendo la regla de que solo un obrero puede
	//sentarse en esta silla a la vez
	public synchronized void descansar(Obrero o) {
		System.out.println("******* Soy el obrero " + o.getNombre() + 
				" y me voy a sentar 10 segundos");
		
		try {
			Thread.sleep(10000);//un obrero descansa 10 segundos
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("****** Soy el obrero " + o.getNombre() + 
				" y ya he descansado! A CURRAR!!");
	}
}
