package jfc.controller.Interfaces;

import java.util.ArrayList;

import jfc.model.dto.ProductDTO;

public interface IProductController {

	String getProduct(String code) throws Exception;
	boolean insertProduct(ProductDTO prod) throws Exception;
	ProductDTO deleteProduct(String code) throws Exception;
	ArrayList<ProductDTO> getAllProducts() throws Exception;
	ProductDTO updateProduct (ProductDTO prodDTO) throws Exception;
}
