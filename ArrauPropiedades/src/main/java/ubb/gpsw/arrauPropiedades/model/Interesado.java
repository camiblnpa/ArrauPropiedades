package ubb.gpsw.arrauPropiedades.model;

import javax.persistence.*;

@Entity
//@NamedQuery(name="Interesado.findAll", query="SELECT i FROM Interesado i")
public class Interesado {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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