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

	private int numBanio;

	private int numDormitorio;

	private int numEstacionamiento;

	@OneToMany(mappedBy = "tipo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Propiedad> propiedades;

	public Tipo() {
	}

	// Constructor utilizado por PropiedadPojo
	public Tipo(int id, String nombre, String cond, int nBanio, int nDorm, int nEstac) {
		super();
		this.idTipo = id;
		this.nombreTipo = nombre;
		this.condicion = cond;
		this.numBanio = nBanio;
		this.numDormitorio = nDorm;
		this.numEstacionamiento = nEstac;
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

	public int getNumBanio() {
		return this.numBanio;
	}

	public void setNumBanio(int numBanio) {
		this.numBanio = numBanio;
	}

	public int getNumDormitorio() {
		return this.numDormitorio;
	}

	public void setNumDormitorio(int numDormitorio) {
		this.numDormitorio = numDormitorio;
	}

	public int getNumEstacionamiento() {
		return this.numEstacionamiento;
	}

	public void setNumEstacionamiento(int numEstacionamiento) {
		this.numEstacionamiento = numEstacionamiento;
	}

}