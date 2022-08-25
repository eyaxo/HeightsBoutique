package com.heightsboutique.controllers;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.heightsboutique.models.LoginUser;
import com.heightsboutique.models.Seller;
import com.heightsboutique.models.User;
import com.heightsboutique.services.ListingSellerService;
import com.heightsboutique.services.UserService;




@Controller

public class SellerController {

	@Autowired
    private ListingSellerService listingSellerService;
	@Autowired
    private UserService userService;
    
   public SellerController(ListingSellerService listingSellerService) {
        this.listingSellerService = listingSellerService;
    }
//    @RequestMapping("/")
//    public String index() {
//    	
//    	return "redirect:/listing/view/all";
//    }
	@GetMapping("/seller")
	public String sellers(Model model, @ModelAttribute("seller") Seller seller) {
    		
    		return "index.jsp"; 
	}
    @PostMapping("/seller")
    public String information(@Valid @ModelAttribute("seller") Seller seller, BindingResult result) {
        if (result.hasErrors()) {
            return "listing.jsp";
        } else {
        this.listingSellerService.createSeller(seller);
            return "redirect:/listing/new";
        }
    }
    @GetMapping("/seller/{id}")
    	public String displaySeller(Model model, @PathVariable("id")Long id) {
    	model.addAttribute("seller", listingSellerService.findSeller(id));    
    	
      return "display.jsp";
     
    }
    
    @GetMapping("/")
    public String index(Model model) {
    
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "login.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {

    	User user = userService.register(newUser, result);
        if(result.hasErrors()) {

            model.addAttribute("newLogin", new LoginUser());
            return "login.jsp";
   }
        session.setAttribute("userId", user.getId());
    
        return "redirect:/listing/view/all";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
    	User user = userService.login(newLogin, result);

    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "login.jsp";
        }
        
        session.setAttribute("userId", user.getId());
        
    	return "redirect:/listing/view/all";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	
    	return "redirect:/";
    }
}
