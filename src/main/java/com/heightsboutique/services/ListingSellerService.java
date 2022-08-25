package com.heightsboutique.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heightsboutique.models.Listing;
import com.heightsboutique.models.Seller;
import com.heightsboutique.repositories.ListingRepository;
import com.heightsboutique.repositories.SellerRepository;



@Service
public class ListingSellerService {

	@Autowired
	private SellerRepository sellerRepository;
	@Autowired
	private ListingRepository listingRepository;
	
	public List<Listing> allListing(){
		return this.listingRepository.findAll();
	}
	public Listing createListing(Listing l){
		return this.listingRepository.save(l);
	}
    public Listing findListing(Long id) {
    	return this.listingRepository.findById(id).orElse(null);
    }    
    public Listing updateListing(Listing listing) {
    
    	return listingRepository.save(listing);
    }
    public void deleteById(Long id) {
    	listingRepository.deleteById(id);
    }
	public List<Seller> allSellers(){
		return this.sellerRepository.findAll();
		
	}
    public Seller createSeller(Seller s) {
        return sellerRepository.save(s);
    }
    public Seller findSeller(Long id) {
    	return this.sellerRepository.findById(id).orElse(null);
    }
}