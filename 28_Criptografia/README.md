
Clave simétrica: se utiliza la misma clave para el cifrado y el descifrado. 
También se denomina método de clave privada.

Clave asimétrica: se utiliza una clave para el cifrado y otra distinta para el descifrado. 
También se conoce como método de clave pública.
    
La interfaz java.security.Key: 
representa una clave que puede ser utilizada en la función de cifrado y de descifrado. 

La interfaz javax.crypto.SecretKey: 
otra interfaz más concreta que implementa a la interfaz Key.

La clase javax.crypto.spec.SecretKeySpec: 
clase que implementa la interfaz SecretKey.

La clase javax.crypto.Cipher: 
implementa las funciones de cifrado o descifrado, especificando el tipo de algoritmo utilizado.

Pagina para crear resumenes hash a partir de ficheros o cadenas
https://hash.online-convert.com/es/generador-sha512

Pagina con base de datos de resumenes hash
https://crackstation.net/