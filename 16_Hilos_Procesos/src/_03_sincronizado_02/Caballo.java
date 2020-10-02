package _03_sincronizado_02;

public class Caballo implements Runnable {
	
	private String nombre;
	private Meta meta;	
	
	public Caballo(String nombre, Meta meta){
		super();
		this.nombre = nombre;
		this.meta = meta;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void run(){
		//Simulamos que el caballo esta corriendo
		for(int a = 0; a<=100;a++){
			System.out.println(a+":"+nombre);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//apuntamos al caballo a la meta
		meta.apuntarCaballo(this);
	}
}
