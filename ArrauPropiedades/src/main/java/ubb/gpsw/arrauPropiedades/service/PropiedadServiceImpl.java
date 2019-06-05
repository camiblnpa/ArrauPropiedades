package ubb.gpsw.arrauPropiedades.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import ubb.gpsw.arrauPropiedades.controller.pojo.PropiedadPojo;
import ubb.gpsw.arrauPropiedades.model.Propiedad;
import ubb.gpsw.arrauPropiedades.service.PropiedadService;
import ubb.gpsw.arrauPropiedades.utilidades.RespuestaService;
import ubb.gpsw.arrauPropiedades.repository.PropiedadRepository;

@Service
public class PropiedadServiceImpl implements  PropiedadService{

	@Autowired
	private PropiedadRepository propService;
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<PropiedadPojo> findAll() {
		StringBuilder sql = new StringBuilder("Select new ubb.gpsw.arrauPropiedades.controller.pojo.PropiedadPojo(dp) ");
		sql.append("from Propiedad dp");
		Query q = em.createQuery(sql.toString());
		List<PropiedadPojo> listaProp = (List<PropiedadPojo>)q.getResultList();
		return listaProp;
		
	}
	
	@Override
	public void save(Propiedad p) {
		propService.save(p);
	}

	@Override
	public Propiedad findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
