package entidades;

public abstract class Pez extends Animal {
	
	protected TipoAgua tipoAgua;

	@Override
	public void comer(Object comida) {
		
		switch (tamanio) {
		case PEQUENIO:
		case MEDIANO:
			if(comida instanceof Placton){
				System.out.println("Soy el pez " + nombre + " y voy "
						+ "a comer pl"
						+ "ction");
			}else{
				System.out.println("Como pez " + tamanio + 
						" solo como placton");
			}
			break;
		case GRANDE:
			if(comida instanceof Pez){
				Pez pezComida = (Pez)comida;
				System.out.println("Soy el pez " + nombre + " y voy "
						+ " a comerme al pez " + pezComida.nombre);
			}else{
				System.out.println("Como pez " + tamanio + 
						" solo como peces");
			}
			break;
		}
	}

	@Override
	public String toString() {
		return "Pez [tipoAgua=" + tipoAgua + ", peso=" + peso + ", tamanio=" + tamanio + ", nombre=" + nombre + "]";
	}


	
}
