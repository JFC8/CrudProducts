package jfc.repository;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import jfc.model.entity.Product;

@Repository
public interface IProductRepository extends MongoRepository<Product, String>{

	/*
	@Query()
	ArrayList<Product> findAllProducts();
	*/

	@Query("{ 'code' : ?0 }")
	Product findProductByCode(String code);
	
	@Query(value= "{code: ?0}", delete = true)
	void deleteProduct(String code);

	/*
	@Query()
	void insertProduct(Product p);
	*/
}
