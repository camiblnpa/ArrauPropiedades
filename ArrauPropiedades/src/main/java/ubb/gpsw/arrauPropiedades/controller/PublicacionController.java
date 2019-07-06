package ubb.gpsw.arrauPropiedades.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ubb.gpsw.arrauPropiedades.model.Destinacion;
import ubb.gpsw.arrauPropiedades.model.Publicacion;
import ubb.gpsw.arrauPropiedades.service.PublicacionService;

@Controller
public class PublicacionController {

	@Autowired
	private PublicacionService publiService;
	
	@RequestMapping("/publicacion")
	public String indexPublicacion(Model model) {
		model.addAttribute("list",publiService.getAll());
		return "indexPublicacion";
	}
	
	@GetMapping("/publicacion/save/{id}")
	public String showSave(@PathVariable("id")int id, Model model) {
		if(id!=0) {
			model.addAttribute("publicacion",publiService.get(id));
		} else {
			model.addAttribute("publicacion",new Publicacion());
		}
		return "savePublicacion";
	}
	
	@PostMapping("/publicacion/save")
	public String save(Publicacion publicacion, Model model) {
		publiService.save(publicacion);
		return "redirect:/publicacion";
	}
	
		
	@GetMapping("/publicacion/delete/{id}")
	public String delete(@PathVariable Integer id, Model model) {
		try {
		publiService.delete(id);
		return "redirect:/publicacion";
		}
		catch(Exception ExceptionMapperStandardImpl) {
			return "mensajeError";
		}	
	}	
	
}
