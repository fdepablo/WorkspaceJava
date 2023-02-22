package modelo.videojuego;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "videojuegos")
public class Videojuego {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private double nota;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="vid_usu",
	   joinColumns= { @JoinColumn(name="fk_id_videojuego", referencedColumnName="id") }, //FK que aporta Comercial
	   inverseJoinColumns= { @JoinColumn(name="fk_id_usuario", referencedColumnName="id")}) //FKs que aportan el resto de entidades
	private List<Usuario> listaUsuarios;
	
	@ManyToOne
	@JoinColumn(name="fk_id_empresa", referencedColumnName="id")
	private Empresa empresa;	

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

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	
	
}
