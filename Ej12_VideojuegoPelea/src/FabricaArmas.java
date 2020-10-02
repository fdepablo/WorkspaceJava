
//El patron fabrica busca centralizar la creacion (new) de
//los objetos de un mismo tipo en una sola clase
//De tal manera que sea esta la que tenga todas
//las dependencias fuertes con las otras clases
public class FabricaArmas {

	public static Arma crear(String tipo) {
		Arma arma = null;
		switch (tipo) {
		case "espada":
			arma = new Espada();
			break;
		case "arco":
			arma = new Arco();
			break;
		case "hechizoFuego":
			arma = new HechizoFuego();
			break;
		default:
			break;
		}
		
		return arma;
	}
}
