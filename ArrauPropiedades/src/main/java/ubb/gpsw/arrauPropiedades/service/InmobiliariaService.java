package ubb.gpsw.arrauPropiedades.service;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ubb.gpsw.arrauPropiedades.model.Inmobiliaria;
import ubb.gpsw.arrauPropiedades.utilidades.Respuesta;

public interface InmobiliariaService extends Respuesta<Inmobiliaria, Integer> {

	boolean pdfInmobiliaria(List<Inmobiliaria> inmobiliarias, ServletContext context, HttpServletRequest request,
			HttpServletResponse response);

	boolean excelInmobiliaria(List<Inmobiliaria> inmobiliarias, ServletContext context, HttpServletRequest request,
			HttpServletResponse response);

}
