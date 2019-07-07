package ubb.gpsw.arrauPropiedades.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import ubb.gpsw.arrauPropiedades.utilidades.RespuestaService;

import ubb.gpsw.arrauPropiedades.model.Propiedad;
import ubb.gpsw.arrauPropiedades.repository.PropiedadRepository;

@Service
public class PropiedadServiceImpl extends RespuestaService<Propiedad, Integer> implements PropiedadService {

	@Autowired
	private PropiedadRepository propRepo;
	
	@Override
	public CrudRepository<Propiedad, Integer> getDao() {

		return propRepo;
	}

}
