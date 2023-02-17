package jfc.services.Impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import jfc.exceptions.NoProductException;
import jfc.model.dto.ProductDTO;
import jfc.model.entity.Product;
import jfc.repository.IProductRepository;
import jfc.services.Interfaces.IProductService;

public class ProductServiceImpl implements  IProductService{

	@Autowired
	private IProductRepository pRepository;
	
	/*
	@Override
	public ArrayList<Product> getAllProducts() throws Exception{
		ArrayList<Product> toRet = new ArrayList<Product>();
		
		return toRet;
	}
	*/
	@Override
	public ProductDTO getProduct(String code) throws NoProductException{
		Product prod = new Product();
		try {
			prod = this.pRepository.findProductByCode(code);
		}catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
		
		ProductDTO prodDTO = new ProductDTO();
		
		prodDTO.setCode(prod.getCode());
		prodDTO.setCode2(prod.getCode2());
		prodDTO.setName(prod.getName());
		prodDTO.setDescription(prod.getDescription());
		prodDTO.setDescription2(prod.getDescription2());
		prodDTO.setCategory(prod.getCategory());
		
		return prodDTO;
	}

	@Override
	public boolean insertProduct(ProductDTO prodDTO) throws Exception {
		Product prod = new Product();
		
		prod.setCode(prodDTO.getCode());;
		prod.setCode2(prodDTO.getCode2());
		prod.setName(prodDTO.getName());
		prod.setDescription(prodDTO.getDescription());
		prod.setDescription2(prodDTO.getDescription2());
		prod.setCategory(prodDTO.getCategory());
		
		try {
			this.pRepository.insert(prod);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public ProductDTO deleteProduct(String code) throws Exception {
		Product prod = this.pRepository.deleteProductByCode(code);
		
		ProductDTO prodDTO = new ProductDTO();
		
		prodDTO.setCode(prod.getCode());
		prodDTO.setCode2(prod.getCode2());
		prodDTO.setName(prod.getName());
		prodDTO.setDescription(prod.getDescription());
		prodDTO.setDescription2(prod.getDescription2());
		prodDTO.setCategory(prod.getCategory());
		
		return prodDTO;
	}
	
}
