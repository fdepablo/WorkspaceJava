package _01_condicionales;

public class _04_IF_02 {

	public static void main(String[] args) {
		//Es muy habitual cuando trabajamos con sentencias de control, el ANIDAR
		//bloques. Se llama ANIDAR cuando ponemos sentencias de control DENTRO
		//de otras sentencias de control.
		
		//Ejemplo
		
		int numero1 = 5;
		int numero2 = 10;
		if(numero1 == 5) {
			System.out.println("El número1 es igual a " + numero1);
			//Puedo anidar para dar funcionalidad
			//es decir, poner un 'if' dentro de otro 'if'
			if(numero2 == 10) {
				System.out.println("El numero2 es igual a" + numero2);
			}
		}
		
		//Ojo que esto no es totalmente equivalente
		if(numero1 == 5 && numero2 == 10) {
			System.out.println("El número1 es igual a " + numero1);
			System.out.println("El numero2 es igual a" + numero2);
		}
		
		int numero3 = 12;
		int numero4 = 16;
		
		if(numero1 == 5) {
			System.out.println("El número1 es igual a " + numero1);
			//Puedo anidar para dar funcionalidad
			//es decir, poner un 'if' dentro de otro 'if'
			if(numero2 == 10) {
				System.out.println("El numero2 es igual a" + numero2);
				if(numero3 == 12) {
					System.out.println("El numero3 es igual a" + numero3);
					if(numero4 == 16) {
						System.out.println("El numero4 es igual a" + numero4);
					}
				}
			}
		}
		
		//Ejemplo muy complejo de anidación... Normalmente hay que dividirlo
		//en funciones
		switch (numero1) {
		case 5:
			switch (numero2) {
			case 10:
				switch (numero3) {
				case 13:
					
					break;

				default:
					break;
				}
				break;

			default:
				break;
			}
			break;
		case 4:
			if(numero4 == 56) {
				
			}else {
				
			}
		default:
			break;
		}		
	}
}
