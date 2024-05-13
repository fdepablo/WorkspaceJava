package _04_basico.vehiculos;

public class Moto extends VehiculoTerrestre{

	@Override
	public void moverseLento() {
		double movimiento = 300 - (getPeso() * 0.10);
		System.out.println("Soy una Moto y me muevo " + movimiento);
		
	}

	@Override
	public void moverseRapido() {
		double movimiento = 400 - (getPeso() * 0.10);
		System.out.println("Soy un Moto y me muevo " + movimiento);
		
	}

}
