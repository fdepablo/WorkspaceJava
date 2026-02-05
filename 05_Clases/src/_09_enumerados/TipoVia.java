package _09_enumerados;

//Los enumerados son un tipo especial de clase en la cual
//todos sus objetos están predefinidos al arrancar el programa.

//Es la única manera oficial en java de hacer los objetos
//NOMINATIVOS, es decir, los objetos tendran un nombre.

//NO se pueden crear más objetos que los que predefinamos,
//es decir, no podemos hacer NEW en tiempo de ejecución

//Los objetos aquí se definen justo dentro de la clase
//y se debe utilizar la notación UPPER_SNAKE_CASE.

//Además, los objetos irán separados por ","

//Estos objetos estan numerados dentro de una array

//Se crean como una clase, pero en vez de poner "class" se
//pone "enum"
public enum TipoVia {
	CALLE,AVENIDA,PLAZA,CAÑADA_REAL
	//CALLE será la posicion 0 del array
	//AVENIDA será la posición 1 del array
	//...
}
