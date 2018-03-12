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
    	System.out.println(user.getPassword());
    	System.out.println(user.getType());
    	String userType = user.getType();
//    	System.out.println(userType);          // For Debugging
    	
    	//repo.save(user);
    	
    	model.addAttribute("user", new User());
        //return "register";
    	
    	String redirectPage = "redirect:/nHome";    // Default is Normal User (exceptions will be handled soon isa)
    	
    	if (userType.equals("admin"))      // Alhamdulillah <3 <3 <3 <3 <3 <3 <3 <3 <# <3 <3 <3
    		redirectPage = "redirect:/aHome"; // 5ally shakl el-url .../aHome ... wna 3aml ta7t function awl mbtshof el-shakl da btfta7 aHome.html 3la tol ;)
    	else if (userType.equals("owner"))
    		redirectPage = "redirect:/oHome";
    	else if (userType.equals("normal"))
    		redirectPage = "redirect:/nHome";
    	
    	return redirectPage;         // da el-view elly hyzhar b3d ml-user ydos register (bs el-url msh hyt3'ayar w hyb2a "/welcome" aked y3ny :D
        // b3ml redirect 3la tol mn 3'er m-handlha fe html page
    }
	
	@GetMapping("/login")
	public String getLoginForm(Model model) {
		model.addAttribute("user", new User());
		return "login";          					// return esm el-view elly 3ayz yt3mllo rendering (y3ny b2ollo eft7 page login.html)
    }
	
	@PostMapping("/login")
    public String login(Model model, @ModelAttribute User user) {
    	
    	System.out.println(user.getFirstName());
    	System.out.println(user.getEmail());
    	System.out.println(user.getPassword());
    	System.out.println(user.getType());
    	String userType = user.getType();
//    	System.out.println(userType);          // For Debugging
    	
    	//repo.save(user);
    	
    	model.addAttribute("user", new User());
    	
    	String redirectPage = "redirect:/nHome";
    	
    	if (userType.equals("admin"))      // Alhamdulillah <3 <3 <3 <3 <3 <3 <3 <3 <# <3 <3 <3
    		redirectPage = "redirect:/aHome"; // 5ally shakl el-url .../aHome ... wna 3aml ta7t function awl mbtshof el-shakl da btfta7 aHome.html 3la tol ;)
    	else if (userType.equals("owner"))
    		redirectPage = "redirect:/oHome";
    	else if (userType.equals("normal"))
    		redirectPage = "redirect:/nHome";
    	
    	return redirectPage;         // da el-view elly hyzhar b3d ml-user ydos register (bs el-url msh hyt3'ayar w hyb2a "/welcome" aked y3ny :D
        							 // b3ml redirect 3la tol mn 3'er m-handlha fe html page
    }
	
	@GetMapping("/nHome")
	public String getNormalUserHome(Model model) {
//		model.addAttribute("student", new Student());
		return "nHome";          					
    }
	
	@GetMapping("/oHome")
	public String getStoreOwnerHome(Model model) {
//		model.addAttribute("student", new Student());
		return "oHome";          					
    }
	
	@GetMapping("/aHome")
	public String getAdminHome(Model model) {
//		model.addAttribute("student", new Student());
		return "aHome";          					
    }
	
}
