package ubb.gpsw.arrauPropiedades.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


/**
 * The persistent class for the EstadoPropiedad database table.
 * 
 */
@Entity
@NamedQuery(name="EstadoPropiedad.findAll", query="SELECT e FROM EstadoPropiedad e")
public class EstadoPropiedad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEstadoPropiedad;
	
	@NotEmpty
	private String nombreEstadoPropiedad;
	
	@OneToMany(mappedBy="estadoPropiedad", cascade = CascadeType.ALL)
	private List<Propiedad> propiedades;

	public EstadoPropiedad() {
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