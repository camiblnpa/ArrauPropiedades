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
			model.addAttribute("inmobiliaria",inmoService.get(id));
		} else {
			model.addAttribute("inmobiliaria",new Inmobiliaria());
		}
		return "saveInmo";
	}
	
	@PostMapping("/inmobiliaria/save")
	public String save(Inmobiliaria inmobiliaria, Model model) {
		inmoService.save(inmobiliaria);
		return "redirect:/inmobiliaria";
	}

	@GetMapping("/inmobiliaria/delete/{id}")
	public String delete(@PathVariable Integer id, Model model) {
		inmoService.delete(id);
		return"redirect:/inmobiliaria";
	}
	
	
}
