package ubb.gpsw.arrauPropiedades.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

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

import ubb.gpsw.arrauPropiedades.model.Destinacion;
import ubb.gpsw.arrauPropiedades.repository.DestinacionRepository;
import ubb.gpsw.arrauPropiedades.utilidades.RespuestaService;

@Service
public class DestinacionServiceImpl extends RespuestaService<Destinacion, Integer> implements DestinacionService {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private DestinacionRepository destRepo;

	@Override
	public CrudRepository<Destinacion, Integer> getDao() {
		return destRepo;
	}

	// Crear PDF para Destinacion
	@Override
	public boolean pdfDestinacion(List<Destinacion> destinaciones, ServletContext context, HttpServletRequest request,
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
					new FileOutputStream(file + "/" + "destinaciones" + ".pdf"));
			document.open();

			Font mainFont = FontFactory.getFont("Arial", 10, BaseColor.BLACK);

			Paragraph paragraph = new Paragraph("Todos las destinaciones", mainFont);
			paragraph.setAlignment(Element.ALIGN_CENTER);
			paragraph.setIndentationLeft(50);
			paragraph.setIndentationRight(50);
			paragraph.setSpacingAfter(10);
			document.add(paragraph);

			PdfPTable table = new PdfPTable(2); // Cuantas columnas tendrá la tabla
			table.setWidthPercentage(100);
			table.setSpacingBefore(10f);
			table.setSpacingAfter(10);

			Font tableHeader = FontFactory.getFont("Arial", 10, BaseColor.BLACK);
			Font tableBody = FontFactory.getFont("Arial", 9, BaseColor.BLACK);

			float[] columnWidths = { 2f, 2f }; // Definir la cantidad de veces que repite 2f de acuerdo a las columnas
			table.setWidths(columnWidths);

			PdfPCell idDestinacion = new PdfPCell(new Paragraph("ID", tableHeader));
			idDestinacion.setBorderColor(BaseColor.BLACK);
			idDestinacion.setPaddingLeft(10);
			idDestinacion.setHorizontalAlignment(Element.ALIGN_CENTER);
			idDestinacion.setVerticalAlignment(Element.ALIGN_CENTER);
			idDestinacion.setBackgroundColor(BaseColor.GRAY);
			idDestinacion.setExtraParagraphSpace(5f);
			table.addCell(idDestinacion);

			PdfPCell nombreDestinacion = new PdfPCell(new Paragraph("Nombre", tableHeader));
			nombreDestinacion.setBorderColor(BaseColor.BLACK);
			nombreDestinacion.setPaddingLeft(10);
			nombreDestinacion.setHorizontalAlignment(Element.ALIGN_CENTER);
			nombreDestinacion.setVerticalAlignment(Element.ALIGN_CENTER);
			nombreDestinacion.setBackgroundColor(BaseColor.GRAY);
			nombreDestinacion.setExtraParagraphSpace(5f);
			table.addCell(nombreDestinacion);

			for (Destinacion destinacion : destinaciones) {
				PdfPCell idDestinacionValue = new PdfPCell(
						new Paragraph(String.valueOf(destinacion.getIdDestinacion()), tableBody));
				idDestinacionValue.setBorderColor(BaseColor.BLACK);
				idDestinacionValue.setPaddingLeft(10);
				idDestinacionValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				idDestinacionValue.setVerticalAlignment(Element.ALIGN_CENTER);
				idDestinacionValue.setBackgroundColor(BaseColor.WHITE);
				idDestinacionValue.setExtraParagraphSpace(5f);
				table.addCell(idDestinacionValue);

				PdfPCell nombreDestinacionValue = new PdfPCell(
						new Paragraph(destinacion.getNombreDestinacion(), tableBody));
				nombreDestinacionValue.setBorderColor(BaseColor.BLACK);
				nombreDestinacionValue.setPaddingLeft(10);
				nombreDestinacionValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				nombreDestinacionValue.setVerticalAlignment(Element.ALIGN_CENTER);
				nombreDestinacionValue.setBackgroundColor(BaseColor.WHITE);
				nombreDestinacionValue.setExtraParagraphSpace(5f);
				table.addCell(nombreDestinacionValue);
			}

			document.add(table);
			document.close();
			writer.close();
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	// Crear Excel para Destinacion
	@Override
	public boolean createExcel(List<Destinacion> destinaciones, ServletContext context, HttpServletRequest request,
			HttpServletResponse response) {

		String filePath = context.getRealPath("/resources/reports");
		File file = new File(filePath);
		boolean exists = new File(filePath).exists();
		if (!exists) {
			new File(filePath).mkdirs();
		}
		try {
			FileOutputStream outputStream = new FileOutputStream(file + "/" + "destinaciones" + ".xls"); // nombre del
																											// archivo
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet workSheet = workbook.createSheet("Destinaciones"); // creo el excel
			workSheet.setDefaultColumnWidth(30);

			HSSFCellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFillForegroundColor(HSSFColor.LIGHT_TURQUOISE.index);
			headerCellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

			HSSFRow headerRow = workSheet.createRow(0); //Crea fila y define la posicion

			HSSFCell idDestinacion = headerRow.createCell(0); // Crea columna y define posicion de la celda
			idDestinacion.setCellValue("ID");
			idDestinacion.setCellStyle(headerCellStyle);

			HSSFCell nombreDestinacion = headerRow.createCell(1);
			nombreDestinacion.setCellValue("Nombre");
			nombreDestinacion.setCellStyle(headerCellStyle);

			int i = 1;
			for (Destinacion destinacion : destinaciones) {
				HSSFRow bodyRow = workSheet.createRow(i); // define la linea

				HSSFCellStyle bodyCellStyle = workbook.createCellStyle();
				bodyCellStyle.setFillForegroundColor(HSSFColor.WHITE.index);

				HSSFCell idDestinacionValue = bodyRow.createCell(0); // definir columna en createCell
				idDestinacionValue.setCellValue(String.valueOf(destinacion.getIdDestinacion()));
				idDestinacionValue.setCellStyle(bodyCellStyle);

				HSSFCell nombreDestinacionValue = bodyRow.createCell(1);
				nombreDestinacionValue.setCellValue(destinacion.getNombreDestinacion()); // Modificar el get
				nombreDestinacionValue.setCellStyle(bodyCellStyle);

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
