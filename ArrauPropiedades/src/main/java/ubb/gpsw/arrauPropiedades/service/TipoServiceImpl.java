package ubb.gpsw.arrauPropiedades.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import ubb.gpsw.arrauPropiedades.model.Tipo;
import ubb.gpsw.arrauPropiedades.repository.TipoRepository;
import ubb.gpsw.arrauPropiedades.utilidades.RespuestaService;

@Service
public class TipoServiceImpl extends RespuestaService<Tipo,Integer> implements TipoService{
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private TipoRepository tipoRepo;
	
	//Funcion que guardar, actualiza y borra Tipo
	@Override
	public CrudRepository<Tipo, Integer> getDao() {
		return tipoRepo;
	}

}