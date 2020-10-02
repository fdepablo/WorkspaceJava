package i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class PruebaI18n {
	public static void main(String[] args){
		ResourceBundle rb = ResourceBundle.getBundle("language");
		
		System.out.println(rb.getString("aplicacion.saludo.breve"));
		System.out.println(rb.getString("aplicacion.saludo.largo"));
		
		rb = ResourceBundle.getBundle("language",new Locale("en","EN"));
		
		System.out.println(rb.getString("aplicacion.saludo.breve"));
		System.out.println(rb.getString("aplicacion.saludo.largo"));
		
		Locale locale = Locale.getDefault();
		System.out.println(locale);
	}
}
