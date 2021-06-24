package programa;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona p = new Persona();
		new Persona("Steve Roger",34,0);
		
		p.setPosicion(30);
		
		p.caminar(50);
		
		System.out.println(p.getPosicion());
	}

}
