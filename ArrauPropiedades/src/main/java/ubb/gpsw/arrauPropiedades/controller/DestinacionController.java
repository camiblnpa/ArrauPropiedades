package ubb.gpsw.arrauPropiedades.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ubb.gpsw.arrauPropiedades.model.Destinacion;
import ubb.gpsw.arrauPropiedades.service.DestinacionService;

@Controller
public class DestinacionController {
	
	@Autowired
	private DestinacionService destService;
	
	@RequestMapping("/destinacion")
	public String indexDestinacion(Model model) {
		model.addAttribute("list",destService.getAll());
		return "indexDestinacion";
	}
	
	@GetMapping("/destinacion/save/{id}")
	public String showSave(@PathVariable("id")int id, Model model) {
		if(id!=0) {
			model.addAttribute("destinacion",destService.get(id));
		} else {
			model.addAttribute("destinacion",new Destinacion());
		}
		return "saveDestinacion";
	}
	
	@PostMapping("/destinacion/save")
	public String save(Destinacion destinacion, Model model) {
		destService.save(destinacion);
		return "redirect:/destinacion";
	}
	
		
	@GetMapping("/destinacion/delete/{id}")
	public String delete(@PathVariable Integer id, Model model) {
		try {
		destService.delete(id);
		return "redirect:/destinacion";
		}
		catch(Exception ExceptionMapperStandardImpl) {
			return "mensajeError";
		}	
	}
}
