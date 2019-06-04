package ubb.gpsw.arrauPropiedades.controller.pojo;

import ubb.gpsw.arrauPropiedades.model.Tipo;

public class TipoPropiedadPojo {
	private int idTipo;
	private String nombreTipo;
	private String condicion;
	private String numBanio;
	private String numEstac;
	private String numDorm;
	
	public TipoPropiedadPojo() {
	super();
	}
	
	public TipoPropiedadPojo(Tipo tipo) {
		super();
		this.idTipo = tipo.getIdTipo();
		this.nombreTipo = tipo.getNombreTipo();
		this.condicion = tipo.getCondicion();
		this.numBanio = tipo.getNumBanio();
		this.numEstac = tipo.getNumEstacionamiento();
		this.numDorm = tipo.getNumDormitorio();
	}
	
	public Tipo obtenerTipo() {
		final Tipo t = new Tipo();
		t.setIdTipo(this.idTipo);
		t.setNombreTipo(this.nombreTipo);
		t.setCondicion(this.condicion);
		t.setNumBanio(this.numBanio);
		t.setNumEstacionamiento(this.numEstac);
		t.setNumDormitorio(this.numDorm);
		return t;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
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

	public String getNumEstac() {
		return numEstac;
	}

	public void setNumEstac(String numEstac) {
		this.numEstac = numEstac;
	}

	public String getNumDorm() {
		return numDorm;
	}

	public void setNumDorm(String numDorm) {
		this.numDorm = numDorm;
	}
	
	
}
