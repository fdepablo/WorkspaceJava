package _04_ayuda_eclipse;

public class _01_MainEclipse {

	public static void main(String[] args) {
		Persona p1 = new Persona();
		Persona p2 = new Persona("Pepon");
		p2.peso = 123.89;
		Persona p3 = new Persona("Pepin", 15, 56, false);
		
		//por defecto, los objetos se imprimen con el siguiente formato
		//NOMBRE_COMPLETO_CLASE@CODIGO_HASH
		//PERO, si sobreescribimos el método "toString()" de la clase
		//podemos darle el formato que queramos
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
	}

}
