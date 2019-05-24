package ubb.gpsw.arrauPropiedades.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Interesado database table.
 * 
 */
@Entity
@NamedQuery(name="Interesado.findAll", query="SELECT i FROM Interesado i")
public class Interesado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idInteresado;

	private String correo;

	private String nombre;

	private String telefono;

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

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}