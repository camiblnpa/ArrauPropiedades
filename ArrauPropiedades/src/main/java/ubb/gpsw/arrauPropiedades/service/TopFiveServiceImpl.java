package ubb.gpsw.arrauPropiedades.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import ubb.gpsw.arrauPropiedades.model.TopFive;
import ubb.gpsw.arrauPropiedades.repository.TopFiveRepository;
import ubb.gpsw.arrauPropiedades.utilidades.RespuestaService;

@Service
public class TopFiveServiceImpl extends RespuestaService<TopFive, String> implements TopFiveService{
	
	@PersistenceContext
	private EntityManager em;

	@Autowired
	private TopFiveRepository topRepo;

	@Override
	public CrudRepository<TopFive, String> getDao() {
		return topRepo;
	}
}
