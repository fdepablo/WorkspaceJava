package modelo.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Con esta anotacion podemos decirle a JPA que esta clase sera
//una tabla de base de datos, por defecto la tabla se llamará
//como la clase. La clase debe de seguir la convención JavaBean
@Entity
//Si queremos cambiar el nombre de la tabla, podemos hacerlo
//con la siguiente anotacion
@Table(name = "personas")
public class Persona {
	//la entidad debe de tener un id, en este caso sera 
	//la propiedad id, esto lo hacemos poniendo @Id jusnto
	//encima de la propiedad que queremos que sea primary key
	@Id
	//podemos decirle al motor de bbdd que nos autogenere 
	//el id cada vez que mandemos un objeto para persistir
	//suele ser la mejor opcion
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private int edad;
	private double peso;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", peso=" + peso + "]";
	}
	
	
}
