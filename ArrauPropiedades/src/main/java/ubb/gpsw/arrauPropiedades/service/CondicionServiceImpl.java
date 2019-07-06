package ubb.gpsw.arrauPropiedades.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import ubb.gpsw.arrauPropiedades.model.Condicion;
import ubb.gpsw.arrauPropiedades.repository.CondicionRepository;
import ubb.gpsw.arrauPropiedades.utilidades.RespuestaService;

@Service
public class CondicionServiceImpl extends RespuestaService<Condicion, Integer> implements CondicionService {
	
	@PersistenceContext
	private EntityManager em;

	@Autowired
	private CondicionRepository condRepo;

	@Override
	public CrudRepository<Condicion, Integer> getDao() {
		return condRepo;
	}
}
