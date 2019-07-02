package ubb.gpsw.arrauPropiedades.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name="Interesado.findAll", query="SELECT i FROM Interesado i")
public class Interesado implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idInteresado;

	private String correo;

	private String nombre;

	private int telefono;
	
	/*
	 * Relación
	 */
	@OneToMany(mappedBy = "interesado", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Propiedad> propiedades;

	public Interesado() {
	}
	
	public Interesado(int id) {
		this.idInteresado = id;
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

}