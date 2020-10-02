package _02_personalizadas;

//Excepción personalizada.
//Si extendemos de Exception son excepciones Checked
//Si extendemos de RuntimeException son excepciones unchecked
public class SaldoNegativoException extends Exception {

	private static final long serialVersionUID = 1L;

	// Constructor vacío
	public SaldoNegativoException() {
		super();
	}

	// Constructor con mensaje de error
	public SaldoNegativoException(String mensajeError) {
		super(mensajeError);
	}

	//Este metodo nos puede ayudar a encontrar el error de manera mas facil
	//el mensaje puede ser el que queramos, pero esto nos puede decir
	//el origen. Si no lo sobreescribimos se comporta igual que getMensaje()
	@Override
	public String getLocalizedMessage() {
		return "Excepcion de saldo negativo";
	}
	
	
}
