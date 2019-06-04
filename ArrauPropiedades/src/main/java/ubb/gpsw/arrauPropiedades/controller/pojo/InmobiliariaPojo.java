package ubb.gpsw.arrauPropiedades.controller.pojo;

import ubb.gpsw.arrauPropiedades.model.Inmobiliaria;

public class InmobiliariaPojo {
	private int idInmobiliaria;
	private String nombre;
	private String correo;
	private String telefono;
	private String calle;
	private String numero;
	private String numDepa;
	private String ciudad;
	private String comuna;
	private String region;
	private String latitud;
	private String longitud;
	
	public InmobiliariaPojo() {
		super();
	}
	
	public InmobiliariaPojo(Inmobiliaria inmob) {
		super();
		this.idInmobiliaria = inmob.getIdInmobiliaria();
		this.nombre =inmob.getNombre();
		this.correo = inmob.getCorreo();
		this.telefono = inmob.getTelefono();
		this.calle = inmob.getCalle();
		this.numero = inmob.getNumero();
		this.numDepa = inmob.getNumDepartamento();
		this.ciudad = inmob.getCiudad();
		this.comuna = inmob.getComuna();
		this.region = inmob.getRegion();
		this.latitud = inmob.getLatitud();
		this.longitud = inmob.getLongitud();
	}
	
	public Inmobiliaria obtenerInmobiliaria() {
		final Inmobiliaria i = new Inmobiliaria();
		i.setIdInmobiliaria(this.idInmobiliaria);
		i.setNombre(this.nombre);
		i.setCorreo(this.correo);
		i.setTelefono(this.telefono);
		i.setCalle(this.calle);
		i.setNumero(this.numero);
		i.setNumDepartamento(this.numDepa);
		i.setCiudad(this.ciudad);
		i.setComuna(this.comuna);
		i.setRegion(this.region);
		i.setLatitud(this.latitud);
		i.setLongitud(this.longitud);
		return i;
	}

	public int getIdInmobiliaria() {
		return idInmobiliaria;
	}

	public void setIdInmobiliaria(int idInmobiliaria) {
		this.idInmobiliaria = idInmobiliaria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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

	public String getNumDepa() {
		return numDepa;
	}

	public void setNumDepa(String numDepa) {
		this.numDepa = numDepa;
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
	
	
}
