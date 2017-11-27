package com.packt.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

   @Autowired
   private ProductRepository productRepository;
  
   @Override
   public void updateAllStock() {
     
   }

@Override
public List<Product> findProducts() {
	// TODO Auto-generated method stub
	
	return productRepository.findAllProduct();
}
}
