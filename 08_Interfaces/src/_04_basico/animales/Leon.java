package _04_basico.animales;

public class Leon extends Animal {

	//leon.comer(leon)
	@Override
	public void comer(Object o) {
		if(this == o) {
			System.out.println("No me pienso comer a mi mismo :) boludito");
			return;
		}
		
		if(o instanceof Animal) {
			Animal animal = (Animal)o;
			double pesoGanado = animal.getPeso();
			this.setPeso(this.getPeso() + pesoGanado);
			System.out.println("Soy el leon " + this.getNombre() + " y me voy a comer "
					+ " al tipo de animal " + animal.getClass().getSimpleName() + 
					" que se llama " + animal.getNombre());
		}else {
			System.out.println("Soy un leon y solo como animales :) argggg! pirata!");
		}
		
	}

	@Override
	public void moverseLento() {
		double movimiento = 150 - (getPeso() * 0.10);
		System.out.println("Soy un Leon y me muevo " + movimiento);
		
	}

	@Override
	public void moverseRapido() {
		double movimiento = 350 - (getPeso() * 0.10);
		System.out.println("Soy un Leon y me muevo " + movimiento);
		
	}
	
	

}
