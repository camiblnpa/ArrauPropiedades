package ubb.gpsw.arrauPropiedades.service;

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

import ubb.gpsw.arrauPropiedades.utilidades.RespuestaService;
import ubb.gpsw.arrauPropiedades.model.Inmobiliaria;
import ubb.gpsw.arrauPropiedades.repository.InmobiliariaRepository;

@Service
public class InmobiliariaServiceImpl extends RespuestaService<Inmobiliaria, Integer> implements InmobiliariaService {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private InmobiliariaRepository intPropRepo1;

	@Override
	public CrudRepository<Inmobiliaria, Integer> getDao() {
		return intPropRepo1;
	}

	// Crear PDF para inmobiliaria
	@Override
	public boolean pdfInmobiliaria(List<Inmobiliaria> inmobiliarias, ServletContext context, HttpServletRequest request,
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
					new FileOutputStream(file + "/" + "inmobiliarias" + ".pdf"));
			document.open();

			Font mainFont = FontFactory.getFont("Arial", 10, BaseColor.BLACK);

			Paragraph paragraph = new Paragraph("Todos las inmobiliarias", mainFont);
			paragraph.setAlignment(Element.ALIGN_CENTER);
			paragraph.setIndentationLeft(50);
			paragraph.setIndentationRight(50);
			paragraph.setSpacingAfter(10);
			document.add(paragraph);

			PdfPTable table = new PdfPTable(8); // Cuantas columnas tendrá la tabla
			table.setWidthPercentage(100);
			table.setSpacingBefore(10f);
			table.setSpacingAfter(10);

			Font tableHeader = FontFactory.getFont("Arial", 10, BaseColor.BLACK);
			Font tableBody = FontFactory.getFont("Arial", 9, BaseColor.BLACK);

			float[] columnWidths = { 2f, 2f, 2f, 2f, 2f, 2f, 2f, 2f }; // Definir la cantidad de veces que repite 2f de
																		// acuerdo a las columnas
			table.setWidths(columnWidths);

			PdfPCell idInmo = new PdfPCell(new Paragraph("ID", tableHeader));
			idInmo.setBorderColor(BaseColor.BLACK);
			idInmo.setPaddingLeft(10);
			idInmo.setHorizontalAlignment(Element.ALIGN_CENTER);
			idInmo.setVerticalAlignment(Element.ALIGN_CENTER);
			idInmo.setBackgroundColor(BaseColor.GRAY);
			idInmo.setExtraParagraphSpace(5f);
			table.addCell(idInmo);

			PdfPCell nombre = new PdfPCell(new Paragraph("Nombre", tableHeader));
			nombre.setBorderColor(BaseColor.BLACK);
			nombre.setPaddingLeft(10);
			nombre.setHorizontalAlignment(Element.ALIGN_CENTER);
			nombre.setVerticalAlignment(Element.ALIGN_CENTER);
			nombre.setBackgroundColor(BaseColor.GRAY);
			nombre.setExtraParagraphSpace(5f);
			table.addCell(nombre);

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

			PdfPCell numero = new PdfPCell(new Paragraph("Número", tableHeader));
			numero.setBorderColor(BaseColor.BLACK);
			numero.setPaddingLeft(1);
			numero.setHorizontalAlignment(Element.ALIGN_CENTER);
			numero.setVerticalAlignment(Element.ALIGN_CENTER);
			numero.setBackgroundColor(BaseColor.GRAY);
			numero.setExtraParagraphSpace(5f);
			table.addCell(numero);

			PdfPCell numeroDep = new PdfPCell(new Paragraph("Número Oficina", tableHeader));
			numeroDep.setBorderColor(BaseColor.BLACK);
			numeroDep.setPaddingLeft(1);
			numeroDep.setHorizontalAlignment(Element.ALIGN_CENTER);
			numeroDep.setVerticalAlignment(Element.ALIGN_CENTER);
			numeroDep.setBackgroundColor(BaseColor.GRAY);
			numeroDep.setExtraParagraphSpace(5f);
			table.addCell(numeroDep);

			PdfPCell correo = new PdfPCell(new Paragraph("E-mail", tableHeader));
			correo.setBorderColor(BaseColor.BLACK);
			correo.setPaddingLeft(10);
			correo.setHorizontalAlignment(Element.ALIGN_CENTER);
			correo.setVerticalAlignment(Element.ALIGN_CENTER);
			correo.setBackgroundColor(BaseColor.GRAY);
			correo.setExtraParagraphSpace(5f);
			table.addCell(correo);

			PdfPCell telefono = new PdfPCell(new Paragraph("Teléfono", tableHeader));
			telefono.setBorderColor(BaseColor.BLACK);
			telefono.setPaddingLeft(10);
			telefono.setHorizontalAlignment(Element.ALIGN_CENTER);
			telefono.setVerticalAlignment(Element.ALIGN_CENTER);
			telefono.setBackgroundColor(BaseColor.GRAY);
			telefono.setExtraParagraphSpace(5f);
			table.addCell(telefono);

			for (Inmobiliaria inmobiliaria : inmobiliarias) {
				PdfPCell idInmoValue = new PdfPCell(
						new Paragraph(String.valueOf(inmobiliaria.getIdInmobiliaria()), tableBody));
				idInmoValue.setBorderColor(BaseColor.BLACK);
				idInmoValue.setPaddingLeft(10);
				idInmoValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				idInmoValue.setVerticalAlignment(Element.ALIGN_CENTER);
				idInmoValue.setBackgroundColor(BaseColor.WHITE);
				idInmoValue.setExtraParagraphSpace(5f);
				table.addCell(idInmoValue);

				PdfPCell nombreValue = new PdfPCell(new Paragraph(inmobiliaria.getNombre(), tableBody));
				nombreValue.setBorderColor(BaseColor.BLACK);
				nombreValue.setPaddingLeft(10);
				nombreValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				nombreValue.setVerticalAlignment(Element.ALIGN_CENTER);
				nombreValue.setBackgroundColor(BaseColor.WHITE);
				nombreValue.setExtraParagraphSpace(5f);
				table.addCell(nombreValue);

				PdfPCell regionValue = new PdfPCell(new Paragraph(String.valueOf(inmobiliaria.getRegion()), tableBody));
				regionValue.setBorderColor(BaseColor.BLACK);
				regionValue.setPaddingLeft(10);
				regionValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				regionValue.setVerticalAlignment(Element.ALIGN_CENTER);
				regionValue.setBackgroundColor(BaseColor.WHITE);
				regionValue.setExtraParagraphSpace(5f);
				table.addCell(regionValue);

				PdfPCell comunaValue = new PdfPCell(new Paragraph(String.valueOf(inmobiliaria.getComuna()), tableBody));
				comunaValue.setBorderColor(BaseColor.BLACK);
				comunaValue.setPaddingLeft(10);
				comunaValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				comunaValue.setVerticalAlignment(Element.ALIGN_CENTER);
				comunaValue.setBackgroundColor(BaseColor.WHITE);
				comunaValue.setExtraParagraphSpace(5f);
				table.addCell(comunaValue);

				PdfPCell numeroValue = new PdfPCell(new Paragraph(String.valueOf(inmobiliaria.getNumero()), tableBody));
				numeroValue.setBorderColor(BaseColor.BLACK);
				numeroValue.setPaddingLeft(10);
				numeroValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				numeroValue.setVerticalAlignment(Element.ALIGN_CENTER);
				numeroValue.setBackgroundColor(BaseColor.WHITE);
				numeroValue.setExtraParagraphSpace(5f);
				table.addCell(numeroValue);

				PdfPCell numeroDepValue = new PdfPCell(
						new Paragraph(String.valueOf(String.valueOf(inmobiliaria.getNumDepartamento())), tableBody));
				numeroDepValue.setBorderColor(BaseColor.BLACK);
				numeroDepValue.setPaddingLeft(10);
				numeroDepValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				numeroDepValue.setVerticalAlignment(Element.ALIGN_CENTER);
				numeroDepValue.setBackgroundColor(BaseColor.WHITE);
				numeroDepValue.setExtraParagraphSpace(5f);
				table.addCell(numeroDepValue);

				PdfPCell telefonoValue = new PdfPCell(
						new Paragraph(String.valueOf(String.valueOf(inmobiliaria.getTelefono())), tableBody));
				telefonoValue.setBorderColor(BaseColor.BLACK);
				telefonoValue.setPaddingLeft(10);
				telefonoValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				telefonoValue.setVerticalAlignment(Element.ALIGN_CENTER);
				telefonoValue.setBackgroundColor(BaseColor.WHITE);
				telefonoValue.setExtraParagraphSpace(5f);
				table.addCell(telefonoValue);

			}

			document.add(table);
			document.close();
			writer.close();
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	// Crear Excel para inmobiliaria
	@Override
	public boolean excelInmobiliaria(List<Inmobiliaria> inmobiliarias, ServletContext context, HttpServletRequest request,
			HttpServletResponse response) {

		String filePath = context.getRealPath("/resources/reports");
		File file = new File(filePath);
		boolean exists = new File(filePath).exists();
		if (!exists) {
			new File(filePath).mkdirs();
		}
		try {
			FileOutputStream outputStream = new FileOutputStream(file + "/" + "inmobiliarias" + ".xls"); // nombre del
																											// archivo
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet workSheet = workbook.createSheet("Inmobiliarias"); // creo el excel
			workSheet.setDefaultColumnWidth(30);

			HSSFCellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFillForegroundColor(HSSFColor.LIGHT_TURQUOISE.index);
			headerCellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

			HSSFRow headerRow = workSheet.createRow(0); // Crea fila y define la posicion

			HSSFCell idInmo = headerRow.createCell(0); // Crea columna y define posicion de la celda
			idInmo.setCellValue("ID");
			idInmo.setCellStyle(headerCellStyle);

			HSSFCell nombre = headerRow.createCell(1);
			nombre.setCellValue("Nombre");
			nombre.setCellStyle(headerCellStyle);
			
			HSSFCell region = headerRow.createCell(2);
			region.setCellValue("Region");
			region.setCellStyle(headerCellStyle);
			
			HSSFCell comuna = headerRow.createCell(3);
			comuna.setCellValue("Comuna");
			comuna.setCellStyle(headerCellStyle);
			
			HSSFCell numero = headerRow.createCell(4);
			numero.setCellValue("Número");
			numero.setCellStyle(headerCellStyle);
			
			HSSFCell numeroDep = headerRow.createCell(5);
			numeroDep.setCellValue("Número oficina");
			numeroDep.setCellStyle(headerCellStyle);

			HSSFCell correo = headerRow.createCell(6);
			correo.setCellValue("E-mail");
			correo.setCellStyle(headerCellStyle);
			
			HSSFCell telefono = headerRow.createCell(7);
			telefono.setCellValue("Teléfono");
			telefono.setCellStyle(headerCellStyle);
			
			int i = 1;
			for (Inmobiliaria inmobiliaria : inmobiliarias) {
				HSSFRow bodyRow = workSheet.createRow(i); // define la linea

				HSSFCellStyle bodyCellStyle = workbook.createCellStyle();
				bodyCellStyle.setFillForegroundColor(HSSFColor.WHITE.index);

				HSSFCell idInmoValeu = bodyRow.createCell(0); // definir columna en createCell
				idInmoValeu.setCellValue(String.valueOf(inmobiliaria.getIdInmobiliaria()));
				idInmoValeu.setCellStyle(bodyCellStyle);

				HSSFCell nombreValue = bodyRow.createCell(1);
				nombreValue.setCellValue(inmobiliaria.getNombre()); // Modificar el get
				nombreValue.setCellStyle(bodyCellStyle);
				
				HSSFCell regionValue = bodyRow.createCell(2);
				regionValue.setCellValue(inmobiliaria.getRegion()); // Modificar el get
				regionValue.setCellStyle(bodyCellStyle);
				
				HSSFCell comunaValue = bodyRow.createCell(3);
				comunaValue.setCellValue(inmobiliaria.getComuna()); // Modificar el get
				comunaValue.setCellStyle(bodyCellStyle);
				
				HSSFCell numeroValue = bodyRow.createCell(4);
				numeroValue.setCellValue(inmobiliaria.getNumero()); 
				numeroValue.setCellStyle(bodyCellStyle);
				
				HSSFCell numeroDepValue = bodyRow.createCell(5);
				numeroDepValue.setCellValue(inmobiliaria.getNumDepartamento()); 
				numeroDepValue.setCellStyle(bodyCellStyle);
				
				HSSFCell correoValue = bodyRow.createCell(6);
				correoValue.setCellValue(inmobiliaria.getCorreo()); 
				correoValue.setCellStyle(bodyCellStyle);
				
				HSSFCell telefonoValue = bodyRow.createCell(7);
				telefonoValue.setCellValue(inmobiliaria.getTelefono()); 
				telefonoValue.setCellStyle(bodyCellStyle);
				
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
