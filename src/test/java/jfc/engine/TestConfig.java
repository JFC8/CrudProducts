package jfc.engine;


import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import jfc.services.Impl.ServiceImpl;
import jfc.services.Interfaces.IService;

@TestConfiguration
public class TestConfig {

	@Bean
	@Primary
	public IService gService() {
		return Mockito.mock(ServiceImpl.class);
	}
}
