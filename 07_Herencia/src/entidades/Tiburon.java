package entidades;

public class Tiburon extends Pez{
	
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
