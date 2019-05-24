package ubb.gpsw.arrauPropiedades.utilidades;

import java.io.Serializable;
import java.util.List;

public interface Respuesta<T, ID extends Serializable>{
	/*
	 * T es la entidad que se pasa por parametro
	 * ID es el id tipo Integer que se pasa por parametro 
	 */
	
	T save(T entity);
	
	void delete (ID id);
	
	T get(ID id);
	
	List<T> getAll();

}
