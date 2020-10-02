package modelo.entidad;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
//podriamos crear una NamedQuery con este formato para invocarla automaticamente
//Ej:  em.createNamedQuery("Cliente.findAll")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
//Tambien podriamos hacer varias NamedQueries
/*
@NamedQueries({
    @NamedQuery(name="Cliente.findAll",
                query="SELECT c FROM Cliente c"),
    @NamedQuery(name="Cliente.findByNif",
                query="SELECT c FROM Cliente c WHERE c.nif = :nif"),
}) 
*/
// Y podriamos invocar así:
// em.createNamedQuery("Cliente.findByNif").setParameter("nif","123").getResultList();
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String nif;

	private String ciudad;

	private String domicilio;

	private String nombre;

	private String tlf;

	//bi-directional many-to-one association to Factura
	@OneToMany(mappedBy="cliente")
	private List<Factura> facturas;

	public Cliente() {
	}

	public String getNif() {
		return this.nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDomicilio() {
		return this.domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTlf() {
		return this.tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	public List<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Factura addFactura(Factura factura) {
		getFacturas().add(factura);
		factura.setCliente(this);

		return factura;
	}

	public Factura removeFactura(Factura factura) {
		getFacturas().remove(factura);
		factura.setCliente(null);

		return factura;
	}
	
	@Override
	public String toString() {
		return nif + " - " + nombre + " - " + tlf;
	}

}