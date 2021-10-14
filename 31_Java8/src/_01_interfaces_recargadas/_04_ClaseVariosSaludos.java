package _01_interfaces_recargadas;

//En esta clase tenemos un problema ya que ambas interfaces tienen el metodo
//saludar implementado, por lo que si lo dejamos asi dara error en tiempo de 
//compilacion
public class _04_ClaseVariosSaludos implements _01_InterfazSaludoManiana,_03_InterfazSaludoTarde{

	//para arreglar este problema deberemos de sobrescribir el metodo
	//saludar y darle nuestra propia interpretacion
	@Override
	public void saludo() {
		// Podemos decir de esta manera cual queremos usar de los dos
		_01_InterfazSaludoManiana.super.saludo();
		_03_InterfazSaludoTarde.super.saludo();
	}
}
