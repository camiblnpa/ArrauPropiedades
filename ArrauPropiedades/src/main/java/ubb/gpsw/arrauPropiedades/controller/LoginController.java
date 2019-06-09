package ubb.gpsw.arrauPropiedades.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ubb.gpsw.arrauPropiedades.form.LoginForm;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String getLogin(Model model, HttpSession session){
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute(name="login") LoginForm login, Model model) {
		String username = login.getUsername();
		String password = login.getPassword();
		
		if("admin".equals(username) && "admin".equals(password)) {
			return "indexAdmin";
		}
		model.addAttribute("invalidCredentials",true);
		return "login";
	}

}
