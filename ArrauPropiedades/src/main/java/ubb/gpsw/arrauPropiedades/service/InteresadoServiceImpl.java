package ubb.gpsw.arrauPropiedades.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import ubb.gpsw.arrauPropiedades.model.Interesado;
import ubb.gpsw.arrauPropiedades.utilidades.RespuestaService;
import ubb.gpsw.arrauPropiedades.repository.InteresadoRepository;

@Service
public class InteresadoServiceImpl extends RespuestaService<Interesado, Integer> implements InteresadoService {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private InteresadoRepository intRepo;
	
	@Override
	public CrudRepository<Interesado, Integer> getDao() {
		return intRepo; 
	}

	@Override
	public List<Interesado> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	

}
