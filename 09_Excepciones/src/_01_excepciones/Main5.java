package _01_excepciones;

import java.util.Scanner;

public class Main5 {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Main5 main3 = new Main5();
		boolean continuar = false;
		do{
			try {
				int numero = main3.pedirValor("Numerador");
				System.out.println("numero :" + numero);
				continuar = false;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				continuar = true;
			}
		}while(continuar);
		
		//aunque esta excepcion no haya que capturarla te para el programa igual
		//main3.pedirValorRuntime();
		
		//podriamos hacer aqui tambien un try catch
		//main3.genExcepcion();
		System.out.println("Fin de programa");
		sc.close();
	}
	
	//si la excepcion arrojada es de tipo exception, entonces
	//tenemos que capturarla
	public int pedirValor(String tipo) throws Exception{
		
		int numero = 0;
		try {
			
			System.out.println("Introduzca el " + tipo);
			numero = sc.nextInt();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		
		return numero;
	}
	
	//en caso de que arrojemos RuntimeException
	//no necesitamos capturarla
	public int pedirValorRuntime() throws RuntimeException{
		throw new RuntimeException();
	}
	
	//este metodo no arroja excepciones pero si ocurren
	//se arrojan igualmente
	public void genExcepcion(){
        int nums[]= new int[4];
        System.out.println("Antes de que se genere la excepción.");
        //generar una excepción de índice fuera de límites
        nums[7]=10;
        System.out.println("Esto no se mostrará.");
	}
	
}
