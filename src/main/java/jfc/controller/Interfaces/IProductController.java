package jfc.controller.Interfaces;

import jfc.model.dto.ProductDTO;

public interface IProductController {

	String getProduct(String code) throws Exception;
	boolean insertProduct(ProductDTO prod) throws Exception;
	ProductDTO deleteProduct(String code) throws Exception;
	
	
}
