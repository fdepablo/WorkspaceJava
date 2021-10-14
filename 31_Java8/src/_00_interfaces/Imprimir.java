package _00_interfaces;

//Las interfaces son una coleccion de metodos (hasta antes de la version 1.8 de java)
//abstractos
public interface Imprimir {
	
	//pueden tener atributos, pero son "final"
	public String CONSTANTE = "VALOR";
	
	//Son publicos, aunque no los pongais
	void imprimir(String cadena);
	String getNombreImpresion();
}
