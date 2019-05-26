package ubb.gpsw.arrauPropiedades.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import ubb.gpsw.arrauPropiedades.model.InteresadoPropiedad;
import ubb.gpsw.arrauPropiedades.repository.InteresadoPropiedadRepository;
import ubb.gpsw.arrauPropiedades.utilidades.RespuestaService;

@Service
public class InteresadoPropiedadServiceImpl extends RespuestaService<InteresadoPropiedad, Integer> implements InteresadoPropiedadService{

	@Autowired
	private InteresadoPropiedadRepository intPropRepo;
	
	@Override
	public CrudRepository<InteresadoPropiedad, Integer> getDao() {
		return intPropRepo; 
	}
	
}
