package _06_abstracciones;

public class Tiburon extends Pez{

	@Override
	public void comer(Object o) {
		// super es una referencia a la clase padre
		//super.comer(o);//invocando el comer del Pez
		//if(o instanceof Trucha || o instanceof Tiburon)//NO
		if(o instanceof Pez) {
			Pez pez = (Pez)o;
			double pesoGanado = pez.getPeso() * 0.30;//Aquí SI aplicamos polimorfismo
			this.setPeso(this.getPeso() + pesoGanado);
			System.out.println("Soy el tiburon " + this.getNombre() + " y me voy a " +
				" comer al pez " + pez.getNombre());
		}else {
			System.out.println("Soy un tiburón y solo como peces :(");
		}
	}

}
