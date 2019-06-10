package ubb.gpsw.arrauPropiedades.controller.pojo;

import java.util.Objects;

import ubb.gpsw.arrauPropiedades.model.*;

public class PropiedadPojo {
	// Atributos con el mismo nombre que tiene el formulario html que crea Propiedad
	// Todos los atributos que estaran en la "vista"
	private int idPropiedad;
	private int precio;
	private String descripcion;
	private int dimTerreno;
	private int dimConstruccion;
	private String calle;
	private String numero;
	private String numDepartamento;
	private String ciudad;
	private String comuna;
	private String region;
	private String latitud;
	private String longitud;

	// Solo se mostrará el nombre de inmobiliaria asociada a propiedad
	private int idInmobiliaria;
	private String nombreInmobiliaria;

	// Atributos de Tipo de propiedad
	private int idTipo;
	private String nombreTipo;
	private String condicion;
	private int numBanio;
	private int numDormitorio;
	private int numEstacionamiento;

	// Atributo el cual muestra tipo de destinación (arriendo, venta, etc)
	private int idDestinacion;
	private String destinacion;

	// Costructor vacio
	public PropiedadPojo() {
		super();
	}

	// Constructor de Propiedad
	public PropiedadPojo(Propiedad propiedad) {
		super();
		this.idPropiedad = propiedad.getIdPropiedad();
		this.precio = propiedad.getPrecio();
		this.descripcion = propiedad.getDescripcion();
		this.dimTerreno = propiedad.getDimTerreno();
		this.dimConstruccion = propiedad.getDimConstruccion();
		this.calle = propiedad.getCalle();
		this.numero = propiedad.getNumero();
		this.numDepartamento = propiedad.getNumDepartamento();
		this.ciudad = propiedad.getCiudad();
		this.comuna = propiedad.getComuna();
		this.region = propiedad.getRegion();
		this.latitud = propiedad.getLatitud();
		this.longitud = propiedad.getLongitud();
		this.numBanio = propiedad.getNumBanio();
		this.numDormitorio = propiedad.getNumDormitorio();
		this.numEstacionamiento = propiedad.getNumEstacionamiento();

		// Clase objectUtil proyecto SGP, utilize util.Objects, al parecer es lo mismo
		if (!Objects.isNull(propiedad.getInmobiliaria())) {
			this.idInmobiliaria = propiedad.getInmobiliaria().getIdInmobiliaria();
			this.nombreInmobiliaria = propiedad.getInmobiliaria().getNombre();
		}
		if (!Objects.isNull(propiedad.getTipoPropiedad())) {
			this.idTipo = propiedad.getTipoPropiedad().getIdTipo();
			this.nombreTipo = propiedad.getTipoPropiedad().getNombreTipo();
			this.condicion = propiedad.getTipoPropiedad().getCondicion();

		}
		if (!Objects.isNull(propiedad.getDestinacion())) {
			this.idDestinacion = propiedad.getDestinacion().getIdDestinacion();
			this.destinacion = propiedad.getDestinacion().getTipoDestinacion();
		}
	}

	// Funcion para obtener datos de propiedad
	public Propiedad obtenerPropiedad() {
		final Propiedad p = new Propiedad();
		p.setIdPropiedad(this.idPropiedad);
		p.setPrecio(this.precio);
		p.setDescripcion(this.descripcion);
		p.setDimTerreno(this.dimTerreno);
		p.setDimConstruccion(this.dimConstruccion);
		p.setCalle(this.calle);
		p.setNumero(this.numero);
		p.setNumDepartamento(this.numDepartamento);
		p.setCiudad(this.ciudad);
		p.setComuna(this.comuna);
		p.setRegion(this.region);
		p.setLatitud(this.latitud);
		p.setLongitud(this.longitud);

		if (!Objects.isNull(this.nombreInmobiliaria)) {
			p.setInmobiliaria(new Inmobiliaria(this.idInmobiliaria, this.nombreInmobiliaria));
		}
		if (!Objects.isNull(this.nombreTipo)) {
			p.setTipoPropiedad(new Tipo( this.idTipo, this.nombreTipo, this.condicion));
		}
		if (!Objects.isNull(this.destinacion)) {
			p.setDestinacion(new Destinacion(this.idDestinacion, this.destinacion));
		}

		return p;
	}

	// Getter & Setters
	public int getIdPropiedad() {
		return idPropiedad;
	}

	public void setIdPropiedad(int idPropiedad) {
		this.idPropiedad = idPropiedad;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getDimTerreno() {
		return dimTerreno;
	}

	public void setDimTerreno(int dimTerreno) {
		this.dimTerreno = dimTerreno;
	}

	public int getDimConstruccion() {
		return dimConstruccion;
	}

	public void setDimConstruccion(int dimConstruccion) {
		this.dimConstruccion = dimConstruccion;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNumDepartamento() {
		return numDepartamento;
	}

	public void setNumDepartamento(String numDepartamento) {
		this.numDepartamento = numDepartamento;
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

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getNombreInmobiliaria() {
		return nombreInmobiliaria;
	}

	public void setNombreInmobiliaria(String nombreInmobiliaria) {
		this.nombreInmobiliaria = nombreInmobiliaria;
	}

	public String getNombreTipo() {
		return nombreTipo;
	}

	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	public int getNumBanio() {
		return numBanio;
	}

	public void setNumBanio(int numBanio) {
		this.numBanio = numBanio;
	}

	public int getNumDormitorio() {
		return numDormitorio;
	}

	public void setNumDormitorio(int numDormitorio) {
		this.numDormitorio = numDormitorio;
	}

	public int getNumEstacionamiento() {
		return numEstacionamiento;
	}

	public void setNumEstacionamiento(int numEstacionamiento) {
		this.numEstacionamiento = numEstacionamiento;
	}

	public String getDestinacion() {
		return destinacion;
	}

	public void setDestinacion(String destinacion) {
		this.destinacion = destinacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdInmobiliaria() {
		return idInmobiliaria;
	}

	public void setIdInmobiliaria(int idInmobiliaria) {
		this.idInmobiliaria = idInmobiliaria;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public int getIdDestinacion() {
		return idDestinacion;
	}

	public void setIdDestinacion(int idDestinacion) {
		this.idDestinacion = idDestinacion;
	}
	

}
