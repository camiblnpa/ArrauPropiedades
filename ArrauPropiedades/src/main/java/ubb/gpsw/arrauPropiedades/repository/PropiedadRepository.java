package ubb.gpsw.arrauPropiedades.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ubb.gpsw.arrauPropiedades.controller.pojo.PropiedadPojo;
import ubb.gpsw.arrauPropiedades.model.Propiedad;


public interface PropiedadRepository extends CrudRepository<Propiedad, Integer> {

}
