package ubb.gpsw.arrauPropiedades.service;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ubb.gpsw.arrauPropiedades.model.Destinacion;
import ubb.gpsw.arrauPropiedades.utilidades.Respuesta;

public interface DestinacionService extends Respuesta<Destinacion, Integer> {

	boolean pdfDestinacion(List<Destinacion> destinaciones, ServletContext context, HttpServletRequest request,
			HttpServletResponse response);

	boolean createExcel(List<Destinacion> destinaciones, ServletContext context, HttpServletRequest request,
			HttpServletResponse response);

}
