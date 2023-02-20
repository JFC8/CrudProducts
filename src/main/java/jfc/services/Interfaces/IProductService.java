package jfc.services.Interfaces;

import java.util.ArrayList;

import jfc.exceptions.NoProductException;
import jfc.model.dto.ProductDTO;


public interface IProductService {
	public ArrayList<ProductDTO> getAllProducts() throws Exception;
	public ProductDTO getProduct(String code) throws NoProductException;
	public boolean insertProduct(ProductDTO prod) throws Exception;
	public ProductDTO deleteProduct(String code) throws Exception;
	public ProductDTO updateProduct(ProductDTO prodDTO) throws Exception;
}
