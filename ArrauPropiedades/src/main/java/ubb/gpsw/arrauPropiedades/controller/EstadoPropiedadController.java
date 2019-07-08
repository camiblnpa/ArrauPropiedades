package ubb.gpsw.arrauPropiedades.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ubb.gpsw.arrauPropiedades.model.EstadoPropiedad;
import ubb.gpsw.arrauPropiedades.service.EstadoPropiedadService;


@Controller
public class EstadoPropiedadController {

	@Autowired
	private EstadoPropiedadService estadoService;
	
	@RequestMapping("/estadoPropiedad")
	public String indexEstado(Model model) {
		model.addAttribute("list",estadoService.getAll());
		return "indexEstado";
	}
	
	@GetMapping("/estadoPropiedad/save/{id}")
	public String showSave(@PathVariable("id")int id, Model model) {
		if(id!=0) {
			model.addAttribute("estadoPropiedad",estadoService.get(id));
		} else {
			model.addAttribute("estadoPropiedad",new EstadoPropiedad());
		}
		return "saveEstado";
	}
	
	@PostMapping("/estadoPropiedad/save")
	public String save(EstadoPropiedad estadoPropiedad, Model model) {
		estadoService.save(estadoPropiedad);
		return "redirect:/estadoPropiedad";
	}
	
		
	@GetMapping("/estadoPropiedad/delete/{id}")
	public String delete(@PathVariable Integer id, Model model) {
		try {
		estadoService.delete(id);
		return "redirect:/estadoPropiedad";
		}
		catch(Exception ExceptionMapperStandardImpl) {
			return "mensajeError";
		}	
	}
}
