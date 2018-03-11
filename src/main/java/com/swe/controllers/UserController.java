package com.swe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.swe.entities.User;


@Controller
public class UserController {
	
	@GetMapping("/welcome")
	public String getFirstPage(Model model) {
		return "welcome";
	}
	
	@GetMapping("/register")
	public String getRegistirationForm(Model model) {
		model.addAttribute("user", new User());
		return "register";          					// return esm el-view elly 3ayz yt3mllo rendering
    }
	
    @PostMapping("/register")
    public String addUser(Model model, @ModelAttribute User user) {
    	
    	System.out.println(user.getFirstName());
    	System.out.println(user.getLastName());
    	System.out.println(user.getType());
    	
    	//repo.save(user);
    	
    	model.addAttribute("user", new User());
        //return "register";
    	return "welcome";        // da el-view elly hyzhar b3d ml-user ydos register (bs el-url msh hyt3'ayar w hyb2a "/welcome" aked y3ny :D
        
    }
	
	@GetMapping("/login")
	public String getLoginForm(Model model) {
//		model.addAttribute("student", new Student());
		return "login";          					// return esm el-view elly 3ayz yt3mllo rendering
    }
	
}
