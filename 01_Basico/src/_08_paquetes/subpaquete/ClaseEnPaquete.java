package _08_paquetes.subpaquete;

//Podemos tener paquetes dentro de paquetes, de hecho es muy habitual

//Dentro de un paquete en Java NO podemos tener dos clases con el mismo
//nombre
//Si queremos tener dos clases con el mismo nombre tienen que estar 
//obligatoriamente en dos paquetes diferentes. 

public class ClaseEnPaquete {
	public static void main(String[] args) {
		System.out.println("Esta clase se llama igual que la del paquete superior");
		//Para saber el nombre completo de una clase
		System.out.println(ClaseEnPaquete.class.getName());
	}
}
