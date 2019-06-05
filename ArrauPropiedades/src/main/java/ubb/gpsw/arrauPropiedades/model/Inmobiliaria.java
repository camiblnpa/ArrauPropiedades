package ubb.gpsw.arrauPropiedades.model;

import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the Inmobiliaria database table.
 * 
 */
@NamedQuery(name="Inmobiliaria.findAll", query="SELECT i FROM Inmobiliaria i")
@Entity
public class Inmobiliaria {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idInmobiliaria;

	private String calle;

	private String ciudad;

	private String comuna;

	private String correo;

	private String latitud;

	private String longitud;

	private String nombre;

	private String numDepartamento;

	private String numero;

	private String region;

	private String telefono;
	
	@OneToMany(mappedBy="inmobiliaria", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Propiedad> propiedades;

	public Inmobiliaria() {
	}
	
	//Constructor que es utilizado por PropiedadPojo
	public Inmobiliaria(String nombre) {
		super();
		this.nombre = nombre;
	}

	public int getIdInmobiliaria() {
		return this.idInmobiliaria;
	}

	public void setIdInmobiliaria(int idInmobiliaria) {
		this.idInmobiliaria = idInmobiliaria;
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

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Propiedad> getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(List<Propiedad> propiedades) {
		this.propiedades = propiedades;
	}

}