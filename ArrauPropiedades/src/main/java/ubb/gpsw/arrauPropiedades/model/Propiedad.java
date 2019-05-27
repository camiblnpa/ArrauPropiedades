package ubb.gpsw.arrauPropiedades.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Propiedad database table.
 * 
 */
@Entity
//@NamedQuery(name="Propiedad.findAll", query="SELECT p FROM Propiedad p")
public class Propiedad {
	//private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

	private int inmobiliaria;

	private int tipoPropiedad;

	private int destinacion;



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

	public int getDestinacion() {
		return this.destinacion;
	}

	public void setDestinacion(int destinacion) {
		this.destinacion = destinacion;
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

	public int getInmobiliaria() {
		return this.inmobiliaria;
	}

	public void setInmobiliaria(int inmobiliaria) {
		this.inmobiliaria = inmobiliaria;
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

	public int getTipoPropiedad() {
		return this.tipoPropiedad;
	}

	public void setTipoPropiedad(int tipoPropiedad) {
		this.tipoPropiedad = tipoPropiedad;
	}

}