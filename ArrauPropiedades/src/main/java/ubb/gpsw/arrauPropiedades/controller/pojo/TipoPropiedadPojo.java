package ubb.gpsw.arrauPropiedades.controller.pojo;

import ubb.gpsw.arrauPropiedades.model.Tipo;

public class TipoPropiedadPojo {
	private int idTipo;
	private String nombreTipo;
	private String condicion;

	
	public TipoPropiedadPojo() {
	super();
	}
	
	public TipoPropiedadPojo(Tipo tipo) {
		super();
		this.idTipo = tipo.getIdTipo();
		this.nombreTipo = tipo.getNombreTipo();
		this.condicion = tipo.getCondicion();

	}
	
	public Tipo obtenerTipo() {
		final Tipo t = new Tipo();
		t.setIdTipo(this.idTipo);
		t.setNombreTipo(this.nombreTipo);
		t.setCondicion(this.condicion);

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


	
	
}
