package ubb.gpsw.arrauPropiedades.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "TopFive")
public class TopFive {
	
	@Id
	private int idPropiedad;
	
	private int interesados;
	
	private String nombrePropiedad;
	
	private String region;
	
	private String comuna;
	
	private int precio;

	public int getInteresados() {
		return interesados;
	}

	public void setInteresados(int interesados) {
		this.interesados = interesados;
	}

	public String getNombrePropiedad() {
		return nombrePropiedad;
	}

	public void setNombrePropiedad(String nombrePropiedad) {
		this.nombrePropiedad = nombrePropiedad;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	
}
