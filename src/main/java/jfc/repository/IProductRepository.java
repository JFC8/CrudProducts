package jfc.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import jfc.model.entity.Product;

@Repository
public interface IProductRepository extends MongoRepository<Product, String>{

	@Query("{ 'code' : ?0 }")
	Product findProductByCode(String code);
	
	@Query(value= "{code: ?0}", delete = true)
	Product deleteProductByCode(String code);

}
