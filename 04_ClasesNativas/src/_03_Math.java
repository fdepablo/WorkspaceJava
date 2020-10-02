
public class _03_Math {
	public static void main(String[] args) {
		//La clase main sirve para hacer operaciones 
		//matematicas
		//Todos sus metodos son estaticos
		
		double d = Math.sqrt(121);//Raiz cuadrada
		System.out.println(d);
		
		d = Math.pow(5,3);//potencia, base y exponente, 125
		System.out.println(d);
		
		d = Math.PI;//Numero PI
		System.out.println(d);
		
		d = Math.max(0, 40);//Max entre dos numeros
		System.out.println(d);
		
		d = Math.min(0, 40);//Min entre dos numeros
		System.out.println(d);
		
		d = Math.ceil(5.076666);//Nos vamos al entero superior
		System.out.println(d);
		
		d = Math.floor(5.976666);//Nos vamos al entero inferior
		System.out.println(d);
		
		//Redondeamos al mas proximo, 5.5 o mas -> 6
		d = Math.round(5.5);
		System.out.println(d);
		d = Math.round(5.49999);//sino -> 5
		System.out.println(d);
	}
}
