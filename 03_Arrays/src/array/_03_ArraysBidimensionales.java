package array;

public class _03_ArraysBidimensionales {

	public static void main(String[] args) {
		// Los arrays que hemos trabajado anteriormente son también conocidos como 
		// "unidimensionales", por ejemplo podemos guardar el eje de las X.
		
		// Existen también los arrays bidimensionales, para guardar por ejemplo
		// puntos en un eje de coordenadas de X e Y.
		
		int[][] ejeXY = new int[3][3];
		ejeXY[1][1] = 2;
		ejeXY[2][1] = 3;
		ejeXY[0][1] = 4;//Esto da error en tiempo de ejecucción
		
		for(int x = 0; x < ejeXY.length;x++){
			for(int y = 0; y < ejeXY[x].length; y++) {
				System.out.println(ejeXY[x][y]);
			}
		}
		
		String[][] avengers = new String[3][4];
		//Podriamos hacerlo con Arrays
		avengers[0][0] = "Steve";
		avengers[0][1] = "Rogers";
		avengers[0][2] = "+0044789567432";
		avengers[0][3] = "Queens";
		
		avengers[1][0] = "Natasha";
		avengers[1][1] = "Romanoff";
		avengers[1][2] = "+004633434444";
		avengers[1][3] = "Molotov";
		
		avengers[2][0] = "Bruce";
		avengers[2][1] = "Baner";
		avengers[2][2] = "+00558737373";
		avengers[2][3] = "Manhattan";
		
		for(int x = 0; x < avengers.length;x++){
			System.out.println("----- DATOS DEL AVENGER " + (x+1) + " --------------");
			for(int y = 0; y < avengers[x].length; y++) {
				System.out.print(avengers[x][y] + " - ");
			}
			System.out.println();
		}
	}

}
