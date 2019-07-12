package ubb.gpsw.arrauPropiedades.utilidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import ubb.gpsw.arrauPropiedades.model.Destinacion;
import ubb.gpsw.arrauPropiedades.model.Propiedad;

@Service
public abstract class RespuestaService<T, ID extends Serializable> implements Respuesta<T, ID> {

	@Override
	public T save(T entity) {
		
		return getDao().save(entity);
	}

	@Override
	public void delete(ID id) {
		getDao().deleteById(id);
	}

	@Override
	public T get(ID id) {
		Optional<T> obj = getDao().findById(id);
		if(obj.isPresent()) {
			return obj.get();
		}
		return null;
	}

	@Override
	public List<T> getAll() {
		List<T> returnList = new ArrayList<>();
		getDao().findAll().forEach(obj -> returnList.add(obj));		
		return returnList;
	}
	
	public abstract CrudRepository<T, ID> getDao();
	
	public boolean pdfPropiedades(List<Propiedad> propiedades, ServletContext context, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean pdfDestinacion(List<Destinacion> destinaciones, ServletContext context, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean createExcel(List<Destinacion> destinaciones, ServletContext context, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
