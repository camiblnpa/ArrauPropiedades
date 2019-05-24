package ubb.gpsw.arrauPropiedades.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ubb.gpsw.arrauPropiedades.model.Interesado;

@Repository
public interface InteresadoRepository extends CrudRepository<Interesado, Integer>{

}
