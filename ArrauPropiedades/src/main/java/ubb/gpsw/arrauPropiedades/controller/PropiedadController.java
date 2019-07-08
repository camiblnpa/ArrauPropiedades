package ubb.gpsw.arrauPropiedades.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ubb.gpsw.arrauPropiedades.service.*;

import ubb.gpsw.arrauPropiedades.model.*;

@Controller
public class PropiedadController {

	@Autowired
	private PropiedadService propService;
	
	@Autowired
	private TipoService tipoService;
	
	@Autowired
	private InmobiliariaService inmService;
	
	@Autowired
	private DestinacionService destService;
	
	@Autowired
	private CondicionService condService;
	
	@Autowired
	private EstadoPropiedadService estPropService;
	
	
	//Listar todas las propiedades 
	@RequestMapping("/propiedades")
	public String listPropiedades(Model model) {
		model.addAttribute("list",propService.getAll());
		return "propiedad";
	}
	
	//Obtener propiedad guardada
	@GetMapping("/propiedad/{id}")
	public String showSave(@PathVariable("id") Integer id, Model model) {
		if(id != null && id != 0) {
			model.addAttribute("propiedades", propService.get(id));
			model.addAttribute("tipo", tipoService.getAll());
			model.addAttribute("inmobiliaria", inmService.getAll());
			model.addAttribute("destinacion", destService.getAll());
			model.addAttribute("condicion", condService.getAll());
			model.addAttribute("estadoPropiedad", estPropService.getAll());
		} else {
			model.addAttribute("propiedades", new Propiedad());
			model.addAttribute("tipo", tipoService.getAll());
			model.addAttribute("inmobiliaria", inmService.getAll());
			model.addAttribute("destinacion", destService.getAll());
			model.addAttribute("condicion", condService.getAll());
			model.addAttribute("estadoPropiedad", estPropService.getAll());
		}
		return "savePropiedad";
	}
	
	//Guardar propiedad
	@PostMapping("/savePropiedad")
	public String save(Propiedad propiedad, BindingResult result, Model model, @RequestParam(value="idTipo") int idT,
			@RequestParam(value="idInmobiliaria") int idInm, @RequestParam(value="idDestinacion") int idDest,
			@RequestParam(value="idCondicion") int idCond, @RequestParam(value="idEstadoPropiedad") int idEstProp) {

		Tipo tipo = tipoService.get(idT);
		Inmobiliaria inmobiliaria = inmService.get(idInm);
		Destinacion destinacion = destService.get(idDest);
		Condicion condicion = condService.get(idCond);
		EstadoPropiedad estadoPropiedad = estPropService.get(idEstProp);
		
		propiedad.setTipo(tipo);
		propiedad.setInmobiliaria(inmobiliaria);
		propiedad.setDestinacion(destinacion);
		propiedad.setCondicion(condicion);
		propiedad.setEstadoPropiedad(estadoPropiedad);
		
		propService.save(propiedad);
		
		return "redirect:/propiedades";
	}

}
