import java.util.ArrayList;
import java.util.List;

public class MainVideojuego {

	public static void main(String[] args) {
		
		
		Personaje g1 = FabricaPersonajes.crear("guerrero");
		g1.setNombre("Conan");
		g1.setVida(200);
		
		//Gracias a usar abstraciones y patrones (fabrica)
		//podemos crear objetos diferentes en tiempo de ejecucion
		Arma espada = FabricaArmas.crear("espada");
		espada.setDanioMinimo(10);
		espada.setDanioMax(25);
		espada.setTipo("Espada Bastarda");
		g1.setArma(espada);
		
		Personaje m1 = FabricaPersonajes.crear("mago");
		m1.setNombre("Gandalf");
		m1.setVida(200);
		
		Arma hechizo = FabricaArmas.crear("hechizoFuego");
		hechizo.setDanioMinimo(10);
		hechizo.setDanioMax(20);
		hechizo.setTipo("Fuego");
		m1.setArma(hechizo);
		
		//Partida partida = new Partida(g1, m1);
		//partida.empezar();	
		
		Personaje e1 = FabricaPersonajes.crear("enano");
		e1.setNombre("Gimli");
		e1.setVida(250);
		
		Arma arco = FabricaArmas.crear("arco");
		arco.setDanioMinimo(5);
		arco.setDanioMax(35);
		arco.setTipo("Arco Compuesto");
		e1.setArma(arco);
		
		List<Personaje> listaLuchadores = new ArrayList<Personaje>();
		listaLuchadores.add(g1);
		listaLuchadores.add(m1);
		listaLuchadores.add(e1);
		
		Coliseo coliseo = new Coliseo(listaLuchadores);
		coliseo.empezar();
	}

}
