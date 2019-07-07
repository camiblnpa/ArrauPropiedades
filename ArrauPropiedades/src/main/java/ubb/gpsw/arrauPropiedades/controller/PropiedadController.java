package ubb.gpsw.arrauPropiedades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ubb.gpsw.arrauPropiedades.service.PropiedadService;
import ubb.gpsw.arrauPropiedades.service.TipoService;
import ubb.gpsw.arrauPropiedades.service.InmobiliariaService;
import ubb.gpsw.arrauPropiedades.service.DestinacionService;
import ubb.gpsw.arrauPropiedades.service.CondicionService;

import ubb.gpsw.arrauPropiedades.model.Propiedad;

@Controller
public class PropiedadController {

	@Autowired
	private PropiedadService propService;
	
	@Autowired
	private TipoService tipoService;
	
	@Autowired
	private InmobiliariaService inmService;
	
	@Autowired
	private DestinacionService destService;
	
	@Autowired
	private CondicionService condService;
	
	//Listar todas las propiedades 
	@RequestMapping("/propiedades")
	public String listPropiedades(Model model) {
		model.addAttribute("list",propService.getAll());
		return "propiedad";
	}
	
	
	
//	@GetMapping("/propiedadDetalle/{id}")
//	public String getPropiedadById(Model model, @PathVariable("id") Integer id) {
//		if(id!=0) {
//			model.addAttribute("listDetalle", propService.findById(id));
//		} else {
//			System.out.println("error");
//		}
//		return "propiedadDetalle";
//	}
//	
//	@GetMapping("/propiedadPojo/save/{id}")
//	public String showSave(@PathVariable("id")int id, Model model) {
//		if(id!=0) {
//			model.addAttribute("propiedad",propService.findById(id));
//		} else {
//			model.addAttribute("propiedad",new PropiedadPojo());
//		}
//		return "savePropiedad";
//	}
//	
//	@PostMapping("/propiedadPojo/save")
//	public String save(PropiedadPojo propiedad, Model model) {
//		propService.save(propiedad);
//		return "redirect:/propiedadPojo";
//	}
	
}
