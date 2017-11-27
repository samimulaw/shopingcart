package com.packt.webstore.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;

@Repository
public class InMemoryProductRepository implements ProductRepository{
  
   @Autowired
   private NamedParameterJdbcTemplate jdbcTemplate;

   @Override
   public List<Product> getAllProducts() {
      Map<String, Object> params = new HashMap<String, Object>();
        List<Product> result = jdbcTemplate.query("SELECT * FROM products", params, new ProductMapper());
      
        return result;
   }

   private static final class ProductMapper implements RowMapper<Product> {
      public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
         Product product = new Product();
         product.setProductId(rs.getString("ID"));
         product.setName(rs.getString("NAME"));
         
         return product;
      }
   }
   
   @Override
   public void updateStock(String productId, long noOfUnits) { 
      String SQL = "UPDATE PRODUCTS SET UNITS_IN_STOCK = :unitsInStock WHERE ID = :id"; 
      Map<String, Object> params = new HashMap<>();
      params.put("unitsInStock", noOfUnits); 
      params.put("id", productId); 
     
      jdbcTemplate.update(SQL, params); 
   }

@Override
public List<Product> findAllProduct() {
	// TODO Auto-generated method stub
	List<Product> myProducts= new ArrayList<>();
	myProducts.add(new Product("1", "HP", 23.5));
	myProducts.add(new Product("2", "Toshiba", 33.5));
	myProducts.add(new Product("3", "Acer", 43.5));
	return myProducts;
}

}
