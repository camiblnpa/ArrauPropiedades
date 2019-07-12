package ubb.gpsw.arrauPropiedades.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ubb.gpsw.arrauPropiedades.model.Propiedad;
import ubb.gpsw.arrauPropiedades.service.PropiedadService;

@Controller
public class IndexController {
	
	@Autowired
	private PropiedadService propService;

	@GetMapping("/indexAdmin")
	public String indexAdmin(Model model, HttpSession session){
		return "indexAdmin";
	}
		
	@RequestMapping("/index")
	public String listar(Model model) {
		model.addAttribute("listIndex", propService.getAll());
		return "index";
	}
	
	//Detalles propiedad
	@GetMapping("/propiedadDetalle/{id}")
	public String getPropiedadById(Model model, @PathVariable("id") Integer id) {
		if(id!=0) {
			model.addAttribute("listIndex", propService.get(id));
		} else {
			System.out.println("error");
		}
		return "verDetallesCatalogo";
	}
	


}
