package ubb.gpsw.arrauPropiedades.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ubb.gpsw.arrauPropiedades.controller.pojo.PropiedadPojo;
import ubb.gpsw.arrauPropiedades.model.Interesado;
import ubb.gpsw.arrauPropiedades.model.Propiedad;
import ubb.gpsw.arrauPropiedades.service.InteresadoService;
import ubb.gpsw.arrauPropiedades.service.PropiedadService;


@Controller
public class PropiedadController {
	
	@Autowired
	private PropiedadService propService;
	private InteresadoService intService;

	@RequestMapping("/propiedadPojo")
	public String indexPropiedad(Model model) {
		model.addAttribute("list", propService.findAll());
		return "propiedadPojo";
	}


	/*
	@GetMapping("/propiedadPojo/save/{id}")
	public String getPropiedadById (Model model, @PathVariable("id") Integer id) {
		if(id!=0) {
			model.addAttribute("listDetalle", propService.findById(id));
		}else {
			System.out.print("error");
		}
		return "savePropiedad";
	}
	
	@PostMapping("/propiedadPojo/save")
	public String save(Propiedad propiedadPojo, Model model) {
		propService.save(propiedadPojo);
		return "redirect:/propiedadPojo";
	}*/

	@GetMapping("/propiedadPojo/save/{id}")
	public String showSave(@PathVariable("id")int id, Model model) {
		if(id!=0) {
			model.addAttribute("propiedadPojo",propService.findById(id));
		} else {
			model.addAttribute("propiedadPojo",new PropiedadPojo());
		}
		return "savePropiedad";
	}
	
	@PostMapping("/propiedadPojo/save")
	public String save(Propiedad propiedad, Model model) {
		propService.save(propiedad);
		return "redirect:/propiedadPojo";
	}
	/*
	@GetMapping("/propiedadPojo/delete/{id}")
	public String delete(@PathVariable Integer id, Model model) {
		propService.delete(id);
		return "redirect:/propiedadPojo";
	}*/
	
	
	
	
}
