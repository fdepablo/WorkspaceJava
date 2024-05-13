package _01_basico;

public class MainInstituto {

	public static void main(String[] args) {
		Persona p1 = new Persona();
		p1.nombre = "Goku";
		p1.edad = 40;
		p1.presentarse();
		//p1.salario = 45000;
		
		Alumno a1 = new Alumno();
		a1.nombre = "Felipe";
		a1.edad = 23;
		a1.presentarse();
		a1.curso = "DAM";
		System.out.println(a1.esCiencias());
		
		Docente d1 = new Docente();
		d1.nombre = "Antonio";
		d1.edad = 98;
		d1.presentarse();
		d1.salario = 50000;
		System.out.println(d1.calcularSalarioNeto());
		

	}

}
