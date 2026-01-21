package array;

//Aquí vamos a ver algunos usos que podemos darle a los arrays
public class _02_UsosArrays {
	public static void main(String[] args) {
		//Queremos guardar los siguientes datos de una persona
		//Nombre, apellidos, telefono, direccion
		String nombre = "Tony";
		String apellido = "Stark";
		String telefono = "+0034663458903";
		String direccion = "Edificio Avenger";
		
		//Podriamos hacerlo con Arrays
		String[] capi = new String[4];
		capi[0] = "Steve";
		capi[1] = "Rogers";
		capi[2] = "+0044789567432";
		capi[3] = "Queens";
		//capi[4] = "pepe";//Se puede escribir pero da error de ejecucción
		
		for(int i = 0;i < capi.length; i++) {//4
			System.out.println(capi[i]);
		}
		
		//Hemos podido ver que uno de los usos es almacenar una colección
		//de variables que podemos recorrer y que tengan relación entre si
		//Nos puede servir también para ordenar información
		
		String[] blackWidow = new String[4];
		blackWidow[0] = "Natasha";
		blackWidow[1] = "Romanoff";
		blackWidow[2] = "+00459876543";
		blackWidow[3] = "Molotov";
		
		
	}
}
