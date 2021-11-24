# Criptografía

La criptografía es la ciencia que estudia las distintas técnicas que se pueden utilizar para proteger documentos y datos, transformándolos por medio de algún tipo de codificación secreta.

La palabra criptografía proviene de la unión de dos palabras de la lengua griega:
- Kryptos: oculto.
- Graphia: escritura.

Para los sistemas informáticos, la criptografía tiene como objetivo ocultar la información a personas o programas no autorizados, que no sólo podrían leerla, sino incluso manipularla con objeto de modificar su contenido.

## Usos de la criptografía

La criptografía se viene empleando desde tiempos inmemoriales. En las antigua Grecia y Roma ya se creaban criptogramas (mensajes cifrados) para cuestiones diplomáticas, órdenes militares, informes sobre actividades de espionaje o documentos de índole política. A lo largo de la historia el hombre ha inventado varios sistemas criptográficos. Veamos a continuación algunos ejemplos:

### La escítala espartana. 

Fue el primer metodo de encriptación de la historia. La idea consistia en enrollar un papiro en una escítala (una palo con muescas) y escribir un mensaje por una de sus caras. Luego se desenrollaba el papiro y se enviaba a un receptor. Dicho receptor enrollaba el mensaje en una escitala exactamente igual que la primera para poder leer el mensaje.

![Escitala espartana](img/escitala.jfif)

### El método César. 

Se denomina así porque fue utilizado por Julio César. Es muy sencillo: consiste en sustituir cada letra por otra situada varias posiciones más adelante dentro del alfabeto. El número de posiciones es lo que llamamos desplazamiento.

![Metodo Cesar](img/metodo_cesar.png)

### La máquina enigma

La máquina Enigma comenzó a utilizarse en la Segunda Guerra Mundial por los alemanes para cifrar sus mensajes secretos. Con cada tecla pulsada, unos rotores giraban, modificando dicha tecla por otra distinta seleccionada por la máquina a través de diferentes reglas complejas.

![maquina enigma](img/maquina_enigma.jpg)

Fue Alan Turing, un científico británico, quien logro descifrar los códigos alemanes utilizados en la máquina Enigma, contribuyendo así a la derrota nazi.

### HTTPS

Dentro del protocolo HTTP tenemos tambien la versión segura, el cual se cifra la comunicación entre el cliente y el servidor.

## Concepto de encriptacion

La encriptación es el proceso que hace posible la criptografía, es decir, el proceso necesario para volver ilegible dicha información para terceros. Aquí tenemos varios conceptos:

1. <b>Encriptar.</b> Proceso por el cual volvemos ilegible una información. Tambien llamado cifrar.
2. <b>Desencriptar.</b> Proceso de obtener el mensaje original a traves del mensaje encriptado. Tambien llamado descifrar.
3. <b>Criptograma.</b> El mensaje secreto, es decir, el mensaje escrito en clave o cifrado.

Tanto para encriptar como para desencriptar utilizaremos una <b>CLAVE</b> para realizar la transformación.

![cifrar descifrar](img/cifrar_descifrar.png)

## Tipos de clave Criptográfica

Existen dos tipos de claves criptográficas, que son:

- <b>Clave simétrica.</b> Se utiliza la misma llave (o clave) para el cifrado y el descifrado. También se denomina método de clave privada. Este método es el que primero se inventó y ha sido usado durante toda la historia de la humanidad. Como ejemplos podríamos encontrar la escitala espartana, el metodo cesar o la máquina Enigma. Este método, aunque fiable y robusto, representa un grave problema: ¿Cómo transferimos o distribuimos la clave entre el emisor o el receptor? Es aquí donde entra tambien el concepto de <b>canal seguro</b>, que es un canal el cual podemos mandar información sin miedo a que sea interceptada. Este problema lo podemos encontrar tanto si el emisor y el receptor son personas como si nos movemos en un entorno de cliente y servidor.

- <b>Clave asimétrica.</b> Se utiliza una clave para el cifrado y otra distinta para el descifrado. También se conoce como método de clave pública. En este método tenemos dos llaves (o claves), una se conoce como clave pública (A) y la otra se conoce como clave privada (B). La idea básica es que lo que ciframos con la clave pública SOLAMENTE lo podemos descifrar con la clave privada, y lo que ciframos con la clave privada SOLAMENTE lo podemos descifrar con la clave publica. NUNCA lo que ciframos con una clave lo podemos descifrar con la misma (a diferencia de los metodos con clave simétrica). Tenemos dos principales ramas en la criptografía de clave simétrica, en función de si usamos la clave publica o la clave privada para cifrar, estos son: 

    1. <b>Cifrado con clave pública.</b> Un mensaje cifrado con la clave pública de un destinatario no puede ser descifrado por nadie (incluyendo al que lo cifró), excepto un poseedor de la clave privada correspondiente, presumiblemente su propietario y la persona asociada con la clave pública utilizada. Su función es garantizar la confidencialidad del mensaje.

    2. <b>Cifrado con clave privada</b> Un mensaje firmado con la clave privada del remitente puede ser verificado por cualquier persona que tenga acceso a la clave pública de dicho remitente, lo que demuestra que este remitente tenía acceso a la clave privada (y por lo tanto, es probable que sea la persona asociada con la clave privada utilizada). Se utiliza para garantizar la autenticidad del mensaje. Este metodo es usado para las firmas digitales.

Existe un tercer método conocido como <b>Clave mixta</b>,que no es un tipo de criptografía como tal, simplemente es una conbinación de clave simétrica y clave asimética. Un ejemplo sería el protocolo HTTPS. La idea básica es usar la clave asimétrica para intercambiar la clave simetrica.

## Trabajando con la criptografía en Java

Java cuenta con mecanismos para encriptación de información mediante uso de claves. Las clases que permiten desarrollar dichos mecanismos están distribuidas en las siguientes clases Java:
    
- La interfaz <b>java.security.Key</b> representa una clave que puede ser utilizada en la función de cifrado y de descifrado. 

- La interfaz <b>javax.crypto.SecretKey</b> es otra interfaz más concreta que implementa a la interfaz Key.

- La clase <b>javax.crypto.spec.SecretKeySpec</b> es una clase que implementa la interfaz SecretKey.

- La clase <b>javax.crypto.Cipher</b> implementa las funciones de cifrado o descifrado, especificando el tipo de algoritmo utilizado.

## Hash: funciones de resumen

Las funciones de resumen, o funciones hash, disponen de un algoritmo capaz de crear, a partir de una determinada información de longitud variable (entrada), una cadena de longitud fija (salida) que resume dicha información.

Los algoritmos hash garantizan que:

1. La cadena de salida obtenida representa un resumen del mensaje original. A partir de dicho resumen NUNCA se podrá obtener el mensaje original (a diferencia de cuando ciframos, que se puede descifrar). Lo que "hasheamos" no se puede "deshashear".

2. Para la misma información de entrada, se obtendrá <b>SIEMPRE</b> el mismo resumen hash. Esta regla se cumple siempre y cuando se utilice le mismo tipo de algoritmo.

Podemos pasar un algoritmo hash a cualquier información, ya sea un texto, un fichero excel, un fichero .zip, etc.

Además, un resumen hash tiene aplicaciones muy importantes:

1. <b>Comprobar que un archivo no ha sido modificado y garantizar su integridad</b>. Cuando hay que transmitir mucha información a través de la red, dicha información puede transmitirse junto con el resumen y el tipo de algoritmo utilizado. Una vez que la información llega al destino, puede volverse a generar el resumen con el mismo algoritmo y comprobar si ha habido algún cambio durante la transmisión. 

2. <b>Comprobar contraseñas de manera segura</b>. Las contraseás NUNCA se deben guardar encriptadas en base de datos, ya que cuando encriptamos un mensaje lo podemos desencriptar. Por ejemplo, un programador usa una clave para encriptar los passwords de los usuarios, por lo que al tener la clave puede en cualquier momento usar la misma clave para desencriptarlos. Los passwords en base de datos se guardan con el RESUMEN hash, que garantiza que nunca se podrá obtener la información original. La manera de entonces de proceder sería guardar el pasword "hasheado" en base de datos y cada vez que nos mande el usuario su password para autenticarlo sería "hasheando" tambien dicho password y compararlo con el resumen hash del password guardado en base de datos. Recordemos el el algoritmo hash nos garantiza que una misma entrada produce siempre la misma salida.

### Algoritmos Hash:

Podemos encontrar distintos algoritmos hash:

1. <b>MD5</b> (Message-Digest Algorithm 5) es un algoritmo de resumen criptográfico creado por el profesor Ronald Rivest del Instituto Tecnológico de Massachusetts en 1991. Actualmente esta obsoleto ya que genera colisiones. En los algoritmos hash, se denomina colisión a la ocurrencia de dos mensajes de entrada distintos que generan la misma cadena de salida de resumen.

2. <b>SHA</b> (Secure Hash Algorithm), cuya primera versión fue lanzada en 1993 por el Instituto Nacional de Normas y Tecnología de EEUU. Este algoritmo ha ido evolucionando para su mejora según se han ido detectando vulnerabilidades, y dando lugar a diferentes versiones como pueden ser SHA-256, SHA-512 o SH-1024. Es el más utilizados actualmente ya que las versiones más modernas de SHA son consideradas resistentes a las colisiones.e

## Páginas de interes

Pagina para crear resumenes hash a partir de ficheros o cadenas https://hash.online-convert.com/es/generador-sha512

Pagina con base de datos de resumenes hash https://crackstation.net/

## Bibliografía
https://es.wikipedia.org/wiki/Criptografía
https://es.wikipedia.org/wiki/Función_hash
