package ubb.gpsw.arrauPropiedades.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ubb.gpsw.arrauPropiedades.model.Destinacion;
import ubb.gpsw.arrauPropiedades.service.DestinacionService;

@Controller
public class PdfExcelController {

	@Autowired
	private DestinacionService destService;

	// Agregar para poder crear PDF
	@Autowired
	private ServletContext context;

/*	public String allDestinacion() {
		return null;
	}*/

	// API para crear destinacion.pdf
	@GetMapping(value = "/pdfDestinacion")
	public void pdfDestinacion(HttpServletRequest request, HttpServletResponse response) {

		List<Destinacion> destinaciones = destService.getAll();
		boolean isFlag = destService.pdfDestinacion(destinaciones, context, request, response);
		if (isFlag) {
			// La direccion debe ser la misma definida en serviceImpl
			String fullPath = request.getServletContext().getRealPath("/resources/reports/" + "destinaciones" + ".pdf"); //direccion debe ser la misma que en ServiceImpl
			filedownload(fullPath, response, "destinaciones.pdf");
		}

	}

	// API para crear archivo Excel
	@GetMapping(value = "/createExcel")
	public void createExcel(HttpServletRequest request, HttpServletResponse response) {
		List<Destinacion> destinaciones = destService.getAll();
		boolean isFlag = destService.createExcel(destinaciones, context, request, response);
		if(isFlag) {
			String fullPath = request.getServletContext().getRealPath("/resources/reports"+"destinaciones"+".xls"); //direccion debe ser la misma que en ServiceImpl
			filedownload(fullPath, response, "destinaciones.xls");
			
		}
	}

	//Descargar archivo
	private void filedownload(String fullPath, HttpServletResponse response, String fileName) {
		File file = new File(fullPath);
		final int BUFFER_SIZE = 4096;
		if (file.exists()) {
			try {
				FileInputStream inputStream = new FileInputStream(file);
				String mimeType = context.getMimeType(fullPath);
				response.setContentType(mimeType);
				response.setHeader("contente-disposition", "attachment; filename=" + fileName);
				OutputStream outputStream = response.getOutputStream();
				byte[] buffer = new byte[BUFFER_SIZE];
				int bytesRead = -1;
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}
				inputStream.close();
				outputStream.close();
				file.delete();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
