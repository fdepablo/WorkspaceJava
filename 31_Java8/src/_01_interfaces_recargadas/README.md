# Interfaces recargadas
Java SE 8 hace un cambio grande a las interfaces con el fin de que las librerias puedan evolucionar sin perder compatibilidad. A partir de esta version, las interfaces pueden proveer metodos con una implementacion por defecto. Las clases que implementen dichas interfaces heredaran automaticamente la implementacion por defecto si estas no proveen una explicitamente:

Llamados metodos por defecto, metodos virtuales o metodos defensores, son especificados e implementados  en  la interface. Usan  la nueva palabra reservada <b>default</b> antes  del tipo  de retorno.

La implementacion por defecto es usada solo cuando la clase implementadora no provee su propia implementacion.

Desde el punto de vista de quien invoca al metodo, es un metodo mas de la interface.
