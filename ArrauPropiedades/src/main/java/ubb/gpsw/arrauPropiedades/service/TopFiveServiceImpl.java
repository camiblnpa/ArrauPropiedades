package ubb.gpsw.arrauPropiedades.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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


import ubb.gpsw.arrauPropiedades.model.TopFive;
import ubb.gpsw.arrauPropiedades.repository.TopFiveRepository;
import ubb.gpsw.arrauPropiedades.utilidades.RespuestaService;

@Service
public class TopFiveServiceImpl extends RespuestaService<TopFive, String> implements TopFiveService{
	
	@PersistenceContext
	private EntityManager em;

	@Autowired
	private TopFiveRepository topRepo;

	@Override
	public CrudRepository<TopFive, String> getDao() {
		return topRepo;
	}
	

	// Crear PDF para Destinacion
	@Override
	public boolean pdfTopFive(List<TopFive> topFive, ServletContext context, HttpServletRequest request,
			HttpServletResponse response) {
		Document document = new Document(PageSize.A4, 15, 15, 45, 30);
		try {
			String filePath = context.getRealPath("/resources/reports");
			File file = new File(filePath);
			boolean exists = new File(filePath).exists();
			if (!exists) {
				new File(filePath).mkdirs();
			}

			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream(file + "/" + "topFive" + ".pdf"));
			document.open();

			Font mainFont = FontFactory.getFont("Arial", 10, BaseColor.BLACK);

			Paragraph paragraph = new Paragraph("Propiedades con más interesados - Top Five", mainFont);
			paragraph.setAlignment(Element.ALIGN_CENTER);
			paragraph.setIndentationLeft(50);
			paragraph.setIndentationRight(50);
			paragraph.setSpacingAfter(10);
			document.add(paragraph);

			PdfPTable table = new PdfPTable(5); // Cuantas columnas tendrá la tabla
			table.setWidthPercentage(100);
			table.setSpacingBefore(10f);
			table.setSpacingAfter(10);

			Font tableHeader = FontFactory.getFont("Arial", 10, BaseColor.BLACK);
			Font tableBody = FontFactory.getFont("Arial", 9, BaseColor.BLACK);

			float[] columnWidths = { 2f, 2f, 2f, 2f, 2f }; // Definir la cantidad de veces que repite 2f de acuerdo a las columnas
			table.setWidths(columnWidths);

			PdfPCell idDestinacion = new PdfPCell(new Paragraph("Interesados", tableHeader));
			idDestinacion.setBorderColor(BaseColor.BLACK);
			idDestinacion.setPaddingLeft(10);
			idDestinacion.setHorizontalAlignment(Element.ALIGN_CENTER);
			idDestinacion.setVerticalAlignment(Element.ALIGN_CENTER);
			idDestinacion.setBackgroundColor(BaseColor.GRAY);
			idDestinacion.setExtraParagraphSpace(5f);
			table.addCell(idDestinacion);

			PdfPCell nombreDestinacion = new PdfPCell(new Paragraph("Nombre Propiedad", tableHeader));
			nombreDestinacion.setBorderColor(BaseColor.BLACK);
			nombreDestinacion.setPaddingLeft(10);
			nombreDestinacion.setHorizontalAlignment(Element.ALIGN_CENTER);
			nombreDestinacion.setVerticalAlignment(Element.ALIGN_CENTER);
			nombreDestinacion.setBackgroundColor(BaseColor.GRAY);
			nombreDestinacion.setExtraParagraphSpace(5f);
			table.addCell(nombreDestinacion);

			PdfPCell region = new PdfPCell(new Paragraph("Región Propiedad", tableHeader));
			region.setBorderColor(BaseColor.BLACK);
			region.setPaddingLeft(10);
			region.setHorizontalAlignment(Element.ALIGN_CENTER);
			region.setVerticalAlignment(Element.ALIGN_CENTER);
			region.setBackgroundColor(BaseColor.GRAY);
			region.setExtraParagraphSpace(5f);
			table.addCell(region);
			
			PdfPCell comuna = new PdfPCell(new Paragraph("Comuna Propiedad", tableHeader));
			comuna.setBorderColor(BaseColor.BLACK);
			comuna.setPaddingLeft(10);
			comuna.setHorizontalAlignment(Element.ALIGN_CENTER);
			comuna.setVerticalAlignment(Element.ALIGN_CENTER);
			comuna.setBackgroundColor(BaseColor.GRAY);
			comuna.setExtraParagraphSpace(5f);
			table.addCell(comuna);
			
			PdfPCell precio = new PdfPCell(new Paragraph("Precio Propiedad", tableHeader));
			precio.setBorderColor(BaseColor.BLACK);
			precio.setPaddingLeft(10);
			precio.setHorizontalAlignment(Element.ALIGN_CENTER);
			precio.setVerticalAlignment(Element.ALIGN_CENTER);
			precio.setBackgroundColor(BaseColor.GRAY);
			precio.setExtraParagraphSpace(5f);
			table.addCell(precio);
			
			

			for (TopFive topfive : topFive) {
				PdfPCell idDestinacionValue = new PdfPCell(
						new Paragraph(String.valueOf(String.valueOf(topfive.getInteresados())), tableBody));
				idDestinacionValue.setBorderColor(BaseColor.BLACK);
				idDestinacionValue.setPaddingLeft(10);
				idDestinacionValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				idDestinacionValue.setVerticalAlignment(Element.ALIGN_CENTER);
				idDestinacionValue.setBackgroundColor(BaseColor.WHITE);
				idDestinacionValue.setExtraParagraphSpace(5f);
				table.addCell(idDestinacionValue);

				PdfPCell nombreDestinacionValue = new PdfPCell(
						new Paragraph(topfive.getNombrePropiedad(), tableBody));
				nombreDestinacionValue.setBorderColor(BaseColor.BLACK);
				nombreDestinacionValue.setPaddingLeft(10);
				nombreDestinacionValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				nombreDestinacionValue.setVerticalAlignment(Element.ALIGN_CENTER);
				nombreDestinacionValue.setBackgroundColor(BaseColor.WHITE);
				nombreDestinacionValue.setExtraParagraphSpace(5f);
				table.addCell(nombreDestinacionValue);
				
				PdfPCell regionValue = new PdfPCell(
						new Paragraph(topfive.getRegion(), tableBody));
				regionValue.setBorderColor(BaseColor.BLACK);
				regionValue.setPaddingLeft(10);
				regionValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				regionValue.setVerticalAlignment(Element.ALIGN_CENTER);
				regionValue.setBackgroundColor(BaseColor.WHITE);
				regionValue.setExtraParagraphSpace(5f);
				table.addCell(regionValue);
				
				PdfPCell comunaValue = new PdfPCell(
						new Paragraph(topfive.getComuna(), tableBody));
				comunaValue.setBorderColor(BaseColor.BLACK);
				comunaValue.setPaddingLeft(10);
				comunaValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				comunaValue.setVerticalAlignment(Element.ALIGN_CENTER);
				comunaValue.setBackgroundColor(BaseColor.WHITE);
				comunaValue.setExtraParagraphSpace(5f);
				table.addCell(comunaValue);
				
				PdfPCell precioValue = new PdfPCell(
						new Paragraph(String.valueOf(topfive.getPrecio()), tableBody));
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

	// Crear Excel para TopFive
	@Override
	public boolean excelTopFive(List<TopFive> topFive, ServletContext context, HttpServletRequest request,
			HttpServletResponse response) {

		String filePath = context.getRealPath("/resources/reports");
		File file = new File(filePath);
		boolean exists = new File(filePath).exists();
		if (!exists) {
			new File(filePath).mkdirs();
		}
		try {
			FileOutputStream outputStream = new FileOutputStream(file + "/" + "topFive" + ".xls"); // nombre del
																											// archivo
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet workSheet = workbook.createSheet("TopFive"); // creo el excel
			workSheet.setDefaultColumnWidth(30);

			HSSFCellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFillForegroundColor(HSSFColor.LIGHT_TURQUOISE.index);
			headerCellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

			HSSFRow headerRow = workSheet.createRow(0); //Crea fila y define la posicion

			HSSFCell interesados = headerRow.createCell(0); // Crea columna y define posicion de la celda
			interesados.setCellValue("Interersados");
			interesados.setCellStyle(headerCellStyle);

			HSSFCell nombreDestinacion = headerRow.createCell(1);
			nombreDestinacion.setCellValue("Nombre Propiedad");
			nombreDestinacion.setCellStyle(headerCellStyle);

			HSSFCell region = headerRow.createCell(2);
			region.setCellValue("Region Propiedad");
			region.setCellStyle(headerCellStyle);
			
			HSSFCell comuna = headerRow.createCell(3);
			comuna.setCellValue("Comuna Propiedad");
			comuna.setCellStyle(headerCellStyle);
			
			HSSFCell precio = headerRow.createCell(4);
			precio.setCellValue("Precio Propiedad");
			precio.setCellStyle(headerCellStyle);
			int i = 1;
			for (TopFive topfive : topFive) {
				HSSFRow bodyRow = workSheet.createRow(i); // define la linea

				HSSFCellStyle bodyCellStyle = workbook.createCellStyle();
				bodyCellStyle.setFillForegroundColor(HSSFColor.WHITE.index);

				HSSFCell interesadosValue = bodyRow.createCell(0); // definir columna en createCell
				interesadosValue.setCellValue(String.valueOf(topfive.getInteresados()));
				interesadosValue.setCellStyle(bodyCellStyle);

				HSSFCell nombreDestinacionValue = bodyRow.createCell(1);
				nombreDestinacionValue.setCellValue(topfive.getNombrePropiedad()); // Modificar el get
				nombreDestinacionValue.setCellStyle(bodyCellStyle);

				HSSFCell regionValue = bodyRow.createCell(2);
				regionValue.setCellValue(topfive.getRegion()); // Modificar el get
				regionValue.setCellStyle(bodyCellStyle);

				HSSFCell comunaValue = bodyRow.createCell(3);
				comunaValue.setCellValue(topfive.getComuna()); // Modificar el get
				comunaValue.setCellStyle(bodyCellStyle);

				HSSFCell precioValue = bodyRow.createCell(4);
				precioValue.setCellValue(topfive.getPrecio()); // Modificar el get
				precioValue.setCellStyle(bodyCellStyle);

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
