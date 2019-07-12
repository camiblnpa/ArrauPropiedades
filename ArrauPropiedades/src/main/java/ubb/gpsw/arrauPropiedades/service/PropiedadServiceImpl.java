package ubb.gpsw.arrauPropiedades.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import ubb.gpsw.arrauPropiedades.utilidades.RespuestaService;
import ubb.gpsw.arrauPropiedades.model.Propiedad;
import ubb.gpsw.arrauPropiedades.repository.PropiedadRepository;

@Service
public class PropiedadServiceImpl extends RespuestaService<Propiedad, Integer> implements PropiedadService {

	@Autowired
	private PropiedadRepository propRepo;

	// Funcion que guardar, actualiza y borra Propiedad
	@Override
	public CrudRepository<Propiedad, Integer> getDao() {

		return propRepo;
	}

	// Crear PDF para Propiedades
	@Override
	public boolean pdfPropiedades(List<Propiedad> propiedades, ServletContext context, HttpServletRequest request,
			HttpServletResponse response) {
		Document document = new Document(PageSize.A4, 5, 5, 45, 30);
		try {
			String filePath = context.getRealPath("/resources/reports");
			File file = new File(filePath);
			boolean exists = new File(filePath).exists();
			if (!exists) {
				new File(filePath).mkdirs();
			}

			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream(file + "/" + "propiedades" + ".pdf"));
			document.open();

			Font mainFont = FontFactory.getFont("Arial", 10, BaseColor.BLACK);

			Paragraph paragraph = new Paragraph("Todos las propiedades", mainFont);
			paragraph.setAlignment(Element.ALIGN_CENTER);
			paragraph.setIndentationLeft(50);
			paragraph.setIndentationRight(50);
			paragraph.setSpacingAfter(10);
			document.add(paragraph);

			PdfPTable table = new PdfPTable(12); // Cuantas columnas tendrá la tabla
			table.setWidthPercentage(100);
			table.setSpacingBefore(10f);
			table.setSpacingAfter(10);

			Font tableHeader = FontFactory.getFont("Arial", 9, BaseColor.BLACK);
			Font tableBody = FontFactory.getFont("Arial", 8, BaseColor.BLACK);

			float[] columnWidths = { 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f };// Definir la cantidad de veces que repite 2f de acuerdo a las columnas
			table.setWidths(columnWidths);

			PdfPCell idPropiedad = new PdfPCell(new Paragraph("ID", tableHeader));
			idPropiedad.setBorderColor(BaseColor.BLACK);
			idPropiedad.setPaddingLeft(1);
			idPropiedad.setHorizontalAlignment(Element.ALIGN_CENTER);
			idPropiedad.setVerticalAlignment(Element.ALIGN_CENTER);
			idPropiedad.setBackgroundColor(BaseColor.GRAY);
			idPropiedad.setExtraParagraphSpace(5f);
			table.addCell(idPropiedad);

			PdfPCell tipo = new PdfPCell(new Paragraph("Tipo", tableHeader));
			tipo.setBorderColor(BaseColor.BLACK);
			tipo.setPaddingLeft(1);
			tipo.setHorizontalAlignment(Element.ALIGN_CENTER);
			tipo.setVerticalAlignment(Element.ALIGN_CENTER);
			tipo.setBackgroundColor(BaseColor.GRAY);
			tipo.setExtraParagraphSpace(5f);
			table.addCell(tipo);

			PdfPCell destinacion = new PdfPCell(new Paragraph("Destinación", tableHeader));
			destinacion.setBorderColor(BaseColor.BLACK);
			destinacion.setPaddingLeft(1);
			destinacion.setHorizontalAlignment(Element.ALIGN_CENTER);
			destinacion.setVerticalAlignment(Element.ALIGN_CENTER);
			destinacion.setBackgroundColor(BaseColor.GRAY);
			destinacion.setExtraParagraphSpace(5f);
			table.addCell(destinacion);

			PdfPCell condicion = new PdfPCell(new Paragraph("Condición", tableHeader));
			condicion.setBorderColor(BaseColor.BLACK);
			condicion.setPaddingLeft(1);
			condicion.setHorizontalAlignment(Element.ALIGN_CENTER);
			condicion.setVerticalAlignment(Element.ALIGN_CENTER);
			condicion.setBackgroundColor(BaseColor.GRAY);
			condicion.setExtraParagraphSpace(5f);
			table.addCell(condicion);

			PdfPCell region = new PdfPCell(new Paragraph("Región", tableHeader));
			region.setBorderColor(BaseColor.BLACK);
			region.setPaddingLeft(1);
			region.setHorizontalAlignment(Element.ALIGN_CENTER);
			region.setVerticalAlignment(Element.ALIGN_CENTER);
			region.setBackgroundColor(BaseColor.GRAY);
			region.setExtraParagraphSpace(5f);
			table.addCell(region);

			PdfPCell comuna = new PdfPCell(new Paragraph("Comuna", tableHeader));
			comuna.setBorderColor(BaseColor.BLACK);
			comuna.setPaddingLeft(1);
			comuna.setHorizontalAlignment(Element.ALIGN_CENTER);
			comuna.setVerticalAlignment(Element.ALIGN_CENTER);
			comuna.setBackgroundColor(BaseColor.GRAY);
			comuna.setExtraParagraphSpace(5f);
			table.addCell(comuna);

/*			PdfPCell calle = new PdfPCell(new Paragraph("Calle", tableHeader));
			calle.setBorderColor(BaseColor.BLACK);
			calle.setPaddingLeft(1);
			calle.setHorizontalAlignment(Element.ALIGN_CENTER);
			calle.setVerticalAlignment(Element.ALIGN_CENTER);
			calle.setBackgroundColor(BaseColor.GRAY);
			calle.setExtraParagraphSpace(5f);
			table.addCell(calle);

			PdfPCell numero = new PdfPCell(new Paragraph("Numero", tableHeader));
			numero.setBorderColor(BaseColor.BLACK);
			numero.setPaddingLeft(1);
			numero.setHorizontalAlignment(Element.ALIGN_CENTER);
			numero.setVerticalAlignment(Element.ALIGN_CENTER);
			numero.setBackgroundColor(BaseColor.GRAY);
			numero.setExtraParagraphSpace(5f);
			table.addCell(numero);*/

			PdfPCell numBanio = new PdfPCell(new Paragraph("Baños", tableHeader));
			numBanio.setBorderColor(BaseColor.BLACK);
			numBanio.setPaddingLeft(1);
			numBanio.setHorizontalAlignment(Element.ALIGN_CENTER);
			numBanio.setVerticalAlignment(Element.ALIGN_CENTER);
			numBanio.setBackgroundColor(BaseColor.GRAY);
			numBanio.setExtraParagraphSpace(5f);
			table.addCell(numBanio);

			PdfPCell numDorm = new PdfPCell(new Paragraph("Dormitorios", tableHeader));
			numDorm.setBorderColor(BaseColor.BLACK);
			numDorm.setPaddingLeft(1);
			numDorm.setHorizontalAlignment(Element.ALIGN_CENTER);
			numDorm.setVerticalAlignment(Element.ALIGN_CENTER);
			numDorm.setBackgroundColor(BaseColor.GRAY);
			numDorm.setExtraParagraphSpace(5f);
			table.addCell(numDorm);
			
			PdfPCell numEstac = new PdfPCell(new Paragraph("Estacionamientos", tableHeader));
			numEstac.setBorderColor(BaseColor.BLACK);
			numEstac.setPaddingLeft(1);
			numEstac.setHorizontalAlignment(Element.ALIGN_CENTER);
			numEstac.setVerticalAlignment(Element.ALIGN_CENTER);
			numEstac.setBackgroundColor(BaseColor.GRAY);
			numEstac.setExtraParagraphSpace(5f);
			table.addCell(numEstac);
			
			PdfPCell dimTerr = new PdfPCell(new Paragraph("Área Terreno (m²)", tableHeader));
			dimTerr.setBorderColor(BaseColor.BLACK);
			dimTerr.setPaddingLeft(1);
			dimTerr.setHorizontalAlignment(Element.ALIGN_CENTER);
			dimTerr.setVerticalAlignment(Element.ALIGN_CENTER);
			dimTerr.setBackgroundColor(BaseColor.GRAY);
			dimTerr.setExtraParagraphSpace(5f);
			table.addCell(dimTerr);
			
			PdfPCell dimCons = new PdfPCell(new Paragraph("Área Construida (m²)", tableHeader));
			dimCons.setBorderColor(BaseColor.BLACK);
			dimCons.setPaddingLeft(1);
			dimCons.setHorizontalAlignment(Element.ALIGN_CENTER);
			dimCons.setVerticalAlignment(Element.ALIGN_CENTER);
			dimCons.setBackgroundColor(BaseColor.GRAY);
			dimCons.setExtraParagraphSpace(5f);
			table.addCell(dimCons);
			
			PdfPCell precio = new PdfPCell(new Paragraph("Precio", tableHeader));
			precio.setBorderColor(BaseColor.BLACK);
			precio.setPaddingLeft(1);
			precio.setHorizontalAlignment(Element.ALIGN_CENTER);
			precio.setVerticalAlignment(Element.ALIGN_CENTER);
			precio.setBackgroundColor(BaseColor.GRAY);
			precio.setExtraParagraphSpace(5f);
			table.addCell(precio);
			
			//Rellenar los datos
			for (Propiedad propiedad : propiedades) {
				PdfPCell idPropiedadValue = new PdfPCell(
						new Paragraph(String.valueOf(propiedad.getIdPropiedad()), tableBody));
				idPropiedadValue.setBorderColor(BaseColor.BLACK);
				idPropiedadValue.setPaddingLeft(10);
				idPropiedadValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				idPropiedadValue.setVerticalAlignment(Element.ALIGN_CENTER);
				idPropiedadValue.setBackgroundColor(BaseColor.WHITE);
				idPropiedadValue.setExtraParagraphSpace(5f);
				table.addCell(idPropiedadValue);

				PdfPCell tipoValue = new PdfPCell(new Paragraph(propiedad.getTipo().getNombreTipo(), tableBody));
				tipoValue.setBorderColor(BaseColor.BLACK);
				tipoValue.setPaddingLeft(10);
				tipoValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				tipoValue.setVerticalAlignment(Element.ALIGN_CENTER);
				tipoValue.setBackgroundColor(BaseColor.WHITE);
				tipoValue.setExtraParagraphSpace(5f);
				table.addCell(tipoValue);

				PdfPCell destinacionValue = new PdfPCell(
						new Paragraph(String.valueOf(propiedad.getDestinacion().getNombreDestinacion()), tableBody));
				destinacionValue.setBorderColor(BaseColor.BLACK);
				destinacionValue.setPaddingLeft(10);
				destinacionValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				destinacionValue.setVerticalAlignment(Element.ALIGN_CENTER);
				destinacionValue.setBackgroundColor(BaseColor.WHITE);
				destinacionValue.setExtraParagraphSpace(5f);
				table.addCell(destinacionValue);

				PdfPCell condicionValue = new PdfPCell(
						new Paragraph(String.valueOf(propiedad.getCondicion().getNombreCondicion()), tableBody));
				condicionValue.setBorderColor(BaseColor.BLACK);
				condicionValue.setPaddingLeft(10);
				condicionValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				condicionValue.setVerticalAlignment(Element.ALIGN_CENTER);
				condicionValue.setBackgroundColor(BaseColor.WHITE);
				condicionValue.setExtraParagraphSpace(5f);
				table.addCell(condicionValue);

				PdfPCell regionValue = new PdfPCell(new Paragraph(String.valueOf(propiedad.getRegion()), tableBody));
				regionValue.setBorderColor(BaseColor.BLACK);
				regionValue.setPaddingLeft(10);
				regionValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				regionValue.setVerticalAlignment(Element.ALIGN_CENTER);
				regionValue.setBackgroundColor(BaseColor.WHITE);
				regionValue.setExtraParagraphSpace(5f);
				table.addCell(regionValue);

				PdfPCell comunaValue = new PdfPCell(new Paragraph(String.valueOf(propiedad.getComuna()), tableBody));
				comunaValue.setBorderColor(BaseColor.BLACK);
				comunaValue.setPaddingLeft(10);
				comunaValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				comunaValue.setVerticalAlignment(Element.ALIGN_CENTER);
				comunaValue.setBackgroundColor(BaseColor.WHITE);
				comunaValue.setExtraParagraphSpace(5f);
				table.addCell(comunaValue);

/*				PdfPCell calleValue = new PdfPCell(new Paragraph(String.valueOf(propiedad.getCalle()), tableBody));
				calleValue.setBorderColor(BaseColor.BLACK);
				calleValue.setPaddingLeft(10);
				calleValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				calleValue.setVerticalAlignment(Element.ALIGN_CENTER);
				calleValue.setBackgroundColor(BaseColor.WHITE);
				calleValue.setExtraParagraphSpace(5f);
				table.addCell(calleValue);

				PdfPCell numeroValue = new PdfPCell(new Paragraph(String.valueOf(propiedad.getNumero()), tableBody));
				numeroValue.setBorderColor(BaseColor.BLACK);
				numeroValue.setPaddingLeft(10);
				numeroValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				numeroValue.setVerticalAlignment(Element.ALIGN_CENTER);
				numeroValue.setBackgroundColor(BaseColor.WHITE);
				numeroValue.setExtraParagraphSpace(5f);
				table.addCell(numeroValue);*/

				PdfPCell numBanioValue = new PdfPCell(
						new Paragraph(String.valueOf(String.valueOf(propiedad.getNumBanio())), tableBody));
				numBanioValue.setBorderColor(BaseColor.BLACK);
				numBanioValue.setPaddingLeft(10);
				numBanioValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				numBanioValue.setVerticalAlignment(Element.ALIGN_CENTER);
				numBanioValue.setBackgroundColor(BaseColor.WHITE);
				numBanioValue.setExtraParagraphSpace(5f);
				table.addCell(numBanioValue);
				
				PdfPCell numDormValue = new PdfPCell(
						new Paragraph(String.valueOf(String.valueOf(propiedad.getNumDormitorio())), tableBody));
				numDormValue.setBorderColor(BaseColor.BLACK);
				numDormValue.setPaddingLeft(10);
				numDormValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				numDormValue.setVerticalAlignment(Element.ALIGN_CENTER);
				numDormValue.setBackgroundColor(BaseColor.WHITE);
				numDormValue.setExtraParagraphSpace(5f);
				table.addCell(numDormValue);
				
				PdfPCell numEstacValue = new PdfPCell(
						new Paragraph(String.valueOf(String.valueOf(propiedad.getNumEstacionamiento())), tableBody));
				numEstacValue.setBorderColor(BaseColor.BLACK);
				numEstacValue.setPaddingLeft(10);
				numEstacValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				numEstacValue.setVerticalAlignment(Element.ALIGN_CENTER);
				numEstacValue.setBackgroundColor(BaseColor.WHITE);
				numEstacValue.setExtraParagraphSpace(5f);
				table.addCell(numEstacValue);
				
				PdfPCell dimTerrValue = new PdfPCell(
						new Paragraph(String.valueOf(String.valueOf(propiedad.getDimTerreno())), tableBody));
				dimTerrValue.setBorderColor(BaseColor.BLACK);
				dimTerrValue.setPaddingLeft(10);
				dimTerrValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				dimTerrValue.setVerticalAlignment(Element.ALIGN_CENTER);
				dimTerrValue.setBackgroundColor(BaseColor.WHITE);
				dimTerrValue.setExtraParagraphSpace(5f);
				table.addCell(dimTerrValue);
				
				PdfPCell dimConsValue = new PdfPCell(
						new Paragraph(String.valueOf(String.valueOf(propiedad.getDimConstruccion())), tableBody));
				dimConsValue.setBorderColor(BaseColor.BLACK);
				dimConsValue.setPaddingLeft(10);
				dimConsValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				dimConsValue.setVerticalAlignment(Element.ALIGN_CENTER);
				dimConsValue.setBackgroundColor(BaseColor.WHITE);
				dimConsValue.setExtraParagraphSpace(5f);
				table.addCell(dimConsValue);
				
				PdfPCell precioValue = new PdfPCell(
						new Paragraph(String.valueOf(String.valueOf(propiedad.getPrecio())), tableBody));
				precioValue.setBorderColor(BaseColor.BLACK);
				precioValue.setPaddingLeft(10);
				precioValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				precioValue.setVerticalAlignment(Element.ALIGN_CENTER);
				precioValue.setBackgroundColor(BaseColor.WHITE);
				precioValue.setExtraParagraphSpace(5f);
				table.addCell(precioValue);
			}

			document.add(table);
			document.close();
			writer.close();
			return true;

		} catch (Exception e) {
			return false;
		}
	}
	

	// Crear Excel para Propiedades
	@Override
	public boolean excelPropiedades(List<Propiedad> propiedades, ServletContext context, HttpServletRequest request,
			HttpServletResponse response) {

		String filePath = context.getRealPath("/resources/reports");
		File file = new File(filePath);
		boolean exists = new File(filePath).exists();
		if (!exists) {
			new File(filePath).mkdirs();
		}
		try {
			FileOutputStream outputStream = new FileOutputStream(file + "/" + "propiedades" + ".xls"); // nombre del
																											// archivo
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet workSheet = workbook.createSheet("Propiedades"); // creo el excel
			workSheet.setDefaultColumnWidth(30);

			HSSFCellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFillForegroundColor(HSSFColor.LIGHT_TURQUOISE.index);
			headerCellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

			HSSFRow headerRow = workSheet.createRow(0); //Crea fila y define la posicion

			HSSFCell idProp = headerRow.createCell(0); // Crea columna y define posicion de la celda
			idProp.setCellValue("ID");
			idProp.setCellStyle(headerCellStyle);

			HSSFCell tipo = headerRow.createCell(1);
			tipo.setCellValue("Tipo");
			tipo.setCellStyle(headerCellStyle);

			HSSFCell destinacion = headerRow.createCell(2);
			destinacion.setCellValue("Destinación");
			destinacion.setCellStyle(headerCellStyle);
			
			HSSFCell condicion = headerRow.createCell(3);
			condicion.setCellValue("Condición");
			condicion.setCellStyle(headerCellStyle);
			
			HSSFCell region = headerRow.createCell(4);
			region.setCellValue("Region");
			region.setCellStyle(headerCellStyle);
			
			HSSFCell comuna = headerRow.createCell(5);
			comuna.setCellValue("Comuna");
			comuna.setCellStyle(headerCellStyle);
			
			HSSFCell calle = headerRow.createCell(6);
			calle.setCellValue("Calle");
			calle.setCellStyle(headerCellStyle);
			
			HSSFCell numero = headerRow.createCell(7);
			numero.setCellValue("Número");
			numero.setCellStyle(headerCellStyle);
			
			HSSFCell numBanio = headerRow.createCell(8);
			numBanio.setCellValue("Baños");
			numBanio.setCellStyle(headerCellStyle);
			
			HSSFCell numDorm = headerRow.createCell(9);
			numDorm.setCellValue("Dormitorios");
			numDorm.setCellStyle(headerCellStyle);
			
			HSSFCell numEstac = headerRow.createCell(10);
			numEstac.setCellValue("Estacionamiento");
			numEstac.setCellStyle(headerCellStyle);
			
			HSSFCell dimTerr = headerRow.createCell(11);
			dimTerr.setCellValue("Área terreno(m²)");
			dimTerr.setCellStyle(headerCellStyle);
			
			HSSFCell dimConst = headerRow.createCell(12);
			dimConst.setCellValue("Área construida(m²)");
			dimConst.setCellStyle(headerCellStyle);
			
			HSSFCell precio = headerRow.createCell(13);
			precio.setCellValue("Precio");
			precio.setCellStyle(headerCellStyle);
			
			HSSFCell fechaPublic = headerRow.createCell(14);
			fechaPublic.setCellValue("Fecha publicación");
			fechaPublic.setCellStyle(headerCellStyle);
			
			HSSFCell descr = headerRow.createCell(15);
			descr.setCellValue("Descripción");
			descr.setCellStyle(headerCellStyle);
			
			int i = 1;
			for (Propiedad propiedad : propiedades) {
				HSSFRow bodyRow = workSheet.createRow(i); // define la linea

				HSSFCellStyle bodyCellStyle = workbook.createCellStyle();
				bodyCellStyle.setFillForegroundColor(HSSFColor.WHITE.index);

				HSSFCell idPropValue = bodyRow.createCell(0); // definir columna en createCell
				idPropValue.setCellValue(String.valueOf(propiedad.getIdPropiedad()));
				idPropValue.setCellStyle(bodyCellStyle);

				HSSFCell tipoValue = bodyRow.createCell(1);
				tipoValue.setCellValue(propiedad.getTipo().getNombreTipo()); // Modificar el get
				tipoValue.setCellStyle(bodyCellStyle);

				HSSFCell destinacionValue = bodyRow.createCell(2);
				destinacionValue.setCellValue(propiedad.getDestinacion().getNombreDestinacion()); // Modificar el get
				destinacionValue.setCellStyle(bodyCellStyle);
				
				HSSFCell condicionValue = bodyRow.createCell(3);
				condicionValue.setCellValue(propiedad.getCondicion().getNombreCondicion()); // Modificar el get
				condicionValue.setCellStyle(bodyCellStyle);
				
				HSSFCell regionValue = bodyRow.createCell(4);
				regionValue.setCellValue(propiedad.getRegion()); // Modificar el get
				regionValue.setCellStyle(bodyCellStyle);
				
				HSSFCell comunaValue = bodyRow.createCell(5);
				comunaValue.setCellValue(propiedad.getComuna()); // Modificar el get
				comunaValue.setCellStyle(bodyCellStyle);
				
				HSSFCell calleValue = bodyRow.createCell(6);
				calleValue.setCellValue(propiedad.getCalle()); 
				calleValue.setCellStyle(bodyCellStyle);
				
				HSSFCell numeroValue = bodyRow.createCell(7);
				numeroValue.setCellValue(propiedad.getNumero()); 
				numeroValue.setCellStyle(bodyCellStyle);
				
				HSSFCell numBanioValue = bodyRow.createCell(8);
				numBanioValue.setCellValue(propiedad.getNumBanio()); 
				numBanioValue.setCellStyle(bodyCellStyle);
				
				HSSFCell numDormValue = bodyRow.createCell(9);
				numDormValue.setCellValue(propiedad.getNumDormitorio()); 
				numDormValue.setCellStyle(bodyCellStyle);
				
				HSSFCell numEstacValue = bodyRow.createCell(10);
				numEstacValue.setCellValue(propiedad.getNumEstacionamiento()); 
				numEstacValue.setCellStyle(bodyCellStyle);
				
				HSSFCell dimTerrValue = bodyRow.createCell(11);
				dimTerrValue.setCellValue(propiedad.getDimTerreno()); 
				dimTerrValue.setCellStyle(bodyCellStyle);
				
				HSSFCell dimConstValue = bodyRow.createCell(12);
				dimConstValue.setCellValue(propiedad.getDimConstruccion()); 
				dimConstValue.setCellStyle(bodyCellStyle);
				
				HSSFCell precioValue = bodyRow.createCell(13);
				precioValue.setCellValue(propiedad.getPrecio()); 
				precioValue.setCellStyle(bodyCellStyle);
				
				HSSFCell fechaPubValue = bodyRow.createCell(14);
				fechaPubValue.setCellValue(String.valueOf(propiedad.getFechaPublicacion())); 
				fechaPubValue.setCellStyle(bodyCellStyle);
				
				HSSFCell descrValue = bodyRow.createCell(15);
				descrValue.setCellValue(propiedad.getDescripcion()); 
				descrValue.setCellStyle(bodyCellStyle);
				
				i++;
			}

			workbook.write(outputStream);
			outputStream.flush();
			outputStream.close();
			return true;

		} catch (Exception e) {
			return false;
		}
	}	

}
