package _08_visibilidades.javabean;

import java.util.Arrays;

/**
 * Clase JavaBean que representa una entidad Persona.
 * 
 * <p>
 * Un <b>JavaBean</b> es una clase Java que sigue una serie de convenciones
 * para encapsular datos y permitir su uso en frameworks.
 * </p>
 * 
 * <p>
 * Hasta la fecha no lo hemos hecho, pero a partir de ahora siempre
 * es obligatorio hacer este tipo de clases con estructura JavaBean
 * </p>
 * 
 * <b>Encapsulación en Java</b>
 * <p>
 * La <b>encapsulación</b> es uno de los principios fundamentales de la
 * Programación Orientada a Objetos (POO).
 * Consiste en <b>ocultar los detalles internos</b> de una clase y permitir
 * el acceso a sus datos únicamente a través de métodos controlados.
 * </p>
 *
 * <p>En Java, la encapsulación se consigue principalmente mediante:</p>
 * <ul>
 *   <li>Atributos declarados como <b>private</b>, para que no puedan ser
 *       modificados directamente desde fuera de la clase.</li>
 *   <li>Métodos públicos <b>getters</b> y <b>setters</b>, que permiten
 *       leer o cambiar los valores de forma segura.</li>
 * </ul>
 *
 * <p>Características principales de un JavaBean:</p>
 * <ul>
 *   <li>Debe tener atributos privados (encapsulación).</li>
 *   <li>Debe proporcionar métodos públicos <b>getters</b> y <b>setters</b>
 *       para acceder y modificar los atributos.</li>
 *   <li>Suele incluir el constructor vacío (no obligatorio, pero recomendado).</li>
 * </ul>
 *
 * <p>
 * Los Getter y Setter se pueden crear de manera automática desde eclipse
 * con: Boton derecho sobre la clase -> Source 
 *	-> Generate Getters and Setters 
 * </p>
 * 
 * <p>
 * En este caso, la clase Persona contiene:
 * </p>
 * <ul>
 *   <li>Un nombre (atributo simple).</li>
 *   <li>Una dirección asociada (relación 1-1 en base de datos).</li>
 *   <li>Un conjunto de cuentas bancarias (relación 1-N en base de datos).</li>
 * </ul>
 */
public class Persona {
	private String nombre;
	private Direccion direccion;//1-1 en BBDD
	private CuentaBancaria[] cuentasBancarias;//1-N en BBDD
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public CuentaBancaria[] getCuentasBancarias() {
		return cuentasBancarias;
	}
	public void setCuentasBancarias(CuentaBancaria[] cuentasBancarias) {
		this.cuentasBancarias = cuentasBancarias;
	}
	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", direccion=" + direccion + ", cuentasBancarias="
				+ Arrays.toString(cuentasBancarias) + "]";
	}
	
	
}
