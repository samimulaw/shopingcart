package com.packt.webstore.domain.repository;

import java.util.List;

import com.packt.webstore.domain.Product;

public interface ProductRepository {

	List <Product> getAllProducts();
	List <Product> findAllProduct();
	void updateStock(String productId, long noOfUnits);
}
