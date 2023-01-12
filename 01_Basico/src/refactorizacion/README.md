# Refactorización

El concepto de refactorización (refactoring) de código se asocia al proceso de alteración de ciertos aspectos del código, de forma que se reestructura y cambia sin alterar su funcionalidad.

Muchos entornos de desarrollo IDE proporcionan soporte automatizado para la refactorización. Si logramos hacer bien la refactorización del código también se pueden resolver errores ocultos y vulnerabilidades en el sistema mediante la simplificación de la lógica y la eliminación de niveles innecesarios de complejidad.

Si se hace mal, puede fallar el requisito de que la funcionalidad externa no se puede cambiar, y/o introducir nuevos errores.

Algunas de las técnicas más comunes desarrolladas en los IDE serían:

1. <b>Mejora de nombres y ubicación de código</b>, como pueden ser:
    - Mover un campo o un método
    - Cambiar el nombre de método o cambiar el nombre de campo
2. <b>Bloques de código más lógicos</b>
    - Extraer de una clase parte del código en otra una clase.
    - Extraer un método. Partir en varios métodos uno que sea muy largo. Al trocear el código en trozos más pequeños es más fácil de comprender.

## Opciones de refactorización

Los IDE como Eclipse tienen implantadas las opciones de refactorización más utilizadas. A continuación describimos algunas de ellas. 

1. <b>Move</b>, Esta opción permite mover el objeto hacia otros ámbitos dentro del mismo. Si seleccionamos una clase nos ofrecerá cambiar de paquete y cambiará las referencias a esa clase desde las otras.
2. <b>Copy</b>, Esta opción permite copiar la clase a otro paquete del proyecto.
3. <b>Rename</b>, Esta opción permite cambiar el nombre a cualquier elemento de nuestro código, tanto campos, variables, métodos, clases, paquetes, ficheros, etc.
4. <b>Extract local variable</b>, cuando queremos extraer valores a variables locales.
5. <b>Change Method Signature</b>, Esta opción permite cambiar toda la firma de un método, como el nombre, los parametros de entrada y salida, etc.
6. <b>Extract method</b>, podemos hacer que un determinado código lo extraigamos a un método a parte para facilitar su legibilidad.
7. <b>Extract interface</b>, La refactorización extract interface permite seleccionar métodos públicos no estáticos y moverlos a una interfaz independiente. Esto puede hacer que el código sea más legible y fácil de mantener.
8. <b>Extract superclass</b>, Esta refactorización funciona exactamente de la misma manera que la refactorización extract interface. Sin embargo, esta opción mueve los métodos a una nueva superclase y extiende la clase refactorizada (aquella de la que se retiraron los métodos).

En eclipse todas las opciones de refactorización están en <b>refactor</b>, que se puede acceder pulsando botón derecho del ratón sobre el código que queramos refactorizar.

## Bibliografía

- [https://www.baeldung.com/eclipse-refactoring](https://www.baeldung.com/eclipse-refactoring)
- [https://dzone.com/articles/java-eclipse-code-refactoring-shortcuts-and-tips](https://dzone.com/articles/java-eclipse-code-refactoring-shortcuts-and-tips)
