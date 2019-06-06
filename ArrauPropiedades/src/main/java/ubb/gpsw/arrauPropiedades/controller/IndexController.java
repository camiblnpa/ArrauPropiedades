package ubb.gpsw.arrauPropiedades.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/indexAdmin")
	public String indexAdmin(Model model, HttpSession session){
		return "indexAdmin";
	}
	
	@GetMapping("/index")
	public String index(Model model, HttpSession session) {
		return "index";
	}
	
}
