package modelo.persistencia.interfaces;

import java.util.List;

import modelo.entidad.Persona;

//Esta interfaz define un CRUD para el objeto persona
//es decir, las operaciones básicas que podemos hacer con una entidad
//Create
//Read
//Update
//Delete
public interface DaoPersona {
	public boolean alta(Persona p);
	public boolean baja(int id);
	public boolean modificar(Persona p);
	public Persona obtener(int id);
	public List<Persona> listar();
}
