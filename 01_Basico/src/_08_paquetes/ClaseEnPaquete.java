package _08_paquetes;
//Los paquetes en java sirven para agrupar clases.

//La idea es muy similiar a los directorios de un sistema
//de ficheros.

//Podemos tener paquetes dentro de otros paquetes, 
//y van separados por '.'

//Observar como al principio de la clase se pone el nombre
//del paquete al que pertenece con la palabra "package"

//Se considera buena practica poner siempre las clases en 
//paquetes, si no lo hacemos así se pondra en el llamado
//"paquete por defecto". 

public class ClaseEnPaquete {

	public static void main(String[] args) {
		System.out.println("Esta clase esta dentro de un paquete");

	}

}
