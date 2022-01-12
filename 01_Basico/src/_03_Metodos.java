
public class _03_Metodos {
	//main es la funcion por defecto por la que va a entrar
	//nuestro programa
	public static void main(String[] args) {
		imprimir(addHola("Felix"));
		despedirse();
	}
	
	private static void despedirse() {
		//Guardar en base de datos
		imprimir("adios");	
	}

	//public -> visibilidad
	//String -> tipo devuelto(parametros de salida)
	// 	void en caso de no devolver nada
	//addHola -> nombre de la funcion
	//(String frase) -> representa los parametros de entrada
	//	0..N
	//La firma de un metodo consiste en 
	//Nombre del metodo
	//Tipo de parametros
	//Numero de parametros
	//orden de los parametros
	public static String addHola(String frase){
		String s = "Hola " + frase;
		return s;
	}
	
	public static void imprimir(String frase){
		System.out.println("Imprimiendo...");
		System.out.println(frase);
	}
	
	public static void imprimirVariosParametros
						(String frase1,String frase2){
		imprimir(frase1);
		imprimir(frase2);
	}
}