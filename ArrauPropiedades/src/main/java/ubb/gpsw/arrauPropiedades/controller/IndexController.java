package ubb.gpsw.arrauPropiedades.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ubb.gpsw.arrauPropiedades.service.PropiedadService;
import ubb.gpsw.arrauPropiedades.model.Propiedad;

@Controller
public class IndexController {
	
	@Autowired
	private PropiedadService propService;
	
	@RequestMapping("/index")
	public String list(Model model) {
		model.addAttribute("list",propService.getAll());
		return "index";
	}
	
	@GetMapping("/propiedadDetalle/{id}")
	public String getPropiedadById(Model model, @PathVariable("id") Integer id) {
		if(id!=0) {
			model.addAttribute("listDetalle", propService.get(id));
		} else {
			System.out.println("error");
		}
		return "propiedadDetalleCliente";
	}
	
	@GetMapping("/indexAdmin")
	public String indexAdmin(Model model, HttpSession session){
		return "indexAdmin";
	}
	
	@GetMapping("/index")
	public String index(Model model, HttpSession session) {
		return "index";
	}
	

	
}
