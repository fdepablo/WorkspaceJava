import entidades.Animal;
import entidades.Oso;
import entidades.TipoOso;

public class Main {

	//Hemos generado el jar de el ejemplo de herencia
	//y lo hemos importado aquí para su uso
	public static void main(String[] args) {
		Animal animal = new Oso(TipoOso.AMOROSO);

	}

}
