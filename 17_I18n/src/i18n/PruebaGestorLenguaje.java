package i18n;

public class PruebaGestorLenguaje {
	public static void main(String[] string){
		GestorLenguaje gl = GestorLenguaje.getInstance();
		
		System.out.println(gl.getLiteral("aplicacion.saludo.breve"));
		
		GestorLenguaje.getInstance().setIngles();
		
		System.out.println(gl.getLiteral("aplicacion.saludo.breve"));
		
		GestorLenguaje.getInstance().setEspaniol();
		
		System.out.println(gl.getLiteral("aplicacion.saludo.largo"));
		
	}
}
