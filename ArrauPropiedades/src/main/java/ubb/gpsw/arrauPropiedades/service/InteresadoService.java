package ubb.gpsw.arrauPropiedades.service;

import java.util.List;

import ubb.gpsw.arrauPropiedades.model.Interesado;
import ubb.gpsw.arrauPropiedades.utilidades.Respuesta;

public interface InteresadoService extends Respuesta<Interesado, Integer> {
	
	List<Interesado> findAll();

}
