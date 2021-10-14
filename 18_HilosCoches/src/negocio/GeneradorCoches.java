package negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import entidad.Coche;

public class GeneradorCoches {
	
	public Coche generarCoche() {
		Coche coche = new Coche();
		coche.setMarca(generarMarca());
		coche.setModelo(generarModelo());
		coche.setKm(generarKm());
		coche.setMatricula(generarMatricula());
		return coche;
	}
	
	public String generarMarca() {
		List<String> listaNombres = new ArrayList<String>();
		listaNombres.add("Ferrari");
		listaNombres.add("BMW");
		listaNombres.add("Opel");
		listaNombres.add("Renault");
		listaNombres.add("Tesla");
		listaNombres.add("Señorita Pepis");
		
		int numero = ThreadLocalRandom.current().nextInt(0, 6);
		
		return listaNombres.get(numero);
	}
	
	public String generarModelo() {
		List<String> listaNombres = new ArrayList<String>();
		listaNombres.add("Soltero de oro");
		listaNombres.add("Recoge Cervezas");
		listaNombres.add("Casado de por vida");
		listaNombres.add("Arrebaña bateres");
		listaNombres.add("Chiquito de la calzada");
		
		int numero = ThreadLocalRandom.current().nextInt(0, 5);
		
		return listaNombres.get(numero);
	}
	
	public int generarKm() {
		int numero = ThreadLocalRandom.current().nextInt(0, 10000);
		return numero;
	}
	
	public String generarMatricula() {
		int numero = ThreadLocalRandom.current().nextInt(0, 10000);
		String matricula = "M" + numero;
		return matricula;
	}
}
