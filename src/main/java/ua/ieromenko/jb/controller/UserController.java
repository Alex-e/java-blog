package ua.ieromenko.jb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.ieromenko.jb.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/users")
	public String users(Model model){
		model.addAttribute("users", userService.findAll());
		return "users";
	}
	
	@RequestMapping("/users/{id}")
	public String getUserById(Model model, @PathVariable int id){
		model.addAttribute("user", userService.findOneWithBlog(id));
		return "user-detail";
	}
	
	@RequestMapping("/reguster")
	public String showRegistrer(){
		return "user-register";
	}
	
	
}
