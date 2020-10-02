package entidad;

//con las interface decimos que comportamiento tienen que tener las clases
//Estamos firmando un contrato por el cual nos obligamos a que la clase
//que implementa la interfaz TENGA LA OBLIGACION de implementar dichos metodos
public interface Movible {
	public void  moverseLento();
	public void  moverseRapido();
}
