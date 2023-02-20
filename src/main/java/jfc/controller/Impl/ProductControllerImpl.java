package jfc.controller.Impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import jfc.controller.Interfaces.IProductController;
import jfc.model.dto.ProductDTO;
import jfc.services.Interfaces.IProductService;

@RestController
public class ProductControllerImpl implements IProductController{

	@Autowired
    private IProductService pServices; 
	
	@Override
	@GetMapping("/api/product")
	public String getProduct(@RequestParam(required = true)String code) throws Exception {
		return new Gson().toJson(this.pServices.getProduct(code)); 
	}
	
	@Override
	@PostMapping("/api/product")
	public boolean insertProduct(@RequestBody ProductDTO prod) throws Exception {
		return this.pServices.insertProduct(prod);
	}
	
	@Override
	@DeleteMapping("/api/product")
	public ProductDTO deleteProduct(String code) throws Exception{
		return this.pServices.deleteProduct(code);
	}
	
	@Override
	@GetMapping("/api/products")
	public ArrayList<ProductDTO> getAllProducts() throws Exception{
		return this.pServices.getAllProducts();
	};
	
	@Override
	@PutMapping("/api/product")
	public ProductDTO updateProduct (ProductDTO prodDTO) throws Exception{
		return this.pServices.updateProduct(prodDTO);
	}
}
