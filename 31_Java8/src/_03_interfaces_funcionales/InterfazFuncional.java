package _03_interfaces_funcionales;

@FunctionalInterface 
public interface InterfazFuncional {
	void metodoAbstracto();
	//Si tuvieramos otro metodo daria error porque no corresponderia a interfaz
	//funcional
	//void otroMetodoAbstracto();
	
	//Podemos tener todas los metodos implementados que queramos
	default void metodoNoAbstracto() {
		System.out.println("Este metodo esta implementado");
	}
}
