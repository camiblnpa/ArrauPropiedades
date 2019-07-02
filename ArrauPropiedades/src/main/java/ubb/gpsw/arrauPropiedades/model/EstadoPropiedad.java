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
@NamedQuery(name="EstadoPropiedad.findAll", query="SELECT e FROM EstadoPropiedad e")
public class EstadoPropiedad implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEstadoPropiedad;

	private String nombreEstadoPropiedad;
	
	/*
	 * Relación
	 */
	@OneToMany(mappedBy = "estadoPropiedad", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Propiedad> propiedades;

	public EstadoPropiedad() {
	}
	
	public EstadoPropiedad(int id) {
		super();
		this.idEstadoPropiedad = id;
	}

	public int getIdEstadoPropiedad() {
		return this.idEstadoPropiedad;
	}

	public void setIdEstadoPropiedad(int idEstadoPropiedad) {
		this.idEstadoPropiedad = idEstadoPropiedad;
	}

	public String getNombreEstadoPropiedad() {
		return this.nombreEstadoPropiedad;
	}

	public void setNombreEstadoPropiedad(String nombreEstadoPropiedad) {
		this.nombreEstadoPropiedad = nombreEstadoPropiedad;
	}

}