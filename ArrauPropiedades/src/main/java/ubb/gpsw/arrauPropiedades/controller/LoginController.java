package ubb.gpsw.arrauPropiedades.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ubb.gpsw.arrauPropiedades.form.LoginForm;
import ubb.gpsw.arrauPropiedades.model.Usuario;
import ubb.gpsw.arrauPropiedades.service.UsuarioService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioService usuarioServicio;
	
	@GetMapping("/login")
	public String getLogin(Model model, HttpSession session){
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute(name="login") LoginForm login, Model model, 
			Usuario usuario, RedirectAttributes flash) {
		
		Usuario admin1 = usuarioServicio.get(1);
		Usuario admin2 = usuarioServicio.get(2);
		
		String username = login.getUsername();
		String password = login.getPassword();
		
		if( admin1.getCorreo().equals(username) && admin1.getPassword().equals(password) ) {
			return "indexAdmin";
		} else if( admin2.getCorreo().equals(username) && admin2.getPassword().equals(password)){
			return "indexAdmin";
		} else {
			flash.addFlashAttribute("error","¡Datos incorrectos!");
			return "redirect:/login";
		}

	}

}
