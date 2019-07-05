package ubb.gpsw.arrauPropiedades.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

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

	private int condicion_idCondicion;

	private String descripcion;

	private int destinacion_idDestinacion;

	private int dimConstruccion;

	private int dimTerreno;

	private int estadoPropiedad_idEstadoPropiedad;

	private String imagen;

	private int inmobiliaria_idInmobiliaria;

	private int interesado_idInteresado;

	private String nombrePropiedad;

	private String numDepartamento;

	private String numero;

	private int precio;

	private int publicacion_idPublicacion;

	private String region;

	private int tipo_idTipo;
	
	private int numBanio;
	
	private int numEstacionamiento;
	
	private int numDormitorio;
	
	/*
	 * Relaciones
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="condicion_idCondicion")
	private Condicion condicion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="destinacion_idDestinacion")
	private Destinacion destinacion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="estadoPropiedad_idEstadoPropiedad")
	private EstadoPropiedad estadoPropiedad;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="inmobiliaria_idInmobiliaria")
	private Inmobiliaria inmobiliaria;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="interesado_idInteresado")
	private Interesado interesado;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="publicacion_idPublicacion")
	private Publicacion publicacion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="tipo_idTipo")
	private Tipo tipo;
	
	public Propiedad() {
	}
	
	public Propiedad(int id) {
		super();
		this.idPropiedad = id;
	}

	public int getIdPropiedad() {
		return this.idPropiedad;
	}

	public void setIdPropiedad(int idPropiedad) {
		this.idPropiedad = idPropiedad;
	}

	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getComuna() {
		return this.comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public int getCondicion_idCondicion() {
		return this.condicion_idCondicion;
	}

	public void setCondicion_idCondicion(int condicion_idCondicion) {
		this.condicion_idCondicion = condicion_idCondicion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getDestinacion_idDestinacion() {
		return this.destinacion_idDestinacion;
	}

	public void setDestinacion_idDestinacion(int destinacion_idDestinacion) {
		this.destinacion_idDestinacion = destinacion_idDestinacion;
	}

	public int getDimConstruccion() {
		return this.dimConstruccion;
	}

	public void setDimConstruccion(int dimConstruccion) {
		this.dimConstruccion = dimConstruccion;
	}

	public int getDimTerreno() {
		return this.dimTerreno;
	}

	public void setDimTerreno(int dimTerreno) {
		this.dimTerreno = dimTerreno;
	}

	public int getEstadoPropiedad_idEstadoPropiedad() {
		return this.estadoPropiedad_idEstadoPropiedad;
	}

	public void setEstadoPropiedad_idEstadoPropiedad(int estadoPropiedad_idEstadoPropiedad) {
		this.estadoPropiedad_idEstadoPropiedad = estadoPropiedad_idEstadoPropiedad;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getInmobiliaria_idInmobiliaria() {
		return this.inmobiliaria_idInmobiliaria;
	}

	public void setInmobiliaria_idInmobiliaria(int inmobiliaria_idInmobiliaria) {
		this.inmobiliaria_idInmobiliaria = inmobiliaria_idInmobiliaria;
	}

	public int getInteresado_idInteresado() {
		return this.interesado_idInteresado;
	}

	public void setInteresado_idInteresado(int interesado_idInteresado) {
		this.interesado_idInteresado = interesado_idInteresado;
	}

	public String getNombrePropiedad() {
		return this.nombrePropiedad;
	}

	public void setNombrePropiedad(String nombrePropiedad) {
		this.nombrePropiedad = nombrePropiedad;
	}

	public String getNumDepartamento() {
		return this.numDepartamento;
	}

	public void setNumDepartamento(String numDepartamento) {
		this.numDepartamento = numDepartamento;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getPrecio() {
		return this.precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getPublicacion_idPublicacion() {
		return this.publicacion_idPublicacion;
	}

	public void setPublicacion_idPublicacion(int publicacion_idPublicacion) {
		this.publicacion_idPublicacion = publicacion_idPublicacion;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public int getTipo_idTipo() {
		return this.tipo_idTipo;
	}

	public void setTipo_idTipo(int tipo_idTipo) {
		this.tipo_idTipo = tipo_idTipo;
	}

	public int getNumBanio() {
		return numBanio;
	}

	public void setNumBanio(int numBanio) {
		this.numBanio = numBanio;
	}

	public int getNumEstacionamiento() {
		return numEstacionamiento;
	}

	public void setNumEstacionamiento(int numEstacionamiento) {
		this.numEstacionamiento = numEstacionamiento;
	}

	public int getNumDormitorio() {
		return numDormitorio;
	}

	public void setNumDormitorio(int numDormitorio) {
		this.numDormitorio = numDormitorio;
	}

	public Condicion getCondicion() {
		return condicion;
	}

	public void setCondicion(Condicion condicion) {
		this.condicion = condicion;
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

	public Interesado getInteresado() {
		return interesado;
	}

	public void setInteresado(Interesado interesado) {
		this.interesado = interesado;
	}

	public Publicacion getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
}