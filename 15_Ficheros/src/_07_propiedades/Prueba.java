package _07_propiedades;

public class Prueba {
	public static void main(String[] args) {
		Configuracion conf = new Configuracion();
		conf.inicializar();
		
		String valor = conf.getProperty("propiedad1");
		System.out.println(valor);
		valor = conf.getProperty("usuario");
		System.out.println(valor);
	}
}
