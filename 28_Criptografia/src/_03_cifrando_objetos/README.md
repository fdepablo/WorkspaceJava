# Cifrando Objetos

Si quisieramos cifrar un objeto en java, en principio lo que tendríamos que hacer es cifrar cada uno de sus atributos por separado.

Este proceso puede ser un poco tedioso de hacer, para ello java nos proporciona una clase llamada <b>SealedObject</b>, la cual le tenemos que pasar el objeto que queremos cifrar y un objeto de tipo <b>Cipher</b>. 

Es importante saber que el objeto que queremos cifrar debe de implementar la interfaz <b>Serializable</b>


