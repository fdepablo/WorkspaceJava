package es.repaso;

//Los objetos de esta clase son INMUTABLES
public class PersonaInmutable extends Persona{
	//Como hemos creado un constructor, java no crea el constructor por defecto
	public PersonaInmutable(String nombre) {
		super(nombre);
	}
	
	public String getNombre() {
		return super.getNombre();
	}
}
