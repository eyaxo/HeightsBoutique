package com.heightsboutique.repositories;



import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.heightsboutique.models.Seller;

@Repository
public interface SellerRepository extends CrudRepository<Seller, Long> {

	List<Seller> findAll();

}