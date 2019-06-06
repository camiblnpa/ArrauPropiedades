package ubb.gpsw.arrauPropiedades.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the Destinacion database table.
 * 
 */
@Entity
@NamedQuery(name = "Destinacion.findAll", query = "SELECT d FROM Destinacion d")
public class Destinacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDestinacion;

	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;

	@Temporal(TemporalType.DATE)
	private Date fechaVenta;

	private String tipoDestinacion;

	@OneToMany(mappedBy = "destinacion", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Propiedad> propiedades;

	public Destinacion() {
	}

	// Constructor utilizado por PropiedadPojo
	public Destinacion(String tipo) {
		super();
		this.tipoDestinacion = tipo;
	}

	public int getIdDestinacion() {
		return this.idDestinacion;
	}

	public void setIdDestinacion(int idDestinacion) {
		this.idDestinacion = idDestinacion;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaVenta() {
		return this.fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public String getTipoDestinacion() {
		return this.tipoDestinacion;
	}

	public void setTipoDestinacion(String tipoDestinacion) {
		this.tipoDestinacion = tipoDestinacion;
	}

}