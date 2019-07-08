package ubb.gpsw.arrauPropiedades.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Propiedad database table.
 * 
 */
@Entity
@NamedQuery(name="Propiedad.findAll", query="SELECT p FROM Propiedad p")
public class Propiedad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPropiedad;

	private String calle;

	private String ciudad;

	private String comuna;

	private String descripcion;

	private int dimConstruccion;

	private int dimTerreno;

	@Temporal(TemporalType.DATE)
	private Date fechaPublicacion;

	private String nombrePropiedad;

	private int numBanio;

	private String numDepartamento;

	private int numDormitorio;

	private String numero;

	private int numEstacionamiento;

	private int precio;

	private String region;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="destinacion_idDestinacion")
	private Destinacion destinacion;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="estadoPropiedad_idEstadoPropiedad")
	private EstadoPropiedad estadoPropiedad;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="inmobiliaria_idInmobiliaria")
	private Inmobiliaria inmobiliaria;
	
	@OneToMany(mappedBy="propiedad", cascade = CascadeType.ALL)
	private List<Interesado> interesados;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tipo_idTipo")
	private Tipo tipo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="condicion_idCondicion")
	private Condicion condicion;

	public Propiedad() {
	}

	public int getIdPropiedad() {
		return idPropiedad;
	}

	public void setIdPropiedad(int idPropiedad) {
		this.idPropiedad = idPropiedad;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getDimConstruccion() {
		return dimConstruccion;
	}

	public void setDimConstruccion(int dimConstruccion) {
		this.dimConstruccion = dimConstruccion;
	}

	public int getDimTerreno() {
		return dimTerreno;
	}

	public void setDimTerreno(int dimTerreno) {
		this.dimTerreno = dimTerreno;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getNombrePropiedad() {
		return nombrePropiedad;
	}

	public void setNombrePropiedad(String nombrePropiedad) {
		this.nombrePropiedad = nombrePropiedad;
	}

	public int getNumBanio() {
		return numBanio;
	}

	public void setNumBanio(int numBanio) {
		this.numBanio = numBanio;
	}

	public String getNumDepartamento() {
		return numDepartamento;
	}

	public void setNumDepartamento(String numDepartamento) {
		this.numDepartamento = numDepartamento;
	}

	public int getNumDormitorio() {
		return numDormitorio;
	}

	public void setNumDormitorio(int numDormitorio) {
		this.numDormitorio = numDormitorio;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getNumEstacionamiento() {
		return numEstacionamiento;
	}

	public void setNumEstacionamiento(int numEstacionamiento) {
		this.numEstacionamiento = numEstacionamiento;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Destinacion getDestinacion() {
		return destinacion;
	}

	public void setDestinacion(Destinacion destinacion) {
		this.destinacion = destinacion;
	}

	public EstadoPropiedad getEstadoPropiedad() {
		return estadoPropiedad;
	}

	public void setEstadoPropiedad(EstadoPropiedad estadoPropiedad) {
		this.estadoPropiedad = estadoPropiedad;
	}

	public Inmobiliaria getInmobiliaria() {
		return inmobiliaria;
	}

	public void setInmobiliaria(Inmobiliaria inmobiliaria) {
		this.inmobiliaria = inmobiliaria;
	}

	public List<Interesado> getInteresados() {
		return interesados;
	}

	public void setInteresados(List<Interesado> interesados) {
		this.interesados = interesados;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Condicion getCondicion() {
		return condicion;
	}

	public void setCondicion(Condicion condicion) {
		this.condicion = condicion;
	}
}