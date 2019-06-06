package ubb.gpsw.arrauPropiedades.model;

import java.io.Serializable;
import javax.persistence.*;


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

	private String latitud;

	private String longitud;

	private String numDepartamento;

	private String numero;

	private int precio;

	private String region;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Inmobiliaria inmobiliaria;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Tipo tipo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Destinacion destinacion;

	public Propiedad() {
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

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public String getLatitud() {
		return this.latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return this.longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
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

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

}