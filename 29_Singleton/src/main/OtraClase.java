package main;

import negocio.CochesSingleton;

public class OtraClase {
	
	public void otroMetodo(Object referencia) {
		referencia.toString();
		OtraClaseMas otraClaseMas = new OtraClaseMas();
		otraClaseMas.otroMetodoMas(referencia);
		CochesSingleton cs = CochesSingleton.getInstance();
		System.out.println(cs.getListaCoches());
	}
}
