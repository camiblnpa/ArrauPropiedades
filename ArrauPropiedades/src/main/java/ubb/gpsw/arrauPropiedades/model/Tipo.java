package ubb.gpsw.arrauPropiedades.model;

import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the Tipo database table.
 * 
 */

//@NamedQuery(name="Tipo.findAll", query="SELECT t FROM Tipo t")
@Entity
public class Tipo {
	//private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTipo;

	private String condicion;

	private String nombreTipo;

	private String numBanio;

	private String numDormitorio;

	private String numEstacionamiento;
	
	@OneToMany(mappedBy="destinacion", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Propiedad> propiedades;

	public Tipo() {
	}
	
	//Constructor que es utilizado por PropiedadPojo
	public Tipo(String nombre, String cond, String nBanio, String nDorm, String nEstac) {
		super();
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

	public String getNumBanio() {
		return this.numBanio;
	}

	public void setNumBanio(String numBanio) {
		this.numBanio = numBanio;
	}

	public String getNumDormitorio() {
		return this.numDormitorio;
	}

	public void setNumDormitorio(String numDormitorio) {
		this.numDormitorio = numDormitorio;
	}

	public String getNumEstacionamiento() {
		return this.numEstacionamiento;
	}

	public void setNumEstacionamiento(String numEstacionamiento) {
		this.numEstacionamiento = numEstacionamiento;
	}

	public List<Propiedad> getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(List<Propiedad> propiedades) {
		this.propiedades = propiedades;
	}

}