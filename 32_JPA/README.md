# Java Persistence API (JPA) 

Es una tecnolog�a Java que permite trabajar con entidades persistentes conectadas a una base de datos.

Tiene su origen en el framework Hibernate, un conjunto de librer�as que implementan un mapeado ORM (Mapeado Objeto-Relacional) desarrollado por Gavin King y un grupo de colaboradores a finales de 2001. Al principio Hibernate no era parte del est�ndar Java soportado por Sun (antiguo Oracle), sino que se desarroll� de forma independiente como un proyecto Java open source.

La idea de trabajar con entidades persistentes es intentar aplicar las ideas de la POO a las bases de datos, de forma que las clases y los objetos de una aplicaci�n puedan ser almacenados, modificados y buscados de forma eficiente en unidades de persistencia.

Una de las caracter�sticas principales de JPA es su simplicidad. JPA utiliza anotaciones y configuraci�n por defecto, de forma que el desarrollador s�lo tiene que especificar aquellas caracter�sticas que necesita que sean distintas de las de por defecto. 

## Implementaciones de JPA

La m�s popular es <b>Hibernate</b>, que tambi�n se incluye en el servidor de aplicaciones JBoss. Otras implementaciones gratuitas son <b>Apache OpenJPA</b>, <b>ecliselink</b>. <b>MyBatis</b> y <b>Oracle TopLink</b>. La �nica implementaci�n comercial de JPA existente en la actualidad es <b>CocoBase PURE POJO</b>.

## Introducci�n al proyecto

Este proyecto esta hecho con JPA, EclipseLink y Maven. Aunque esta tambien preparado para funcionar con hibernate solamente cambiando las dependencias en el pom.xml.

Si te da error este proyecto al importarlo hacer boton derecho sobre el proyecto -> Maven -> Update Maven Proyect para bajarte las librer�as que necesita este proyecto de internet

## Configuracion de proyecto con maven

Para evitar problemas de dependecias, podemos hacer un proyecto maven y que sea este el que 
nos lleve las dependencias del proyecto. Para ello ver el proyecto 30_Maven

Una vez creado el proyecto maven, debemos de configurar y crear las clases de entidad
y anotarlas adecuadamente (modelo.entidad). En este caso, la clase Persona

Por ultimo debemos de configurar el fichero META-INF/persistence.xml que se encuentra en
src/main/resoruces. Es importante que se encuentre en la carpeta META-INF.

Este fichero va a llevar la configuracion de nuestra BBDD y las clases que van a ser
mapeadas a la bbdd.

Lo mas importante a tener en cuenta:

1. Decir las clases que vamos a mapear a la bbdd (en este caso la persona)

2. Configurar el fichero META-INF/persistence.xml con las propiedades de la bbdd. Las tablas ser�an optativas crearlas, ya que si no lo hacemos, JPA creara las tablas por nosotros mediante la siguiente propiedad: 

	<property name="javax.persistence.schema-generation.database.action" value="update"/>

## Anotaciones en JPA

El entity manager debe de saber como tiene que mapear las clases a la bbdd, ya que debe poder crear una nueva instancia de la entidad cuando queramos buscarla e insertar en ella los datos obtenidos de base de datos para poder ser leidos, y ademas debe ser capaz leer los datos guardados en la entidad para volcarlos en la base de datos.

Normalmente crearemos clases POJO que representan entidades y las anotaremos para que puedan ser gestionadas por el entity manager.

Entre las anotaciones m�s importantes podemos encontrar las siguientes:

1. <b>@Entity</b>, esta anotacion se pone encima de una clase, y le estamos dicienco al EM que dicha clase sera un tabla en bbdd. Por defecto se llamara en la bbdd como se llame la clase pero todo en minusculas. Por defecto cogera todos sus atributos y los convertira en columnas en la bbdd.
2. <b>@Table</b>, esta anotacion va encima de la clase y sirve para alterar la tabla que nos creara JPA, normalmente para cambiar el nombre de la tabla.
3. <b>@Id</b>, esta anotacion se pone en un atributo y representa el atributo que sera la primary key de la tabla.
4. <b>@GeneratedValue</b>, esta anotacion va acompa�ada de la anotacion @id, y representa que la clave primaria sera auto incrementada por la bbdd. Tiene varios posibles valores en funcion de la BBDD
5. <b>@Column</b>, esta anotacion se pone encima de un atributo y sirve para modificar las propiedades de la columna de bbdd. Recordemos que por defecto JPA nos convertira todos los atributos de una clase a columnas, y el nombre por defecto de la columna sera el mismo que el del atributo. Con esta anotacion podemos por ejemplo cambiar el nombre que tendra la columna en bbdd o por ejemplo permitir que sea nulo el campo en bbdd.
6. <b>@Temporal</b>, esta anotacion se pone encima de un atributo y sirve principalmente para trabajar con fechas (clase java.util.Date).
7. <b>@Transient</b>, esta anotacion se pone encima de un atributo y sirve para decirle a JPA que dicho atributo no queremos que se persita en bbdd, por lo que tampoco creara el campo correspondiente.
8. <b>@Enumerated</b>, esta anotacion se pone encima de un atributo y sirve para trabajar con enumerados.

Existen otras anotaciones importantes para establecer relaciones que veremos en otros ejemplos,  principalmente anotaciones para hacer relaciones con otras clases (one to one, one to many...)

## Entity Manager y Contexto de Persistencia

Todas las operaciones relacionadas con la persistencia de las entidades se realizan a trav�s de un gestor de entidades.

El entity manager tiene dos responsabilidad fundamentales:

1. Define una conexi�n transaccional con la base de datos que debemos abrir y mantener abierta mientras estamos realizado operaciones. En este sentido realiza funciones similares a las de una conexi�n JDBC.
2. Mantiene en memoria una cach� con las entidades que gestiona y es responsable de sincronizarlas correctamente con la base de datos. El conjunto de entidades que gestiona un entity manager se denomina su contexto de persistencia.

El entity manager se obtiene a trav�s de una factor�a del tipo EntityManagerFactory, que se configura mediante la especificaci�n de una unidad de persistencia definida en el fichero XML persistence.xml. En el fichero pueden haber definidas m�s de una unidad de persistencia, cada una con un nombre distinto. La unidad de persistencia define las caracter�sticas concretas de la base de datos con la que van a trabajar todos los entity managers obtenidos a partir de esa factor�a y queda asociada a ella en el momento de su creaci�n. Existe, por tanto, una relaci�n uno-a-uno entre una unidad de persistencia y su EntityManagerFactory concreto. Para obtener una factor�a EntityManagerFactory debemos llamar a un m�todo est�tico de la clase Persistence.

![EntityManager](img/entity-manager.png "EntityManager")

Una vez creado el entity manager lo utilizaremos para realizar todas las operaciones de recuperaci�n, consulta y actualizaci�n de entidades. Cuando un entity manager obtiene una referencia a una entidad, se dice que la entidad est� gestionada (una managed entity en ingl�s) por �l. El entity manager guarda internamente todas las entidades que gestiona y las utiliza como una cach� de los datos en la base de datos. Por ejemplo, cuando va a recuperar una entidad por su clave primaria, lo primero que hace es consultar en su cach� si esta entidad ya la ha recuperado previamente. Si es as�, no necesita hacer la b�squeda en la base de datos y devuelve la propia referencia que mantiene. Al conjunto de entidades gestionadas por un entity manager se le denomina su contexto de persistencia (persistence context en ingl�s).

En un determinado momento, el entity manager debe volcar a la base de datos todos los cambios que se han realizado sobre las entidades. Tambi�n debe ejecutar las consultas JPQL definidas. Para ello el entity manager utiliza un proveedor de persistencia (persistence provider en ingl�s) que es el responsable de generar todo el c�digo SQL compatible con la base de datos.

### Obtencion del EntityManager

Cuando estamos usando JPA gestionado por una aplicaci�n Java SE, el entity manager se obtiene a partir de un EntityManagerFactory. Para obtener la factor�a se debe llamar al m�todo est�tico createEntityMagerFactory() de la clase Persistence. En este m�todo se debe proporcionar el nombre de la unidad de persistencia que vamos a asociar a la factor�a.

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("NOMBRE_UNIDAD_PERSISTENCIA");
	
Una vez que tenemos una factor�a, podemos obtener f�cilmente un EntityManager:

	EntityManager em = emf.createEntityManager();
	
Es muy importante considerar que los objetos EntityManager no son thread-safe. Cuando los utilicemos en servlets, por ejemplo, deberemos crearlos en cada petici�n HTTP. De esta forma se evita que distintas sesiones accedan al mismo contexto de persistencia. Si queremos que una sesi�n HTTP utilice un �nico entity manager, podr�amos guardarlo en el objeto HtttpSession y acceder a �l al comienzo de cada petici�n. El objeto EntityManagerFactory a partir del que obtenemos los entity managers s� que es thread-safe.

### Contexto de persistencia

Una cuesti�n muy importante para entender el funcionamiento del entity manager es comprender su contexto de persistencia. Contiene la colecci�n de entidades gestionadas por el entity manager que est�n conectadas y sincronizadas con la base de datos. Cuando el entity manager cierra una transacci�n, su contexto de persistencia se sincroniza autom�ticamente con la base de datos. Sin embargo, a pesar del importante papel que juega, el contexto de persistencia nunca es realmente visible a la aplicaci�n. Siempre se accede a �l indirectamente a trav�s del entity manager y asumimos que est� ah� cuando lo necesitamos.

Es tambi�n fundamental entender que el contexto de persistencia hace el papel de cach� de las entidades que est�n realmente en la base de datos. Cuando actualizamos una instancia en el contexto de persistencia estamos actualizando una cach�, una copia que s�lo se hace persistente en la base de datos cuando el entity manager manda la informaci�n de las instancias en la base de datos.

Es muy importante darse cuenta de la diferencia entre el contexto de persistencia y la base de datos propiamente dicha. La sincronizaci�n no se realiza hasta que el entity manager vuelca los cambios a la base de datos.

## Operaciones del entity manager

Podemos encontrar metodos importantes dentro del entity manager

1. <b>EntityTransaction getTransaction():</b> devuelve la transacci�n actual. Fundamental para metodos que modifiquen la base de datos, pero no necesarios para acceder a informaci�n.
2. <b>void persist(Object entity):</b> hace una entidad persistente y gestionada.
3. <b><T> T merge(T entity):</b> incorpora una entidad al contexto de persistencia, haci�ndola gestionada. Normalmente usado para modificar.
4. <b><T> T find(Class<T>, Object key):</b> busca por clave primaria
5. <b>void remove(Object entity):</b> elimina la entidad
6. <b>void clear():</b> borra el contexto de persistencia, desconectando todas sus entidades. Dicho de otra manera, vacia la cache completa
7. <b>void detach(Object entity):</b> elimina la entidad del contexto de persistencia, dej�ndola desconectada de la base de datos. Como el metodo clear() pero solamente para una entidad.
8. <b>void flush():</b> sincroniza el contexto de persistencia con la base de datos. Tambien podemos hacerlo haciendo un commit().
9. <b>boolean contains(Object entity):</b> comprueba si una entidad est� gestionada en el contexto de persistencia
10. <b>Query createNamedQuery(String name):</b> obtiene una consulta JPQL precompilada
11. <b>void refresh(Object entity):</b> refresca el estado de la entidad con los valores de la base de datos, sobreescribiendo los cambios que se hayan podido realizar en ella

Vamos a ver en m�s detalle los m�s importantes

### Persist para hacer persistente una entidad

El m�todo persist() del EntityManager acepta una nueva instancia de entidad y la convierte en gestionada. Si la entidad que se pasa como par�metro ya est� gestionada en el contexto de persistencia, la llamada se ignora.

El hecho de convertir una entidad en gestionada no la hace persistir inmediatamente en la base de datos. La verdadera llamada a SQL para crear los datos relacionales no se generar� hasta que el contexto de persistencia se sincronice con la base de datos. Lo m�s normal es que esto suceda cuando se realiza un commit de la transacci�n.

Si se llama a persist() fuera de una transacci�n la entidad se incluir� en el contexto de persistencia, pero no se realizar� ninguna acci�n hasta que la transacci�n comience y el contexto de persistencia se sincronice con la base de datos.

La operaci�n persist() se utiliza con entidades nuevas que no existen en la base de datos. Si se le pasa una instancia con un identificador que ya existe en la base de datos el proveedor de persistencia puede detectarlo y lanzar una excepci�n al gestionarla o al intentar guardarla en bbdd (dependiendo de la implementaci�n de JPA que estemos usando)

Ver ejemplo _01_CrearPersonaJPA

### Merge para modificar entidades

El m�todo merge(Object o) permite volver a incorporar en el contexto de persistencia del entity manager una entidad que hab�a sido desconectada. Debemos pasar como par�metro la entidad que queremos incluir. 

Normalmente este m�todo se utiliza para modificar informaci�n en base de datos, aunque puede ser usado para dar de alta en un momento dado debido a su peculiar uso.

Podemos identificar las siguientes casuisticas:

1. El objeto pasado tiene datos y valor en el id, es decir, un caso normal de modificaci�n de una entidad.
    - Si el objeto <b>SI</b> lo tiene ya en la cach�, mira si los datos cambian y si es as� modifica el objeto gestionado (el objeto de cache) y lo marca para un update cuando hagamos el commit o el flush.
    - Si el objeto <b>NO</b> lo tiene en la cach� entonces hara un select para traer el objeto a la cache pero podra suceder lo siguiente:
        - Que no exista  en bbdd: INSERT del objeto en bbdd. Es decir, su comportamiento seria igual que el del un <b>persist()</b>
        - Que exista pero que los datos no cambien: no hace nada
        - Que exista y con datos diferentes: se lo trae, lo modifica con los datos del objeto que pasamos y lo marca para update al hacer commit
	
2. El objeto pasado tiene datos pero la clave primaria a null -> En este caso insertara el objeto y le asignar� un ID, siempre y cuando la clave primaria sea gestionada por la BBDD. Es decir, su comportamiento seria igual que el del un <b>persist()</b>

Hay que tener cuidado con su utilizaci�n, porque el objeto que se pasa como par�metro no pasa a ser gestionado. Hay que usar el objeto que devuelve el m�todo. Veamos el siguiente ejemplo para entenderlo mejor, dado el siguiente registro en la tabla:

    ID	|NOMBRE	|DIR	|TEL
    ------------------------
    1		|a		|b	|c	

Ejecutamos el siguiente codigo

	Cliente c = new Cliente(1,"A","B",C");
	em.merge(c);
	c.setNombre("F"); 
	//El cambio se perder� cuando hagamos el commit, ya que el objeto donde estamos cambiando el valor no es el objeto gestionado
	em.commit();
	
	Cliente c = new Cliente(1,"A","B",C");
	c = em.merge(c); //Devuelve el objeto que de la cach�
	c.setNombre("TPM"); //Ahora no se pierde porque la referencia apunta al objeto getionado por el contexto de persistencia.
	em.commit();
	
Ver el ejemplo _02_ModificarPersonaJPA

### Find para buscar entidades

Mediante el metodo find() el entity manager buscar� esa entidad en la base de datos y devolver� la instancia buscada. La entidad devuelta ser� una entidad gestionada que existir� en el contexto de persistencia actual asociado al entity manager.

En el caso en que no existiera ninguna entidad con ese identificador, se devolver�a simplemente null.

Ver ejemplo _03_ObtenerPersonaJPA

### Remove para borrar entidades

Un borrado de una entidad realiza una sentencia DELETE en la base de datos. Puede que no sea necesario hacer borrados muy a menudo ya que muchas veces los registros en bbdd se marcan como no activos para no perderlos y recuperarlos en un futuro.

Es muy importante entender que para eliminar una entidad, la entidad debe estar gestionada, esto es, debe existir el objeto en el contexto de persistencia. Es por ello que normalmente antes de hacer un <b>remove()</b> del objeto, hagamos un <b>find()</b> del objeto que queramos borrar para que sea gestionado por el entity manager, o dicho de otra manera, para meterlo en el contexto de persistencia.

Si intentamos hacer un <b>remove()</b> sobre un objeto no gestionado, dara una excepcion al ejecutar el <b>commit()</b>.

### Actualizaci�n de entidades

Para actualizar una entidad, primero debemos obtenerla para convertirla en gestionada. Despu�s podremos colocar los nuevos valores en sus atributos. 

Podemos hacerlo primero haciendo un find() de la entidad que queremos actualizar, y luego modificando los valores del objeto antes de hacer el commit.

	Persona persona = em.find(Persona.class, 1);
	persona.setNombre("Tony Stark");
	
En el ejemplo anterior vemos que la referencia esta apuntando al objeto gestionado por lo que podemos cambiar sus valores.

Es muy importante notar que no est� permitido modificar la clave primaria de una entidad gestionada. Si intentamos hacerlo, en el momento de hacer un commit la transacci�n lanzar� una excepci�n.

## Bibliografia

- <http://www.java2s.com/Tutorials/Java/JPA/index.htm>
- <https://www.manning.com/books/java-persistence-with-hibernate>
- <http://hibernate.org/orm/documentation/5.5/>
- <https://jcp.org/aboutJava/communityprocess/final/jsr317/index.html>