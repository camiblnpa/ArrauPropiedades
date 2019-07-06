package ubb.gpsw.arrauPropiedades.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import ubb.gpsw.arrauPropiedades.model.Publicacion;
import ubb.gpsw.arrauPropiedades.repository.PublicacionRepository;
import ubb.gpsw.arrauPropiedades.utilidades.RespuestaService;

@Service
public class PublicacionServiceImpl extends RespuestaService<Publicacion, Integer> implements PublicacionService {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private PublicacionRepository publiRepo;
	
	@Override
	public CrudRepository<Publicacion, Integer> getDao(){
		return publiRepo;
	}
}
