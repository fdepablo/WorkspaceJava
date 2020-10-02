package depuracion;

public class _01_MainDebug {
	public static void main(String[] args) {
		int n1 = 5;
		int n2 = 0;
		
		int resultado = Matematicas.sumar(n1, n2);
		System.out.println(resultado);
		resultado = Matematicas.restar(n1, n2);
		System.out.println(resultado);
		resultado = Matematicas.multiplicar(n1, n2);
		System.out.println(resultado);
		
		System.out.println("*****************************");
		for(int i=0;i<10;i++) {
			//podemos poner un breakpoint condicional, lo ponemos
			//con doble click y a continuacion en la pestaña de breakpoints
			//escogemos la opcion Conditional y dentro le damos el valor (Ej: i==5)
			System.out.println(i);
		}
	}
}
