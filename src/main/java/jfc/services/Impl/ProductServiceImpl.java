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
	public boolean insertProduct(ProductDTO prod) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProduct(String code) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
}
