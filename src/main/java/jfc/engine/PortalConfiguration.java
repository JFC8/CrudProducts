package jfc.engine;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import jfc.services.Impl.ProductServiceImpl;
import jfc.services.Interfaces.IProductService;

@Configuration
public class PortalConfiguration {

	@Bean
	public IProductService cServices() {
		return new ProductServiceImpl();
	}

}