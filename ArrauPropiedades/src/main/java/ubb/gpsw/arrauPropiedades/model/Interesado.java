package ubb.gpsw.arrauPropiedades.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


/**
 * The persistent class for the Interesado database table.
 * 
 */
@Entity
@NamedQuery(name="Interesado.findAll", query="SELECT i FROM Interesado i")
public class Interesado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idInteresado;

	@NotEmpty
	private String correo;

	@NotEmpty
	private String nombre;

	@NotEmpty
	private int telefono;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="propiedad_idPropiedad")
	private Propiedad propiedad;

	public Interesado() {
	}

	public int getIdInteresado() {
		return this.idInteresado;
	}

	public void setIdInteresado(int idInteresado) {
		this.idInteresado = idInteresado;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return this.telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}
	
}