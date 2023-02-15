package modelo.persistencia.interfaces;

import java.util.List;

import modelo.entidad.Persona;

//Esta interfaz define un CRUD para el objeto persona
//es decir, las operaciones b�sicas que podemos hacer con una entidad
//Create
//Read
//Update
//Delete
public interface DaoPersona {
	public int insertar(Persona p);
	public int borrar(int id);
	public Persona modificar(Persona p);
	public Persona buscar(int id);
	public List<Persona> listar();
}
