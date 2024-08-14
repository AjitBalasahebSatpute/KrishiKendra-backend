package com.KrishiKendra.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.KrishiKendra.Model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
    @Query("SELECT p FROM Product p WHERE (:query IS NULL OR LOWER(p.productName) LIKE LOWER(CONCAT('%', :query, '%')))") 
	List<Product> searchByProductName(@Param("query") String query);

}
