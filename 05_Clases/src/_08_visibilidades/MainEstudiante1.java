package _08_visibilidades;

public class MainEstudiante1 {

	public static void main(String[] args) {
		Estudiante e1 = new Estudiante();
		//e1.nombre = "P";
		e1.edad = 45;
		e1.peso = 56.67;
		e1.dni = "456789S";
		e1.setNombre("P");
		System.out.println(e1.getNombre());//null
		e1.setNombre("Pepe");
		System.out.println(e1.getNombre());//pepe

	}

}
