package _01_basico;

/**
 * En java, para heredar una clase de otra se usa la palabra reservada
 * "extends" despues del nombre de la clase, y a continuación el nombre
 * de la clase "Padre"
 */
public class Docente extends Persona {
	//Automáticamente la clase Docente tiene todos los atributos de la clase
	//Persona (nombre, edad) así como sus métodos (presentarse())
	
	public double salario;
	
	public double calcularSalarioNeto() {
		double salarioNeto = salario * 0.85;
		return salarioNeto;
	}
}
