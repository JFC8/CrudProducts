package jfc.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;

import jfc.repository.IRepository;
import jfc.services.Interfaces.IService;

public class ServiceImpl implements  IService{

	@Autowired
	private IRepository cRepository;
	
	
}
