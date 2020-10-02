package interfaces;

/**
 * Interfaz que hace que los objetos se muevan. Solamente implementada por
 * aquellos objetos que se muevan
 * @author vened
 *
 */
public interface Movible {
	
	//Los atributos en las interfaces son siempre constantes
	//son public y son final
	int CONSTANTE = 0;
	
	/**
	 * Metodo que hace que los objetos se muevan lento
	 */
	public abstract void moverseLento();
	//no importa que no lo declaremos public
	//los metodos de una interface siempre son public
	//y son abstractos
	/**
	 * Metodo que hace que los objetos se muevan rapido
	 */
	void moverseRapido();
}
