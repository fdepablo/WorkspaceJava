package lambdas._01_interfacesrecargadas;

//En esta clase tenemos un problema ya que ambas interfaces tienen el metodo
//saludar implementado, por lo que si lo dejamos asi dara error en tiempo de 
//compilacion
public class ClaseVariosSaludos implements InterfazSaludoManiana,InterfazSaludoTarde{

	//para arreglar este problema deberemos de sobrescribir el método
	//saludar y darle nuestra propia interpretación
	@Override
	public void saludo() {
		// Podemos decir de esta manera cual queremos usar de los dos
		InterfazSaludoManiana.super.saludo();
	}
}
