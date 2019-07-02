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
@NamedQuery(name="Destinacion.findAll", query="SELECT d FROM Destinacion d")
public class Destinacion implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDestinacion;

	private String nombreDestinacion;
	
	/*
	 * Relación
	 */
	@OneToMany(mappedBy = "destinacion", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Propiedad> propiedades;

	public Destinacion() {
	}
	
	public Destinacion(int id) {
		super();
		this.idDestinacion = id;
	}

	public int getIdDestinacion() {
		return this.idDestinacion;
	}

	public void setIdDestinacion(int idDestinacion) {
		this.idDestinacion = idDestinacion;
	}

	public String getNombreDestinacion() {
		return this.nombreDestinacion;
	}

	public void setNombreDestinacion(String nombreDestinacion) {
		this.nombreDestinacion = nombreDestinacion;
	}

}