package lambdas._03_interfaces_funcionales;

/*
 * Interfaces funcionales
Concepto nuevo en Java SE 8 y que es la base para que podamos escribir expresiones 
lambda. Una interface funcional se define como una interface que tiene uno y solo 
un metodo abstracto y que este sea diferente a los metodos definidos en 
java.lang.Object (a saber: equals, hashcode, clone, etc.). 
La interface puede tener metodos por defecto y estaticos sin que esto afecte su 
condicion de ser interface funcional.

Existe una nueva anotacion denominada @FunctionalInterface que permite al compilador 
realizar la validacion de que la interface tenga solamente un metodo abstracto. 
 */
@FunctionalInterface 
public interface InterfazFuncional {
	void metodoAbstracto();
	//Si tuvieramos otro metodo daria error porque no corresponderia a interfaz
	//funcional
	//void otroMetodoAbstracto();
}
