package entidades;

public class Tiburon extends Pez{
	
	private static final long serialVersionUID = 1L;

	public Tiburon(){
		tamanio = Tamanio.GRANDE;
		tipoAgua = TipoAgua.SALADA;
	}

	public void comer(Object comida) {
		if(comida instanceof Animal){
			Animal comidaAnimal = (Animal)comida;
			System.out.println("Soy el tiburon " + nombre + 
					" y me voy a comer al Animal " 
					+ comidaAnimal.nombre);
		}else{
			System.out.println("Los tiburones solo comemos animales");
		}
	}
	
	
}
