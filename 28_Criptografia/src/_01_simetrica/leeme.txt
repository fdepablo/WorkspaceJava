En este tipo de sistemas, la clave para encriptar y la clave para desencriptar
es la misma

Si en una aplicación distribuida de tipo cliente/servidor queremos garantizar la seguridad de 
los mensajes, y utilizamos un algoritmo de clave privada para el cifrado y descifrado entre 
origen y destino, nos enfrentamos a los siguientes problemas:

Emisor y receptor necesitan utilizar la misma clave, pero, 
¿cómo la transferimos o distribuimos entre los procesos cliente y servidor?

Se podría almacenar en disco un objeto de tipo SecretKey y dejarlo disponible para su 
lectura en los procesos cliente/servidor. Pero entonces estaríamos utilizando siempre la 
misma clave, que sería más vulnerable a ser interceptada. El fichero podría estar disponible 
para otros procesos ajenos que quieran descifrar nuestros mensajes.

También se podría transmitir la clave a través de la red, igual que se transmiten los 
mensajes, pero de nuevo estaríamos ante un problema de vulnerabilidad, ya que dicha clave 
podría ser interceptada.