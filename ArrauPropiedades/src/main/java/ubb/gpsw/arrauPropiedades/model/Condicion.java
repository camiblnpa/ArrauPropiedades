package ubb.gpsw.arrauPropiedades.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name="Condicion.findAll", query="SELECT c FROM Condicion c")
public class Condicion implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCondicion;

	private String nombreCondicion;
	
	/*
	 * Relación
	 */
	@OneToMany(mappedBy = "condicion", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Propiedad> propiedades;

	public Condicion() {
	}
	
	public Condicion(int id) {
		super();
		this.idCondicion = id;
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