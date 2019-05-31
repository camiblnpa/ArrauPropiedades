package ubb.gpsw.arrauPropiedades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ubb.gpsw.arrauPropiedades.model.Propiedad;
import ubb.gpsw.arrauPropiedades.service.PropiedadService;
import ubb.gpsw.arrauPropiedades.utilidades.*;
import ubb.gpsw.arrauPropiedades.controller.*;
import ubb.gpsw.arrauPropiedades.controller.pojo.PropiedadPojo;

@Controller
public class PropiedadController {
	
	@Autowired
	private PropiedadService propiedadService;
	
/*
	@RequestMapping("/propiedad")
	public String propiedad(Model model) {
		model.addAttribute("list", propiedadService.getAll());
		return "propiedad";
	}
*/
	
	@GetMapping("/propiedad")
	public RespuestaLista<List<PropiedadPojo>> listar(){
		RespuestaLista<List<PropiedadPojo>> respuesta = new RespuestaLista<List<PropiedadPojo>>
		((List<PropiedadPojo>)propiedadService.findAll(), 0);
		return respuesta;
	}
	
	@GetMapping("/propiedad/savePropiedad/{id}")
	public String showSave(@PathVariable("id") Integer id,Model model) {
		if(id!=null && id!=0) {
			model.addAttribute("propiedad", propiedadService.get(id));
		}
		return "savePropiedad";
	}
	
	@PostMapping("/propiedad/savePropiedad")
	public String save(Propiedad propiedad, Model model) {
		propiedadService.save(propiedad);
		return "redirect:/propiedad";
	}
	
	@GetMapping("/propiedad/deletePropiedad/{id}")
	public String delete(@PathVariable Integer id, Model model) {
		propiedadService.delete(id);
		return"redirect:/propiedad";
	}
}
