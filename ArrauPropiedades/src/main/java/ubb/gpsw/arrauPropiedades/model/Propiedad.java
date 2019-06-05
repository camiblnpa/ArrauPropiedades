package ubb.gpsw.arrauPropiedades.model;

import javax.persistence.*;

/**
 * The persistent class for the Propiedad database table.
 * 
 */
@NamedQuery(name="Propiedad.findAll", query="SELECT p FROM Propiedad p")
@Entity
public class Propiedad {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	//RELACIONES
	
	// Modificado de un int a objeto Inmobiliaria, tipoPropiedad y destinacion
	@ManyToOne(fetch = FetchType.EAGER)
	private Inmobiliaria inmobiliaria;
	@ManyToOne(fetch = FetchType.EAGER)
	private Tipo tipoPropiedad;
	@ManyToOne(fetch = FetchType.EAGER)
	private Destinacion destinacion;

	
	public Propiedad() {
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

	public Inmobiliaria getInmobiliaria() {
		return inmobiliaria;
	}

	public void setInmobiliaria(Inmobiliaria inmobiliaria) {
		this.inmobiliaria = inmobiliaria;
	}

	public Tipo getTipoPropiedad() {
		return tipoPropiedad;
	}

	public void setTipoPropiedad(Tipo tipoPropiedad) {
		this.tipoPropiedad = tipoPropiedad;
	}

	public Destinacion getDestinacion() {
		return destinacion;
	}

	public void setDestinacion(Destinacion destinacion) {
		this.destinacion = destinacion;
	}

}