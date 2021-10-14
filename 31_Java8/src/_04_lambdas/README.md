# Funciones Lambda
Las funciones lambdas(a veces tambien llamadas "closures") es un término adoptado de la programación funcional y corresponden con funciones de Java que normalmente son anónimas y se escriben en línea allí donde se usan. Como cualquier función recibe cero o más argumentos y devuelven uno o ningún valor de retorno. Como cualquier función, puede consumir métodos de otras clases y objetos. Al declararse al mismo tiempo en donde se usan, puede acceder a las variables locales del ámbito al que pertenece, pero sólo podrá usar estos como valores de sólo lectura, impidiendo realizar alguna modificación.

Las funciones lambdas se crearon a partir de la versión Java 8, por lo que no es posible usar su sintaxis en versiones anteriores. Sus entidades principales están contenidas en el package java.util.funcional. Sí hay que decir, que no aportan una funcionalidad que no pueda hacerse con Java pre 8, simplemente es una manera más compacta de escribir código Java. Se puede decir de manera resumida que una función lambda es como una clase con un único método público. Así que los que no dispongan de Java 8 podrían simular un comportamiento similar creando clases parecidas a las proporcionadas con el API de Java en el package java.util.functional. Es decir, podemos simular las funciones lambda, creado una clase anonima a partir de una interfaz funcional, o que solo tenga un metodo abstracto.


## Sintaxis
Una expresion lambda se compone de:
   
1. Listado de parametros separados por comas y encerrados en parentesis: <b>(int a, int b)</b>
2. El simbolo de flecha hacia la derecha: <b>-></b>
3. Un cuerpo que puede ser un bloque de codigo encerrado entre llaves o una sola expresion: <b>	a + b</b>
	
	Ej: (a, b) ->  a + b

## Entidades de java.util.functional
Antes de crear una función de tipo lambda, conviene conocer las entidades básicas que componen esta manera de programar. Las principales entidades son interfaces con un único método que debe implementar el programador y que estas implementaciones pueden hacerse llegar como argumentos de métodos de otras muchas clases del API de Java. Hubo una gran modificación de las clases existentes para aceptar este tipo de implementaciones allí donde tuviera sentido, como ocurre en las colecciones.

Las implementaciones de estas interfaces son del tipo, consume un valor y retorna otro tipo de valor, o produce un valor sin argumentos o produce un valor dados dos argumentos. A éstas se les llama unidades funcionales porque componen una lógica interna que a priori el consumidor de esta lógica no conoce, pero de la que sí se conoce su interfaz y por tanto la manera de relacionarse con el resto de los objetos, o lo que es lo mismo la manera de ser invocada. Aparece de nuevo el concepto de cajas negras en donde entran parámetros y salen resultados.

Las interfaces funcionales que nos proporciona java son parametrizables, es decir, los argumentos de entrada y de salida los podemos elegir nostros (el ejemplo más claro sobre clase parametrizable puede ser la clase ArrayList). Las interfaces funcionales más importantes contenidas en java.util.functional son:

1. <b>Supplier<T>:</b> No tenemos parametros de entrada pero si tenemos un parametro de salida. Esta función se debe utilizar cuando se necesiten generar objetos sin requerir argumentos. El metodo asociado de la interfaz sería get(). 
2. <b>Consumer<T>:</b> Tenemos un parametro de entrada pero no tenemos parametro de salida. Esta en cambio es el opuesto de Supplier ya que consume, acepta como argumento el tipo T sin devolver ningún valor de retorno. El metodo asociado de la interfaz sería accept().
3. <b>Function<T,R>:</b> Esta interfaz permite definir una función que acepta un parámetro de tipo T y devuelve un resultado del tipo R, pudiendo aplicarle alguna transformación u operación. El metodo asociado de la interfaz sería apply().
4. <b>BiFunction<T,R,S>:</b> esta interfaz permite definir una función que acepta dos parámetros de tipo T y R, devolviendo un resultado del tipo S. Normalmente serán operaciones de agregación u operadores binarios como la suma, resta, etc. El metodo asociado de la interfaz sería apply().
5. <b>Predicate<T>:</b> La interfaz predicado debe devolver forzosamente un boolean dado un objeto de tipo T, normalmente utilizado para filtrar elementos de una colección. El metodo asociado de la interfaz sería test().



 	