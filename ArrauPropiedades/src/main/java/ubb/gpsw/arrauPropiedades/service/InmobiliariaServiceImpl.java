package ubb.gpsw.arrauPropiedades.service;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import ubb.gpsw.arrauPropiedades.utilidades.RespuestaService;
import ubb.gpsw.arrauPropiedades.model.Inmobiliaria;
import ubb.gpsw.arrauPropiedades.repository.InmobiliariaRepository;

@Service
public class InmobiliariaServiceImpl extends RespuestaService<Inmobiliaria, Integer> implements InmobiliariaService{
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private InmobiliariaRepository intPropRepo1;
	
	@Override
	public CrudRepository<Inmobiliaria, Integer> getDao() {
		return intPropRepo1; 
	}
}
