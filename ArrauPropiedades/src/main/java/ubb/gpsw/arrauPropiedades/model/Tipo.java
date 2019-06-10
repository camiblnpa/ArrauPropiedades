package ubb.gpsw.arrauPropiedades.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the Tipo database table.
 * 
 */
@Entity
@NamedQuery(name = "Tipo.findAll", query = "SELECT t FROM Tipo t")
public class Tipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipo;

	private String condicion;

	private String nombreTipo;

	@OneToMany(mappedBy = "tipo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Propiedad> propiedades;

	public Tipo() {
	}

	// Constructor utilizado por PropiedadPojo
	public Tipo(int id, String nombre, String cond) {
		super();
		this.idTipo = id;
		this.nombreTipo = nombre;
		this.condicion = cond;
	}

	public int getIdTipo() {
		return this.idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public String getCondicion() {
		return this.condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	public String getNombreTipo() {
		return this.nombreTipo;
	}

	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}
}