package _08_visibilidades.javabean;

public class MainRelaciones {
	public static void main(String[] args) {
		
		Direccion d1 = new Direccion();
		//d1.tipoVia = "Calle";
		d1.setTipoVia("Calle");
		//d1.nombreVia = "Gran Via";
		d1.setNombreVia("Gran Via");
		d1.setCiudad("Madrid");
		d1.setCp("28224");

		Persona p1 = new Persona();
		p1.setNombre("Alex Capo");
		//p1.direccion = d1;
		p1.setDireccion(d1);

		CuentaBancaria cb1 = new CuentaBancaria();
		cb1.setIban("1234 56 78889898");
		cb1.setSaldo(1500);

		CuentaBancaria cb2 = new CuentaBancaria();
		cb2.setIban("9876 12 78889898");
		cb2.setSaldo(2500);

		CuentaBancaria[] cuentas = new CuentaBancaria[2];
		cuentas[0] = cb1;
		cuentas[1] = cb2;

		p1.setCuentasBancarias(cuentas);
		// dibujo _07_relaciones_01.jpg

		//Para acceder a la información usamos los getters
		System.out.println("-------------------------");
		//System.out.println("Nombre: " + p1.nombre);
		System.out.println("Nombre: " + p1.getNombre());
		
		System.out.println("-------------------------");
		System.out.println("-------------------------");
		//System.out.println("Ciudad: " + p1.direccion.ciudad);
		System.out.println("Ciudad: " + p1.getDireccion().getCiudad());
		System.out.println("Tipo de vía: " + p1.getDireccion().getTipoVia());
		System.out.println("Nombre de vía: " + p1.getDireccion().getNombreVia());
		System.out.println("Código Postal: " + p1.getDireccion().getCp());

		System.out.println("-------------------------");
		
		System.out.println("Cuentas bancarias de la persona:");

		CuentaBancaria[] cuentasPersona = p1.getCuentasBancarias();
		
		for (CuentaBancaria cuenta : cuentasPersona) {
		    System.out.println("IBAN: " + cuenta.getIban());
		    System.out.println("Saldo: " + cuenta.getSaldo());
		}
	}
}
