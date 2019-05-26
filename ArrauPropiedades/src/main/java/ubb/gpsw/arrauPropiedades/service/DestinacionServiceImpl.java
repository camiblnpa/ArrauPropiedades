package ubb.gpsw.arrauPropiedades.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import ubb.gpsw.arrauPropiedades.model.Destinacion;
import ubb.gpsw.arrauPropiedades.repository.DestinacionRepository;
import ubb.gpsw.arrauPropiedades.utilidades.RespuestaService;

@Service
public class DestinacionServiceImpl extends RespuestaService<Destinacion,Integer> implements DestinacionService{
	
	@Autowired
	private DestinacionRepository destRepo;
	
	@Override
	public CrudRepository<Destinacion, Integer> getDao() {
		return destRepo;
	}

}
