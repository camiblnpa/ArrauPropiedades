package ubb.gpsw.arrauPropiedades.service;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ubb.gpsw.arrauPropiedades.model.Propiedad;
import ubb.gpsw.arrauPropiedades.utilidades.Respuesta;

public interface PropiedadService extends Respuesta<Propiedad, Integer> {

	boolean pdfPropiedades(List<Propiedad> propiedades, ServletContext context, HttpServletRequest request,
			HttpServletResponse response);

	boolean excelPropiedades(List<Propiedad> propiedades, ServletContext context, HttpServletRequest request,
			HttpServletResponse response);

}
