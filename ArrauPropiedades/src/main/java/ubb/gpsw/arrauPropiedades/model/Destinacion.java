package ubb.gpsw.arrauPropiedades.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;


//@NamedQuery(name="Destinacion.findAll", query="SELECT d FROM Destinacion d")
@Entity
public class Destinacion {
	//private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDestinacion;
	
	//@Temporal(TemporalType.DATE)
	@Column
	private Date fechaVenta;

	//@Temporal(TemporalType.DATE)
	@Column
	private Date fechaRegistro;
	
	@Column
	private String tipoDestinacion;
	
	@OneToMany(mappedBy="destinacion", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Propiedad> propiedades;

	public Destinacion() {
	}
	
	//Constructor utilizado por PropiedadPojo
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
	
	public Date getFechaVenta() {
		return this.fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}


	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getTipoDestinacion() {
		return this.tipoDestinacion;
	}

	public void setTipoDestinacion(String tipoDestinacion) {
		this.tipoDestinacion = tipoDestinacion;
	}

	public List<Propiedad> getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(List<Propiedad> propiedades) {
		this.propiedades = propiedades;
	}

}