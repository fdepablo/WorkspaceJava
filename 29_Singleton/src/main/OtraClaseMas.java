package main;

import negocio.CochesSingleton;

public class OtraClaseMas {

	public void otroMetodoMas(Object referencia) {
		System.out.println("HAgo muchas cosas....");
		//tambien tengo que invocar el toString() de objeto super importante
		CochesSingleton cs = CochesSingleton.getInstance();
		System.out.println(cs.getListaCoches());
	}
}
