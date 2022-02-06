package i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class GestorLenguaje {
	
	private static GestorLenguaje instance = null;
	ResourceBundle rb;
	public static final String NOMBRE_BASE = "language";
	
	private GestorLenguaje(){
		super();
		rb = ResourceBundle.getBundle(NOMBRE_BASE);
	}
	
	public static GestorLenguaje getInstance(){
		if(instance == null){
			instance = new GestorLenguaje();
		}
		return instance;
	}
	
	public String getLiteral(String literal){
		return rb.getString(literal);
	}
	
	public void setEspaniol(){
		rb = ResourceBundle.getBundle(NOMBRE_BASE,new Locale("es","ES"));
	}
	
	public void setIngles(){
		rb = ResourceBundle.getBundle(NOMBRE_BASE,new Locale("en","EN"));
	}
	
	public void setLocale(Locale locale){
		rb = ResourceBundle.getBundle(NOMBRE_BASE,locale);
	}
}
