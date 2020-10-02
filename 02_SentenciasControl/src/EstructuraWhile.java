

public class EstructuraWhile {

	public static void main(String[] args) {
		
		boolean esCierto = true;
		int i = 0;
		while(esCierto){//ejecutará entre 0 y N veces
			System.out.println("Iteracion: " + i++);
			if(i == 10){
				esCierto = false;
			}
		}
		
		int j = 0;
		esCierto = true;
		do{//Esto se ejecutara entre 1 y N veces
			System.out.println("Itereacion: " + j++);
			if(j == 10){
				esCierto = false;
			}
		}while(esCierto);
	}

}
