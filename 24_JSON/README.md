![json](img/json_logo.png "Aprende JSON!")

# JSON (JavaScript Object Notation - Notación de Objetos de JavaScript) 

Es un formato ligero de intercambio de datos. Leerlo y escribirlo es simple para humanos, mientras que para las máquinas es simple interpretarlo y generarlo. Está basado en un subconjunto del Lenguaje de Programación JavaScript, 

Actualmente es un formato de intercambio de texto más popular que XML ya que ocupa menos espacio respecto a XML transmitiendo la misma información.

JSON está constituido por dos estructuras:

1. Una colección de pares de <b>clave/valor</b>. En varios lenguajes esto es conocido como un <b>objeto</b>, pero también como registro, estructura, diccionario, tabla hash, lista de claves o un array asociativo. La clave tiene que ser una cadena entre comillas dobles. El valor puede ser de cualquier tipo (ver más abajo). Ejemplo: 

        {"id": 1, "nombre": "Stark"}

2. Una lista ordenada de valores. En la mayoría de los lenguajes, esto se implementa como array, vectores, listas o secuencias. Representa una lista ordenada de cero o más valores los cuales pueden ser de cualquier tipo. Los valores se separan por comas y el vector se mete entre corchetes. Ejemplo:

        ["juan","pedro","jacinto"]

Un objeto es un conjunto desordenado de pares clave/valor. Un objeto comienza con "{" llave de apertura y termine con "}" llave de cierre. Cada clave está representada por una cadena de texto y va seguido por ":" dos puntos. El valor puede ser de uno de los 6 tipos de datos de JSON. Los diferentes pares de clave/valor están separados por "," coma.

Los <b>tipos de datos</b> o valores disponibles con JSON son:

1. Números: Se permiten números negativos y opcionalmente pueden contener parte fraccional separada por puntos. Ejemplo: 123.456
2. Cadenas: Representan secuencias de cero o más caracteres. Se ponen entre doble comilla y se permiten cadenas de escape. Ejemplo: "Hola"
3. Booleanos: Representan valores booleanos y pueden tener dos valores: true y false
4. null: Representan el valor nulo.
5. Array
6. Objeto

Nótese como un array puede por ejemplo tener como valores otros arrays u otros objetos, o un objeto puede tener como valores un array u otros objetos. 

## Ejemplos de JSON

Va a ver ejemplos de objetos validos en formato JSON

### Objeto sencillo

     {"latitude": 40.416875}
     
### Objeto complejo

    {
        "latitude": 40.416875,
        "longitude": -3.703308,
        "city": "Madrid",
        "description": "Puerta del Sol",
        "cp" : null,
        "moviendose" : true
      }
### Array simple

    [0,1,1,2,3,5,8,13]
    [true,false]
    [1,1,null,"steve"]

     
### Objeto complejo con array

    {
        "latitude": 40.416875,
        "longitude": -3.703308,
        "city": "Madrid",
        "description": "Puerta del Sol",
        "cp" : null,
        "moviendose" : true,
        "puntos recorridos" : [23,45,67,89]
      }
      
### Array de objetos

    [
      {
        "latitude": 40.416875,
        "longitude": -3.703308,
        "city": "Madrid",
        "description": "Puerta del Sol"
      },
      {
        "latitude": 40.417438,
        "longitude": -3.693363,
        "city": "Madrid",
        "description": "Paseo del Prado"
      },
      {
        "latitude": 40.407015,
        "longitude": -3.691163,
        "city": "Madrid",
        "description": "Estación de Atocha"
      }
     ]
     
### Objeto con array

    {"numeros de fibonacci" : [0,1,1,2,3,5,8,13]}

     
### Objeto con array de objetos

    {
        "marcadores": [
          {
            "latitude": 40.416875,
            "longitude": -3.703308,
            "city": "Madrid",
            "description": "Puerta del Sol"
          },
          {
            "latitude": 40.417438,
            "longitude": -3.693363,
            "city": "Madrid",
            "description": "Paseo del Prado"
          },
          {
            "latitude": 40.407015,
            "longitude": -3.691163,
            "city": "Madrid",
            "description": "Estación de Atocha"
          }
        ]
    }

### Ejemplo con objetos y arrays complejo (Es el ejemplo 01_JSON.json)

    {"persona":{
       "id": "1",
       "nombre": "Tony",
       "apellido": "Stark",
       "edad": 45,
       "direcciones" :[
            {"direccion1":{
                "tipoVia": "Avenida",
                "nombreVia": "Avenger",
                "ciudad": "New York"
                }
            },
            {"direccion2":{
                "tipoVia": "Calle",
                "nombreVia": "Gran Via",
                "ciudad": "Madrid"
                }
            }
       ],
       "estaCasado": false,
       "pareja": null,
       "superpoder":{
            "superinteligencia":100,
            "superfuerza":50
       }
     }
    }
    
Son ejemplos, pero tenemos infinitas combinaciones entre ellos.

## Ejemplo practico con Java

En este ejemplo vamos a usar unas librerías de Google para hacer la transformación de objeto a JSON (serialización) y de JSON a objeto (deserialización). La librería se llama <b>GSON</b>, aunque hay otras implementaciones en el mercado igual de validas (como Jackson), teniendo todas sus pros y sus contras. En este caso se ha elegido **GSON** por su simplicidad de usar.

## Conversores de XML a JSON y viceversa

- <https://www.site24x7.com/es/tools/json-a-xml.html>

- <https://www.freeformatter.com/xml-to-json-converter.html>

## Bibliografía

- <https://www.json.org/json-es.html>

