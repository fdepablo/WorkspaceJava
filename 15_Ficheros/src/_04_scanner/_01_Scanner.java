package _04_scanner;
import java.util.Scanner;

public class _01_Scanner {
	public static void main(String args[]) {
		String texto = "La cripta    mágica";
		Scanner lector = new Scanner(texto);
		while (lector.hasNext()){
			System.out.println(lector.next());
		}
		lector.close();
	}
}