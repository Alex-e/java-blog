package ua.ieromenko.jb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.ieromenko.jb.service.UserService;

@Controller
@RequestMapping("/users")
public class AdminController {
	
	@Autowired
	private UserService userService;

	@RequestMapping
	public String users(Model model){
		model.addAttribute("users", userService.findAll());
		return "users";
	}
	
	@RequestMapping("/{id}")
	public String getUserById(Model model, @PathVariable int id){
		model.addAttribute("user", userService.findOneWithBlog(id));
		return "user-detail";
	}

	@RequestMapping(value="/remove/{id}")
	public String removeUser(@PathVariable int id) {
		userService.delete(id);
		return "redirect:/users.html";
	}
}
