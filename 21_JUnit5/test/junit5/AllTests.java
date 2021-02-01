package junit5;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

//Esto sirve para ejecutar desde un mismo punto de partida
//todos los test que tengamos

@RunWith(Suite.class)
//Aqui podemos poner todos los test que tengamos
@SuiteClasses({
        _01_Asserciones.class,
        _00_Anotaciones.class})

public class AllTests {

}