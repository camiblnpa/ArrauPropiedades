package ubb.gpsw.arrauPropiedades.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Tipo database table.
 * 
 */
@Entity
//@NamedQuery(name="Tipo.findAll", query="SELECT t FROM Tipo t")
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

	public Tipo() {
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

}