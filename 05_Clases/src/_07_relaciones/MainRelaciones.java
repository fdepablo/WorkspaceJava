package _07_relaciones;

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
		p1.nombre = "Thor";
		//p1.direccion.ciudad = "Madrid";
		//System.out.println(p1.cuentasBancarias.length);
		
		Direccion d1 = new Direccion();
		d1.ciudad = "Madrid";
		p1.direccion = d1;
		p1.direccion.ciudad = "Barcelona";
		System.out.println(d1.ciudad);
		
		CuentaBancaria[] arrayCb1  = new CuentaBancaria[2];
		p1.cuentasBancarias = arrayCb1;
		System.out.println(p1.cuentasBancarias.length);
		//System.out.println(p1.cuentasBancarias[0].iban);
		CuentaBancaria cb1 = new CuentaBancaria();
		cb1.iban = "ES3267890";
		p1.cuentasBancarias[0] = cb1;
		cb1.saldo = 5000;
		System.out.println(p1.cuentasBancarias[0].saldo);
		System.out.println(arrayCb1[0].saldo);
		
		cb1 = new CuentaBancaria();
		cb1.iban = "SZ56721";
		arrayCb1[1] = cb1;
		
		System.out.println(p1.cuentasBancarias[0].iban);
		System.out.println(p1.cuentasBancarias[1].iban);

		
		
		Persona p2 = new Persona();
		//p2.direccion = "Orense 05789 Plaza de España 78"; 
		p2.nombre = "Ironman";
		//p2 = p1;v
		d1 = new Direccion();
		d1.ciudad = "New York";
		p2.direccion = d1;
		//System.out.println(p2.direccion.ciudad.charAt(0));
		//p1 = null;
		p2.direccion.ciudad = "Oklahoma";
		System.out.println(d1.ciudad);
		
		CuentaBancaria cb2 = new CuentaBancaria();
		cb2.iban = "PT56";
		p2.cuentasBancarias = new CuentaBancaria[2];
		p2.cuentasBancarias[0] = cb2;
		
		cb2 = new CuentaBancaria();
		
		p2.cuentasBancarias[1] = cb2;
		cb2.iban = "IT89";
		System.out.println(p2.cuentasBancarias[1].iban);
		System.out.println(p2.cuentasBancarias[1]);
		
		System.out.println(p1);
		System.out.println(p2);
		
	}
}
