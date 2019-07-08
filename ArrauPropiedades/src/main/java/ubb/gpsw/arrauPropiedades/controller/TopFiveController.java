package ubb.gpsw.arrauPropiedades.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ubb.gpsw.arrauPropiedades.service.TopFiveService;

@Controller
public class TopFiveController {

	@Autowired
	private TopFiveService topService;
	
	@RequestMapping("/topfive")
	public String indexTopFive(Model model) {
		model.addAttribute("list", topService.getAll());
		return "indexTopFive";
	}
}
