# Funciones Lambda
Las funciones lambdas es un término adoptado de la programación funcional y corresponden con funciones de Java que normalmente son anónimas y se escriben en línea allí donde se usan. Como cualquier función recibe cero o más argumentos y devuelven uno o ningún valor de retorno. Como cualquier función, puede consumir métodos de otras clases y objetos. Al declararse al mismo tiempo en donde se usa, puede acceder a las variables locales del ámbito al que pertenece, pero sólo podrá usar estos como valores de sólo lectura, impidiendo realizar alguna modificación.

Las funciones lambdas se crearon a partir de la versión Java 8, por lo que no es posible usar su sintaxis en versiones anteriores. Sus entidades principales están contenidas en el package java.util.funcional. Sí hay que decir, que no aportan una funcionalidad que no pueda hacerse con Java pre 8, simplemente es una manera más compacta de escribir código Java. Se puede decir de manera resumida que una función lambda es como una clase con un único método público. Así que los que no dispongan de Java 8 podrían simular un comportamiento similar creando clases parecidas a las proporcionadas con el API de Java en el package java.util.functional.


## Sintaxis
Una expresion lambda se compone de:
   
1. Listado de parametros separados por comas y encerrados en parentesis: <b>(int a, int b)</b>
2. El simbolo de flecha hacia la derecha: <b>-></b>
3. Un cuerpo que puede ser un bloque de codigo encerrado entre llaves o una sola expresion: <b>	a + b</b>
	
	Ej: (a, b) ­>  a + b


 	