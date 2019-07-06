package ubb.gpsw.arrauPropiedades.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import ubb.gpsw.arrauPropiedades.model.EstadoPropiedad;
import ubb.gpsw.arrauPropiedades.repository.EstadoPropiedadRepository;
import ubb.gpsw.arrauPropiedades.utilidades.RespuestaService;



@Service
public class EstadoPropiedadServiceImpl extends RespuestaService<EstadoPropiedad, Integer> implements EstadoPropiedadService{
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private EstadoPropiedadRepository estadoRepo;
	
	@Override
	public CrudRepository<EstadoPropiedad, Integer> getDao() {
		return estadoRepo; 
	}
}
