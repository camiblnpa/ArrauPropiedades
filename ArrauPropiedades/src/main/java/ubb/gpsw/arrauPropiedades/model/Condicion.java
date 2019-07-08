package ubb.gpsw.arrauPropiedades.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


/**
 * The persistent class for the Condicion database table.
 * 
 */
@Entity
@NamedQuery(name="Condicion.findAll", query="SELECT c FROM Condicion c")
public class Condicion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCondicion;

	@NotEmpty
	private String nombreCondicion;
	
	@OneToMany(mappedBy="condicion", cascade = CascadeType.ALL)
	private List<Propiedad> propiedades;

	public Condicion() {
	}

	public int getIdCondicion() {
		return this.idCondicion;
	}

	public void setIdCondicion(int idCondicion) {
		this.idCondicion = idCondicion;
	}

	public String getNombreCondicion() {
		return this.nombreCondicion;
	}

	public void setNombreCondicion(String nombreCondicion) {
		this.nombreCondicion = nombreCondicion;
	}

}