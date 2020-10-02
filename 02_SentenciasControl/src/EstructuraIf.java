
public class EstructuraIf {

	public static void main(String[] args) {
		
		//if(EXPRESION_BOOLEANA_A_VALORAR){
		// caso true
		//}else{
		// caso false
		//}
		
		boolean esVerde = true;
		if(esVerde){
			System.out.println("La variable es verde");
		}else{
			System.out.println("La variable NO es verde");
		}
		
		int valor = 3;
		if(valor == 0){
			System.out.println("El valor es 0");
		}else if(valor == 1){
			//OJO!, si el valor es 0 ni siquiera comprobariamos
			//este if
			System.out.println("El valor es 1");
		}else if(valor == 2){
			System.out.println("El valor es 2");
		}else{
			System.out.println("El valor es distinto de 0,1,2");
		}
		
		if(valor == 3){
			if(esVerde){
				System.out.println("El valor es 3 y el color es verde");
			}
		}
		//Esto seria equivalente a la de arriba
		if(valor == 3 && esVerde){
			System.out.println("El valor es 3 y el color es verde");
		}
		
		if(valor == 3 || esVerde){
			System.out.println("El valor es 3, o el color es verde o "
					+ "las dos cosas");
		}
		
		//Operador ternario
		// EXPRESION_CONDICIONAL ? CASO_VERDADERO : CASO_FALSO
		boolean esCierto = valor == 3 ? true : false;
		//Equivalente a lo de arriba con if
		if(valor == 3){
			esCierto = true;
		}else{
			esCierto = false;
		}
		
		//switch
		//Seria equivalente a una estructura if-else if-else
		//dentro del switch ponemos la expresion que queremos valorar
		switch (valor) {
		//en los diferentes case ponemos los posibles valores
		//que queremos comprobar
		case 1:
			//podemos poner todas las sentencias que queramos
			//incluido llamadas a funciones etc.
			System.out.println("El valor es 1");
			//al final del case debemos de poner
			//break; ya que sino entraremos tambien
			//en el siguiente case
			break;
		case 2:
			System.out.println("El valor es 2");
			break;
		case 3:
			System.out.println("El valor es 3");
			break;
		default:
			//Entraremos cuando no se cumpla ningun caso anterior
			//equivalente al "else"
			break;
		}
	}

}
