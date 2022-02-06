package enums;

public enum TamanioCafe {
	PEQUENIO(5),
	MEDIANO(10),
	GRANDE(20);
	
	private int capacidad;
	
	TamanioCafe(int capacidad){
		this.capacidad = capacidad;
	}
	
	public int getCapacidad(){
		return this.capacidad;
	}
}
