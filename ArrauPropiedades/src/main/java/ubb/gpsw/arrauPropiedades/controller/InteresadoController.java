package ubb.gpsw.arrauPropiedades.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ubb.gpsw.arrauPropiedades.model.Interesado;
import ubb.gpsw.arrauPropiedades.service.InteresadoService;

@Controller
//@RequestMapping(value = "/interesado", name = "/interesado")
public class InteresadoController {
	
	@Autowired
	private InteresadoService intService;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("list",intService.getAll());
		return "index";
	}
	
	@GetMapping("/save/{id}")
	public String showSave(@PathVariable("id")int id, Model model) {
		if(id!=0) {
			model.addAttribute("interesado",intService.get(id));
		}
		return "save";
	}
	
	@PostMapping("/save")
	public String save(Interesado interesado, Model model) {
		intService.save(interesado);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, Model model) {
		intService.delete(id);
		return "redirect:/";
	}
	
}
