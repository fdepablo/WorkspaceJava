# Entidades funcionales
Concepto nuevo en Java SE 8 y que es la base para que podamos escribir expresiones lambda. Una interface funcional se define como una interface que tiene uno y solo un metodo abstracto y que este sea diferente a los metodos definidos en java.lang.Object (a saber: equals, hashcode, clone, etc.). 
La interface puede tener metodos por defecto y estaticos sin que esto afecte su condicion de ser interface funcional.

Existe una nueva anotacion denominada @FunctionalInterface que permite al compilador realizar la validacion de que la interface tenga solamente un metodo abstracto. 

## Entidades de java.util.functional
Antes de crear una función de tipo lambda, conviene conocer las entidades básicas que componen esta manera de programar. Las principales entidades son interfaces con un único método que debe implementar el programador y que estas implementaciones pueden hacerse llegar como argumentos de métodos de otras muchas clases del API de Java. Hubo una gran modificación de las clases existentes para aceptar este tipo de implementaciones allí donde tuviera sentido, como ocurre en las colecciones.

Las implementaciones de estas interfaces son del tipo, consume un valor y retorna otro tipo de valor, o produce un valor sin argumentos o produce un valor dados dos argumentos. A éstas se les llama unidades funcionales porque componen una lógica interna que a priori el consumidor de esta lógica no conoce, pero de la que sí se conoce su interfaz y por tanto la manera de relacionarse con el resto de los objetos, o lo que es lo mismo la manera de ser invocada. Aparece de nuevo el concepto de cajas negras en donde entran parámetros y salen resultados.

Las interfaces funcionales más importantes contenidas en java.util.functional son:

1. <b>Supplier<T>:</b> esta función se debe utilizar cuando se necesiten generar objetos sin requerir argumentos. El metodo asociado de la interfaz sería get().
2. <b>Consumer<T>:</b> esta en cambio es el opuesto de Supplier ya que consume, acepta como argumento el tipo T sin devolver ningún valor de retorno. El metodo asociado de la interfaz sería accept().
3. <b>Function<T,R>:</b> esta interfaz permite definir una función que acepta un parámetro de tipo T y devuelve un resultado del tipo R pudiendo aplicarle alguna transformación u operación. El metodo asociado de la interfaz sería apply().
4. <b>BiFunction<T,R,S>:</b> esta interfaz permite definir una función que acepta dos parámetros de tipo T y R, devolviendo un resultado del tipo S. Normalmente serán operaciones de agregación u operadores binarios como la suma, resta, etc. El metodo asociado de la interfaz sería apply().
5. <b>Predicate<T>:</b> la interfaz predicado debe devolver forzosamente un boolean dado un objeto de tipo T, normalmente utilizado para filtrar elementos de una colección. El metodo asociado de la interfaz sería test().

