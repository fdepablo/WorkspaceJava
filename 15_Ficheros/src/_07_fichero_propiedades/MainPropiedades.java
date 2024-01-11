package _07_fichero_propiedades;

/*
 * Los ficheros de propiedades son muy utiles en las aplicaciones y suelen servir para
 * establecer parametros de arranque de nuestras aplicaciones (o para lo que se quiera)
 */
public class MainPropiedades {
	public static void main(String[] args) {
		Configuracion conf = new Configuracion();
		conf.inicializar();
		
		String valor = conf.getProperty("propiedad1");
		System.out.println(valor);
		valor = conf.getProperty("propiedad2");
		System.out.println(valor);
		valor = conf.getProperty("usuario");
		System.out.println(valor);
		String pass = conf.getProperty("password");
		
		//Mejor evitar poner:
		//if(valor.equals("Felix") && pass.equals("1234"))
		//ya que si valor es 'null' daría un "NullPointerException"
		//En cambio si lo hacemos de la siguiente manera, evitamos
		//los "NullPointerException" ya que un literal NUNCA será
		//"null"
		if("Felix".equals(valor) && "1234".equals(pass)){
			System.out.println("Bienvendos a nuestra app!");
		}else {
			System.out.println("Usted no puede entrar :(");
		}
	}
}
