package ubb.gpsw.arrauPropiedades.service;

import java.util.List;

import ubb.gpsw.arrauPropiedades.controller.pojo.PropiedadPojo;
import ubb.gpsw.arrauPropiedades.model.Propiedad;

public interface PropiedadService {

	List<Propiedad> findAll();

	void save(Propiedad p);

	Propiedad findById(Integer id);
	
	
}
