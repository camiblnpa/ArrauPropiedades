package ubb.gpsw.arrauPropiedades.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import ubb.gpsw.arrauPropiedades.model.Interesado;
import ubb.gpsw.arrauPropiedades.utilidades.RespuestaService;
import ubb.gpsw.arrauPropiedades.repository.InteresadoRepository;

@Service
public class InteresadoServiceImpl extends RespuestaService<Interesado, Integer> implements InteresadoService {
	
	@Autowired
	private InteresadoRepository intRepo;
	
	@Override
	public CrudRepository<Interesado, Integer> getDao() {
		return intRepo; 
	}
	
}
