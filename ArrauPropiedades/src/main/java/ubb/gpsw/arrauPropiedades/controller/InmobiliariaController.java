package ubb.gpsw.arrauPropiedades.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ubb.gpsw.arrauPropiedades.model.Inmobiliaria;
import ubb.gpsw.arrauPropiedades.service.InmobiliariaService;

@Controller
public class InmobiliariaController {

	@Autowired
	private InmobiliariaService inmoService;
	
	@RequestMapping("/inmobiliaria")
	public String index(Model model) {
		model.addAttribute("list",inmoService.getAll());
		return "indexInmo";
	}
	
	@GetMapping("/inmobiliaria/save/{id}")
	public String showSave(@PathVariable("id")int id, Model model) {
		if(id!=0) {
			model.addAttribute("Inmobiliaria",inmoService.get(id));
		} else {
			model.addAttribute("Inmobiliaria",new Inmobiliaria());
		}
		return "saveInmo";
	}
	
	
}
