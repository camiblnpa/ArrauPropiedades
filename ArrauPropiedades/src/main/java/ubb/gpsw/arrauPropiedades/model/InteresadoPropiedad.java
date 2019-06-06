package ubb.gpsw.arrauPropiedades.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the InteresadoPropiedad database table.
 * 
 */
@Entity
@NamedQuery(name="InteresadoPropiedad.findAll", query="SELECT i FROM InteresadoPropiedad i")
public class InteresadoPropiedad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idInteresadoPropiedad;

	@Temporal(TemporalType.DATE)
	private Date fechaContacto;

	private int interesado_idInteresado;

	private int propiedad_idPropiedad;

	public InteresadoPropiedad() {
	}

	public int getIdInteresadoPropiedad() {
		return this.idInteresadoPropiedad;
	}

	public void setIdInteresadoPropiedad(int idInteresadoPropiedad) {
		this.idInteresadoPropiedad = idInteresadoPropiedad;
	}

	public Date getFechaContacto() {
		return this.fechaContacto;
	}

	public void setFechaContacto(Date fechaContacto) {
		this.fechaContacto = fechaContacto;
	}

	public int getInteresado_idInteresado() {
		return this.interesado_idInteresado;
	}

	public void setInteresado_idInteresado(int interesado_idInteresado) {
		this.interesado_idInteresado = interesado_idInteresado;
	}

	public int getPropiedad_idPropiedad() {
		return this.propiedad_idPropiedad;
	}

	public void setPropiedad_idPropiedad(int propiedad_idPropiedad) {
		this.propiedad_idPropiedad = propiedad_idPropiedad;
	}

}