package ubb.gpsw.arrauPropiedades.controller.pojo;

import java.util.Objects;

import ubb.gpsw.arrauPropiedades.model.*;

public class PropiedadPojo {
	//Atributos con el mismo nombre que tiene el formulario html que crea Propiedad
	//Todos los atributos que estaran en la "vista"
	private int idPropiedad;
	private int precio;
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
	
	//Solo se mostrará el nombre de inmobiliaria asociada a propiedad
	private String nombreInmobiliaria;
	
	//Atributos de Tipo de propiedad
	private String nombreTipo;
	private String condicion;
	private String numBanio;
	private String numDormitorio;
	private String numEstacionamiento;
	
	//Atributo el cual muestra tipo de destinación (arriendo, venta, etc)
	private String destinacion;

	public PropiedadPojo() {
		super();
	}

	public PropiedadPojo(Propiedad propiedad) {
		super();
		this.idPropiedad = propiedad.getIdPropiedad();
		this.precio = propiedad.getPrecio();
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
		
		//Clase objectUtil proyecto SGP, utilize util.Objects, al parecer es lo mismo
		if(!Objects.isNull(propiedad.getInmobiliaria())) {
			this.nombreInmobiliaria = propiedad.getInmobiliaria().getNombre();
		}
		if(!Objects.isNull(propiedad.getTipoPropiedad())) {
			this.nombreTipo = propiedad.getTipoPropiedad().getNombreTipo();
			this.condicion = propiedad.getTipoPropiedad().getCondicion();
			this.numBanio = propiedad.getTipoPropiedad().getNumBanio();
			this.numDormitorio = propiedad.getTipoPropiedad().getNumDormitorio();
			this.numEstacionamiento = propiedad.getTipoPropiedad().getNumEstacionamiento();
		}
		if(!Objects.isNull(propiedad.getDestinacion())) {
			this.destinacion = propiedad.getDestinacion().getTipoDestinacion();
		}	
	}
	
	//Función para obtener datos de propiedad
	public Propiedad obtenerPropiedad() {
		final Propiedad p = new Propiedad();
		p.setIdPropiedad(this.idPropiedad);
		p.setPrecio(this.precio);
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
		
		//Verificar si está es la manera correcta de validar (objects)
		if(!Objects.isNull(this.nombreInmobiliaria)) {
			p.setInmobiliaria(new Inmobiliaria(this.nombreInmobiliaria));
		}
		if(!Objects.isNull(this.nombreTipo)) {
			p.setTipoPropiedad(new Tipo(this.nombreTipo, this.condicion, this.numBanio, this.numDormitorio, this.numEstacionamiento));
		}
		if(!Objects.isNull(this.destinacion)) {
			p.setDestinacion(new Destinacion(this.destinacion));
		}
	
		return p;
	}

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

	public String getNumBanio() {
		return numBanio;
	}

	public void setNumBanio(String numBanio) {
		this.numBanio = numBanio;
	}

	public String getNumDormitorio() {
		return numDormitorio;
	}

	public void setNumDormitorio(String numDormitorio) {
		this.numDormitorio = numDormitorio;
	}

	public String getNumEstacionamiento() {
		return numEstacionamiento;
	}

	public void setNumEstacionamiento(String numEstacionamiento) {
		this.numEstacionamiento = numEstacionamiento;
	}

	public String getDestinacion() {
		return destinacion;
	}

	public void setDestinacion(String destinacion) {
		this.destinacion = destinacion;
	}
	
	

}
