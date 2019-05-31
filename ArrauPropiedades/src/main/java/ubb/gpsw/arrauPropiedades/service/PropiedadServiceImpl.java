package ubb.gpsw.arrauPropiedades.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import ubb.gpsw.arrauPropiedades.controller.pojo.PropiedadPojo;
import ubb.gpsw.arrauPropiedades.model.Propiedad;
import ubb.gpsw.arrauPropiedades.service.PropiedadService;
import ubb.gpsw.arrauPropiedades.utilidades.RespuestaService;
import ubb.gpsw.arrauPropiedades.repository.PropiedadRepository;

@Service
public class PropiedadServiceImpl extends RespuestaService<Propiedad, Integer> implements  PropiedadService{

	@Autowired
	private PropiedadRepository propService;
	
	@PersistenceContext
	private EntityManager em;
		
	@Override
	public List<PropiedadPojo> findAll() {
		//TODO Auto-generated method stub
		return null;
	}

	@Override
	public CrudRepository<Propiedad, Integer> getDao() {
		return propService;
	}
}
