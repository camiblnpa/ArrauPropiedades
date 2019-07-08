package ubb.gpsw.arrauPropiedades.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the Destinacion database table.
 * 
 */
@Entity
@NamedQuery(name="Destinacion.findAll", query="SELECT d FROM Destinacion d")
public class Destinacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDestinacion;

	private String nombreDestinacion;
	
	@OneToMany(mappedBy="destinacion", cascade = CascadeType.ALL)
	private List<Propiedad> propiedades;

	public Destinacion() {
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