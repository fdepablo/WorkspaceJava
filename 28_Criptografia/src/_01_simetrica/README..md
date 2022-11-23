# Clave simétrica en Java

En este tipo de sistemas la clave para encriptar y la clave para desencriptar es la misma.

Podemos encontrar muchos tipos de algoritmos, vamos a trabajar con dos, DES y AES.

## Algoritmo DES (Data Encryption Standard)

DES (Data Encryption Standard) es un algoritmo de cifrado simétrico que fue acogido por los Estados Unidos en 1976 y siguió utilizándose hasta 1999.

Características del algoritmo DES.

1. El algoritmo DES divide el mensaje original en bloques de 64 bits.
2. La clave generada también es de 64 bits.
3. Cada bloque de 64 bits sufre una transformación inicial, denominada permutación.
4. Tras la primera transformación, cada bloque sufrirá otras 16 transformaciones a través de las denominadas "Rondas Feistel". Cada transformación utilizará su propia clave generada a partir de la clave inicial.
5. Una vez finalizadas las 16 rondas, cada bloque sufrirá una transformación final.


## Algoritmo AES (Advanced Encryption Standard)

A partir del año 2000, el gobierno de los Estados Unidos adoptó el algoritmo AES.

Fue desarrollado por Joan Daemen y Vincent Rijmen, dos estudiantes belgas expertos en criptología, originariamente con el nombre de "Algoritmo Rijndael".

El funcionamiento del algoritmo AES es muy similar al anterior DES, con algunas diferencias que mencionamos a continuación: 

1. El mensaje a cifrar también se divide en bloques, pero esta vez cada bloque puede ser de longitud variable, entre 128, 192 o 256 bits.
2. La clave también puede ser de 128, 192 o 256 bits.
3. Se trata de un algoritmo más rápido y seguro que el algoritmo DES.
4. En Java se implementa de la misma manera que vimos en el apartado anterior, lo único que la instancia que hay que pedir será la de "AES" en vez de la de "DES". Por lo demás el código será el mismo.

