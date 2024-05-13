package _05_casting;

/**
 * 
 */
public class Alumno extends Persona{
	
	public String curso;
	
	public boolean esCiencias() {
		if(curso.equals("DAM")) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void presentarse() {
		//Como el nombre el "private" solo podemos acceder a el mediante el método
		//accesor o el método modificador
		System.out.println("Hola soy el alumno muñon de nombre : " + this.getNombre());
		//Como el atributo edad es "protected" NO necesitamos el método accesor
		//podemos acceder a el directamente
		System.out.println("y tambien tengo " + this.getEdad());
	}	
}
