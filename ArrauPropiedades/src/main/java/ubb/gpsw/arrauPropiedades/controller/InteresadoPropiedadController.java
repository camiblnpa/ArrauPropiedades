package ubb.gpsw.arrauPropiedades.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ubb.gpsw.arrauPropiedades.model.InteresadoPropiedad;
import ubb.gpsw.arrauPropiedades.service.InteresadoPropiedadService;

@Controller
public class InteresadoPropiedadController {
	
	@Autowired
	private InteresadoPropiedadService intPropService;
	
	@RequestMapping("/indexIP")
	public String index(Model model) {
		model.addAttribute("list",intPropService.getAll());
		return "indexIP";
	}
	
	@GetMapping("/saveIP/{id}")
	public String showSave(@PathVariable("id") int id, Model model) {
		if(id!=0) {
			model.addAttribute("interesadoPropiedad",intPropService.get(id));
		} else {
			model.addAttribute("interesadoPropiedad", new InteresadoPropiedad());
		}
		return "saveIP";
	}
	
	@PostMapping("/saveIP")
	public String save(InteresadoPropiedad interesadoPropiedad, Model model) {
		intPropService.save(interesadoPropiedad);
		return "redirect:/indexIP";
	}
	
	@GetMapping("/deleteIP/{id}")
	public String delete(@PathVariable Integer id, Model model) {
		intPropService.delete(id);
		return "redirect:/indexIP";
	}

}
