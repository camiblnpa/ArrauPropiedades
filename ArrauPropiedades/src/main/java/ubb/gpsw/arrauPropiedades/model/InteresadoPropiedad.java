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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idInteresadoPropiedad;

	@Temporal(TemporalType.DATE)
	private Date fechaContacto;

	private int interesado;

	private int propiedad;

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

	public int getInteresado() {
		return this.interesado;
	}

	public void setInteresado(int interesado) {
		this.interesado = interesado;
	}

	public int getPropiedad() {
		return this.propiedad;
	}

	public void setPropiedad(int propiedad) {
		this.propiedad = propiedad;
	}

}