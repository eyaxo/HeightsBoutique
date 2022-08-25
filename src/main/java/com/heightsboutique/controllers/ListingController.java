package com.heightsboutique.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.heightsboutique.models.Listing;
import com.heightsboutique.models.Seller;
import com.heightsboutique.services.ListingSellerService;



@Controller
@RequestMapping("/listing")
public class ListingController {
	@Autowired
    private ListingSellerService listingSellerService;
    
    public ListingController(ListingSellerService listingSellerService) {
        this.listingSellerService = listingSellerService;
    }
	@RequestMapping("/new")
	public String listing(Model model, @ModelAttribute("listing") Listing listing) {
    	List<Seller> sellers = listingSellerService.allSellers();
        model.addAttribute("sellers", sellers);
    	return "listing.jsp"; 
}

    @PostMapping("/create")
    public String createListing(@Valid @ModelAttribute("listing") Listing listing, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "listing.jsp";
        }
        this.listingSellerService.createListing(listing);
        	return "redirect:/seller/"+ listing.getSeller().getId();
        }
  
    @GetMapping("/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Listing listing = listingSellerService.findListing(id);
        model.addAttribute("listing", listing);
        return "editListing.jsp";
    }
    
    @PostMapping("/{id}/edit")
    public String update(@Valid @ModelAttribute("listing") Listing listing, BindingResult result) {
        if (result.hasErrors()) {
            return "editListing.jsp";
        } else {
            listingSellerService.updateListing(listing);
            return "redirect:/listing/new";
        }
    }
    @RequestMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        listingSellerService.deleteById(id);
        
        return "redirect:/listing/new";
    }
    @GetMapping("/view/all")
    public String view(@ModelAttribute("listing") Listing listing, Model model) {    
        List<Listing> listings = listingSellerService.allListing();
        model.addAttribute("listings", listings);
        return "viewAll.jsp";
    }
    @RequestMapping("/{id}/buy")
    public String buy(@PathVariable Long id) {
        listingSellerService.deleteById(id);
        
        return "redirect:/listing/view/all";
    }

}
  


