package depuracion;

/*
 * En este ejemplo vamos a seguir depurando pero esta vez también vamos a 
 * depurar una clase importada, la clase Persona. Al ejecutar el programa
 * dará una seríe de errores que tendremos que corregir.
 */
public class _02_DepuracionClases {
	public static void main(String[] args) {
		
		System.out.println("*****************************");
		Persona p1 = new Persona();
		p1.setNombre("Steve Rogers");
		p1.setPeso(84.5);
		//Podemos pulsar F5 para meternos dentro de los métodos y ver que está
		//pasando
		boolean esMayorEdad = p1.esMayorDeEdad();
		System.out.println(esMayorEdad);
		
		Persona p2 = null;
		boolean nombreIgual = p1.tieneMismoNombre(p2);
		System.out.println(nombreIgual);
		
		System.out.println("*****************************");
		for(int i=0;i<100;i++) {
			//Podemos poner un breakpoint condicional, lo ponemos
			//con doble click y a continuacion en la pestaña de breakpoints
			//escogemos la opcion Conditional y dentro le damos el valor (Ej: i==5)
			//Para ver la pestaña de breakpoint debemos de estar en perspectiva de debug
			System.out.println(i);
		}
	}
}
