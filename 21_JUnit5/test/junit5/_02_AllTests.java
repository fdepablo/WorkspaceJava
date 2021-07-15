package junit5;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/*
 * Si tenemos varias clases con test que queremos ejecutar, podemos crear
 * una clase "Suite" que sea la encargada de ejecutar todas las clases
 * con test que queramos.
 */

@RunWith(Suite.class)
//Aqui podemos poner todas las clases con test que tengamos
@SuiteClasses({
        _01_Asserciones.class,
        _00_Anotaciones.class})

public class _02_AllTests {

}