# 📌 JavaBeans y Encapsulación

------------------------------------------------------------------------

## 📖 ¿Qué es un JavaBean?

Un **JavaBean** es una clase Java que sigue una serie de convenciones
para:

-   Encapsular datos
-   Facilitar su uso en frameworks (Spring, Hibernate, etc.)
-   Mantener el código organizado y reutilizable

------------------------------------------------------------------------

## ⚠️ Importante

Hasta ahora no lo habíamos aplicado siempre, pero <b>a partir de este
momento es obligatorio crear las clases con estructura JavaBean</b>.

------------------------------------------------------------------------

# 🔒 Encapsulación en Java

La **encapsulación** es uno de los principios fundamentales de la
Programación Orientada a Objetos (POO).

Consiste en:

-   **Ocultar los detalles internos** de una clase
-   Permitir el acceso a los datos solo mediante métodos controlados

------------------------------------------------------------------------

## ¿Cómo se consigue la encapsulación?

En Java se consigue principalmente mediante:

-   Atributos declarados como `private`
-   Métodos públicos `getters` y `setters`

Ejemplo:

``` java
private String nombre;

public String getNombre() {
    return this.nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}
```

------------------------------------------------------------------------

# ⭐ Características principales de un JavaBean

Un JavaBean debe cumplir estas <b>Tres caracteristicas </B>:

-   Tener atributos privados (**encapsulación**)\
-   Proporcionar métodos públicos **getters y setters**\
-   Incluir un constructor vacío (recomendado)

------------------------------------------------------------------------

# 🛠️ Generación automática de Getters y Setters en Eclipse

Los métodos `get` y `set` se pueden crear automáticamente en Eclipse
siguiendo estos pasos:

1.  Botón derecho sobre la clase\
2.  `Source`\
3.  `Generate Getters and Setters`

------------------------------------------------------------------------

# 📌 Ejemplo: Clase Persona (Ver código)

En este caso, la clase `Persona` contiene:

-   Un nombre (atributo simple)
-   Una dirección asociada (**relación 1-1** en BBDD)
-   Un conjunto de cuentas bancarias (**relación 1-N** en BBDD)

------------------------------------------------------------------------

✅ Esta estructura es la base para trabajar correctamente con entidades
en Java moderno.
