package _01_basico;

/**
 * En java, para heredar una clase de otra se usa la palabra reservada
 * "extends" despues del nombre de la clase, y a continuación el nombre
 * de la clase "Padre"
 * 
 * Para saber si una clase hereda de otra, nos hacemos la preguna "es un" en 
 * caso de que sea afirmativo, heredara. Ej. Un alumno es una persona? Si,
 * por lo tanto Alumno hereda de Persona.
 * 
 */
public class Alumno extends Persona{
	//Automáticamente la clase alumno tiene todos los atributos de la clase
	//Persona (nombre, edad) así como sus métodos (presentarse())
	
	//ojo! no se heredan los constructores
	
	public String curso;
	
	public boolean esCiencias() {
		if(curso.equals("DAM")) {
			return true;
		}else {
			return false;
		}
	}

	/*
	 * Existe un concepto muy importante en la Herencia conocido como
	 * la "sobreescritura" o "Override" de métodos. 
	 * Para sobreescribir un método, debemos de crear un método en la clase
	 * hija con la misma FIRMA que el método padre.	 * 
	 * Cuando sobreescribimos un método queremos darle un comportamiento 
	 * diferente al de la clase Padre
	 * 
	 * La anotación @Override simplemente sive para comprobar que el método
	 * existe en la clase Padre y lo estamos sobreescribiendo. En caso de que
	 * el método no exista en la clase padre daría un error en tiempo de 
	 * compilación
	 */
	@Override
	public void presentarse() {
		System.out.println("Hola soy el alumno muñon de nombre : " + this.nombre);
	}
	
	
	
}
