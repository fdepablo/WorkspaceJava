# Clave asimetrica

En este tipo de sistemas la clave para encriptar y la clave para desencriptar es
diferente

En este ejemplo vamos a estudiar el algoritmo <b>RSA</b>, desarrollado por Ron Rivest, Adi Shamir y Leonard Adleman cuyas iniciales dieron nombre al algoritmo. Nos vasamos en lo siguiente:

- La clave privada, que solo la tendrá una persona y no podrá ser compartida a nadie más- 
- La clave pública, que la puede tener cualquiera.

El procedimiento empleado para el cifrado y descifrado en los ejemplos es el siguiente:

1. Generamos el par de claves, clave publica y clave privada.
2. Ciframos con la clave privada si queremos garantizar autenticidad. Ciframos con la clave publica si queremos garantizar confidencialidad.
3. Desciframos con la clave publica si hemos cifrado previamente con la clave privada o desciframos con la privada si hemos cifrado previamente con la publica.


