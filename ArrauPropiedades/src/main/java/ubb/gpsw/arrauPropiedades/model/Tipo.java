package ubb.gpsw.arrauPropiedades.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQuery(name="Tipo.findAll", query="SELECT t FROM Tipo t")
public class Tipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTipo;

	private String nombreTipo;
	
	public Tipo() {	
	}

	public Tipo(int idTipo) {
		super();
		this.idTipo = idTipo;
	}

	public int getIdTipo() {
		return this.idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public String getNombreTipo() {
		return this.nombreTipo;
	}

	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}

}