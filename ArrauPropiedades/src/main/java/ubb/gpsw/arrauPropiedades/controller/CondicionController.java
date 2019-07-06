package ubb.gpsw.arrauPropiedades.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ubb.gpsw.arrauPropiedades.model.Condicion;
import ubb.gpsw.arrauPropiedades.service.CondicionService;

@Controller
public class CondicionController {

	@Autowired
	private CondicionService condService;
	
	
	@RequestMapping("/condicion")
	public String indexCondicion(Model model) {
		model.addAttribute("list",condService.getAll());
		return "indexCondicion";
	}
	
	@GetMapping("/condicion/save/{id}")
	public String showSave(@PathVariable("id")int id, Model model) {
		if(id!=0) {
			model.addAttribute("condicion",condService.get(id));
		} else {
			model.addAttribute("condicion",new Condicion());
		}
		return "saveCondicion";
	}
	
	@PostMapping("/condicion/save")
	public String save(Condicion condicion, Model model) {
		condService.save(condicion);
		return "redirect:/condicion";
	}
	
		
	@GetMapping("/condicion/delete/{id}")
	public String delete(@PathVariable Integer id, Model model) {
		try {
		condService.delete(id);
		return "redirect:/condicion";
		}
		catch(Exception ExceptionMapperStandardImpl) {
			return "mensajeError";
		}	
	}	
}
