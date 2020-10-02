
public class EstructuraFor {
	public static void main(String[] args) {
		//La estructura for sirve para hacer un bucle
		//programatico
		
		//Primero declaramos las variables
		//Segundo decimos la condicion para que se siga
		// ejecutando el bucle
		//Tercero decimos cuanto queremos incrementar el bucle por cada
		//salto
		//Este bucle se ejecutara 10 veces, con valores de i
		//del 0 al 9
		for(int i = 0;i<10;i++){
			System.out.println("Iteracion: " + i);
		}
		
		int i = 0;
		for(i = 0;i<10;i++){
			System.out.println("Iteracion: " + i);
		}
		
		System.out.println("El valor final de i es: " + i);
		
		/* Todas las sentencias son optativas
		for(;;){
			System.out.println("Esto es un bucle infinito");
		}*/
		
		for(int j = 0;j<10;j++){
			if(j == 1){
				System.out.println("Llegamos a 1");
				continue;
			}
			
			if(j == 8){
				System.out.println("Llegamos a 8");
				break;
			}
			System.out.println("El valor es :" + j);
			
		}
	}
}
