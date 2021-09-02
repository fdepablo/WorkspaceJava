
public class _02_Operaciones {
	public static void main(String[] args) {
		//sobre los numeros podemos realizar "+,-,*,/"
		int i = 10;
		int j = 2;
		int resultado = 10 / 2;
		resultado = resultado + 1;
		resultado++;//resultado = resultado +1;
		System.out.println(resultado);
		
		//asignamos y luego incrementamos
		int numero1 = resultado++;
		//incrementamos y luego asignamos
		int numero2 = ++resultado;
		System.out.println(
				numero1);
		System.out.println(numero2);
		
		//tambien nos sirven para hacer numeros negativos
		int numero3 = -3;
		
		//operadores logicos
		//AND (&&) y !
		//el ^ es el XOR
		boolean b = true && false; 
		System.out.println(b);
		//OR (||)
		boolean b1 = b || true;
		System.out.println(b1);
		//Negacion (!)
		boolean b2 = !b1;
		System.out.println(b2);
		
		//acumulación
		int numero4 = 5;
		numero4 += 5;//numero4 = numero4 + 5;

		System.out.println(numero4);
		
		//Modulo, devuelve el resto de la division entera (%)
		int resto = 10 % 2;
		System.out.println(resto);
		
		//De menor a mayor tamaño podemos hacerlo directamente
		int numero5 = 10;
		double double1 = numero5;
		
		//de mayor a menor tamaño debemos de hacer un cast
		//pero podemos perder precisión
		int numero6 = (int)double1;
	}
}


