package _04_lambdas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

//Interfaces funcionales, vamos a definir una serie de interfaces
//funcionales para los ejemplos lambda ya que una funcion lambda puede
//ser usada para crear una instancia de una interfaz funcional

interface InterfazDosParametros{
	//Para una funcion lambda el nombre del metodo no importa mucho
	//pero si importa cuando queramos ejecutar la funcion lambda
	public Integer operacion(Integer a, Integer b);
}

interface InterfazUnParametro{
	public Integer operacion(Integer a);
}

interface InterfazSinParametros{
	public Integer operacion();
}

interface InterfazSinReturn{
	public void operacion();
}

interface InterfazGenerica <T>{
	public T operacion(T a, T b);
}


public class _01_Lambdas {
	
	public static void main(String[] args) {
		
		//Aqui declaramos clases anonimas, esta seria un ejemplo
		//de una manera clasica
		InterfazDosParametros idum = new InterfazDosParametros() {
			@Override
			public Integer operacion(Integer a, Integer b) {
				return a+b;
			}
		};
	
		InterfazUnParametro usp = new InterfazUnParametro() {
			@Override
			public Integer operacion(Integer a) {
				return a*a;
			}
		};
		
		InterfazSinParametros sp = new InterfazSinParametros() {
			public Integer operacion() {
				return 3000;
			}
		};
		
		//Ahoram utilizamos los objetos creados previamente
		System.out.println("PROBANDO CLASES ANONIMAS");
		System.out.println(idum.operacion(100, 200));
		System.out.println(usp.operacion(25));
		System.out.println(sp.operacion());
		
		System.out.println("=============================================");
		
		//Este seria un ejemplo real con la clase JButton y un 
		//action listener
		JButton boton = new JButton("Insertar");
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Codigo para insertar				
			}
		});
		
		//Para utilizar expresiones lambda NECESITAMOS definir/tener interfaces 
		//funcionales
		//El return viene implicito pero lo podemos poner tambien
		//Tambien podemos observar lo que se conoce como inferencia de tipos,
		//los parametros n1 y n2 no tienen tipo declarado. Java lo hara automaticamente
		//y pondra el mismo tipo que tenemos en la declarado en la interfaz
		//InterfazDosParametros i1    = ( Integer n1, Integer n2 ) -> n1 + n2;
		
		//Esto sería equivalente a la creacion de la clase anonima de más arriba
		//Aqui se invocaría automaticamente el metodo "operacion"
		InterfazDosParametros i1    = ( n1, n2 ) -> n1 + n2;
		InterfazDosParametros i1bis = ( n1, n2 ) -> { return n1 + n2; };
		
		InterfazUnParametro    i2    = n1 -> n1 * n1;
		InterfazUnParametro    i2bis = n1 -> { return n1 * n1; };
		
		//Si no tengo parametros de entrada debemos de poner "()"
		InterfazSinParametros      i3    = () -> 4000;
		InterfazSinParametros      i3Bis = () -> { return 4000; };
				
		InterfazSinReturn i4    = () -> System.out.println("Sin return!");
		//Las expresiones lambda pueden tener varias lineas, pero con varias
		//lineas si la funcion devuelve algun valor, debemos de poner "return"
		InterfazSinReturn i4bis = () -> { 
			//una expresion lambda puede tener variables dentro
			int i = 5;
			i = 7;
			String s = "Mesa";
			s = "silla";
			System.out.println("La variable i vale " + i);
			System.out.println("La variable s vale " + s);
		};
		
		InterfazGenerica<Double> iGenerica = ( n1, n2 ) -> n1 + n2;//sumamos
		InterfazGenerica<String> iGenericaCadena = ( n1, n2 ) -> n1 + n2;//concatener
				
		System.out.println("=============================================");
		System.out.println(i1.operacion(300, 600));
		System.out.println(i1bis.operacion(300, 600));
		System.out.println("=============================================");
		System.out.println(i2.operacion(30));
		System.out.println("=============================================");
		System.out.println(i3.operacion());
		System.out.println("=============================================");
		i4.operacion();
		i4bis.operacion();
		System.out.println("=============================================");
		System.out.println(iGenerica.operacion(34.5, 78.9));
		System.out.println(iGenericaCadena.operacion("hola", " lambda"));
		System.out.println("=============================================");
		
		
		//De igual manera podemos pasar expresiones lambda como argumento
		//de otras funciones
		metodo1(( n1, n2 ) -> n1 + n2);
		metodo1(i1);
		
	}	
	
	public static void metodo1(InterfazDosParametros isp) {
		System.out.println(isp.operacion(9, 10));
	}
}


