package ubb.gpsw.arrauPropiedades.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ubb.gpsw.arrauPropiedades.model.Tipo;
import ubb.gpsw.arrauPropiedades.service.TipoService;

@Controller
public class TipoController {

	@Autowired
	private TipoService tipoService;
	
	@RequestMapping("/tipo")
	public String index(Model model) {
		model.addAttribute("list",tipoService.getAll());
		return "indexTipo";
	}
	
	@GetMapping("/tipo/save/{id}")
	public String showSave(@PathVariable("id")int id, Model model) {
		if(id!=0) {
			model.addAttribute("tipo",tipoService.get(id));
		} else {
			model.addAttribute("tipo",new Tipo());
		}
		return "saveTipo";
	}
	
	@PostMapping("/tipo/save")
	public String save(Tipo tipo, Model model) {
		
		tipoService.save(tipo);
		return "redirect:/tipo";
	}
	
	@GetMapping("/tipo/delete/{id}")
	public String delete(@PathVariable Integer id, Model model) {
		try{
			tipoService.delete(id);
			return "redirect:/tipo";
		}
		catch(Exception ExceptionMapperStandardImpl) {
			return "mensajeError";
		}
	}
	
	
}

