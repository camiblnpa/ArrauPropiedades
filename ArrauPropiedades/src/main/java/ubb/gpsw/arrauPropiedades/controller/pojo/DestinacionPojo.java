package ubb.gpsw.arrauPropiedades.controller.pojo;

import java.util.Date;

import ubb.gpsw.arrauPropiedades.model.Destinacion;

public class DestinacionPojo {
	private int idDestinacion;
	private Date fechaVenta;
	private Date fechaRegistro;
	private String tipoDestinacion;
	
	public DestinacionPojo() {
		super();
	}
	
	public DestinacionPojo(Destinacion dest) {
		super();
		this.idDestinacion = dest.getIdDestinacion();
		this.fechaVenta = dest.getFechaVenta();
		this.fechaRegistro = dest.getFechaRegistro();
		this.tipoDestinacion = dest.getTipoDestinacion();
	}
	
	public Destinacion obtenerDestinacion() {
		final Destinacion d = new Destinacion();
		d.setIdDestinacion(this.idDestinacion);
		d.setFechaVenta(this.fechaVenta);
		d.setFechaRegistro(this.fechaRegistro);
		d.setTipoDestinacion(this.tipoDestinacion);
		return d;
	}

	public int getIdDestinacion() {
		return idDestinacion;
	}

	public void setIdDestinacion(int idDestinacion) {
		this.idDestinacion = idDestinacion;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getTipoDestinacion() {
		return tipoDestinacion;
	}

	public void setTipoDestinacion(String tipoDestinacion) {
		this.tipoDestinacion = tipoDestinacion;
	}
	
}
