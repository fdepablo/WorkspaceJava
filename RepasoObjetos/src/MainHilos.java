import java.util.Scanner;

public class MainHilos {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Introduzca el primer número primo: ");
        long primo = teclado.nextInt();        
        CalculoPrimo hiloPrimo = new CalculoPrimo(primo);
        
        System.out.println("Introduzca el segundo número primo: ");
        primo = teclado.nextInt();
        CalculoPrimo hiloPrimo2 = new CalculoPrimo(primo);
        
        System.out.println("Introduzca el tercer número primo: ");
        primo = teclado.nextInt();
        CalculoPrimo hiloPrimo3 = new CalculoPrimo(primo);
        
        
        hiloPrimo.start();
        hiloPrimo2.start();
        hiloPrimo3.start();
    }
    
}
