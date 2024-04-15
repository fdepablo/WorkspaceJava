package _08_visibilidades.relaciones;

//import _06_ciclodevida.Persona;

public class MainRelaciones {
	public static void main(String[] args) {
		
		//Los números que empiezan por 0 en java estan en base octal
		//double cp = 054678;
		//System.out.println(cp);
		int hexa = 0x123ABCF;
		int binario = 0b101;
		System.out.println(binario);
		System.out.println(hexa);
		
		//Persona p06 = new Persona();
		//_03_metodos.Persona p03 = new _03_metodos.Persona();
		Persona p1 = new Persona();
		//p1.direccion = "Calle Orense 62 Madrid 28224";
		p1.setNombre("Thor");
		//p1.getDireccion().setCiudad("Madrid");
		//System.out.println(p1.cuentasBancarias.length);
		
		Direccion d1 = new Direccion();
		d1.setCiudad("Madrid");
		
		p1.setDireccion(d1);
		//p1.direccion.ciudad = "Barcelona";
		System.out.println(d1.getCiudad());
		
		CuentaBancaria[] arrayCb1  = new CuentaBancaria[2];
		p1.setCuentasBancarias(arrayCb1);
		System.out.println(p1.getCuentasBancarias().length);
		//System.out.println(p1.cuentasBancarias[0].iban);
		CuentaBancaria cb1 = new CuentaBancaria();
		cb1.setIban("ES9897");
		p1.getCuentasBancarias()[0] = cb1;
		cb1.setSaldo(5000);
		System.out.println(p1.getCuentasBancarias()[0].getSaldo());
		System.out.println(arrayCb1[0].getSaldo());
		
		cb1 = new CuentaBancaria();
		cb1.setIban("SZ56721");
		arrayCb1[1] = cb1;
		
		System.out.println(p1.getCuentasBancarias()[0].getIban());
		System.out.println(p1.getCuentasBancarias()[1].getIban());

		
		
		Persona p2 = new Persona();
		//p2.direccion = "Orense 05789 Plaza de España 78"; 
		p2.setNombre("Ironman");
		//p2 = p1;v
		d1 = new Direccion();
		d1.setCiudad("New York");
		p2.setDireccion(d1);
		//System.out.println(p2.direccion.ciudad.charAt(0));
		//p1 = null;
		p2.getDireccion().setCiudad("Oklahoma");
		System.out.println(d1.getCiudad());
		
		CuentaBancaria cb2 = new CuentaBancaria();
		cb2.setIban("PT56");
		p2.setCuentasBancarias(new CuentaBancaria[2]);
		p2.getCuentasBancarias()[0] = cb2;
		
		cb2 = new CuentaBancaria();
		
		p2.getCuentasBancarias()[1] = cb2;
		cb2.setIban("IT89");
		System.out.println(p2.getCuentasBancarias()[1].getIban());
		System.out.println(p2.getCuentasBancarias()[1]);
		
		System.out.println(p1);
		System.out.println(p2);		
	}
}
