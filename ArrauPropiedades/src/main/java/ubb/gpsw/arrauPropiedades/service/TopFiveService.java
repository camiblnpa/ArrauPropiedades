package ubb.gpsw.arrauPropiedades.service;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ubb.gpsw.arrauPropiedades.model.TopFive;
import ubb.gpsw.arrauPropiedades.utilidades.Respuesta;

public interface TopFiveService extends Respuesta<TopFive, String>{

	boolean pdfTopFive(List<TopFive> topFive, ServletContext context, HttpServletRequest request,
			HttpServletResponse response);

	boolean excelTopFive(List<TopFive> topFive, ServletContext context, HttpServletRequest request,
			HttpServletResponse response);

}
