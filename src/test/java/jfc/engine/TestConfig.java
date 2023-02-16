package jfc.engine;


import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import jfc.services.Impl.ProductServiceImpl;
import jfc.services.Interfaces.IProductService;

@TestConfiguration
public class TestConfig {

	@Bean
	@Primary
	public IProductService gService() {
		return Mockito.mock(ProductServiceImpl.class);
	}
}
