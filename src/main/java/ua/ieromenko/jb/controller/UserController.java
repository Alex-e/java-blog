package ua.ieromenko.jb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.ieromenko.jb.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userSrevice;
	
	@RequestMapping("/users")
	public String users(Model model){
		model.addAttribute("uders", userSrevice.findAll());
		return "users";
	}
}
