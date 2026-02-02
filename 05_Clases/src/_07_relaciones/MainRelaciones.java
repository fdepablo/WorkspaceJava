package _07_relaciones;

//import _06_ciclodevida.Persona;

public class MainRelaciones {
	public static void main(String[] args) {
		
		Direccion d1 = new Direccion();
		d1.tipoVia = "Calle";
		d1.nombreVia = "Gran Via";
		d1.ciudad = "Madrid";
		d1.cp = "28224";
		
		Persona p1 = new Persona();
		p1.nombre = "Alex Capo";
		
		p1.direccion = d1;
		
		CuentaBancaria cb1 = new CuentaBancaria();
		cb1.iban = "1234 56 78889898";
		cb1.saldo = 1500;
		
		CuentaBancaria cb2 = new CuentaBancaria();
		cb2.iban = "9876 12 78889898";
		cb2.saldo = 2500;
		
		CuentaBancaria[] cuentas = new CuentaBancaria[2];
		cuentas[0] = cb1;
		cuentas[1] = cb2;
		
		p1.cuentasBancarias = cuentas;
		//dibujo _07_relaciones_01.jpg
		
		//Pregunta 1
		//cb1.saldo = 3000;
		//System.out.println(p1.cuentasBancarias[0].saldo);
		
		//Pregunta 2
		//p1.cuentasBancarias[1].saldo = 4000;
		//System.out.println(cb2.saldo);
		
		//Pregunta 3
		//cb2 = null;
		//p1.cuentasBancarias[0] = null;
	}
}
