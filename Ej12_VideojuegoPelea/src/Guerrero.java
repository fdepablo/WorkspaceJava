
public class Guerrero extends Personaje{
	
	public void atacar() {
		System.out.println("Soy el guerrero " + getNombre() + ".. ARGGGGGGG!!!!");
		getArma().usar();
	}

	
	
}
