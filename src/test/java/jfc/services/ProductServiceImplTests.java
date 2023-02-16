package jfc.services;

import static org.assertj.core.api.Assertions.fail;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import jfc.engine.PortalApplication;
//import jfc.engine.TestConfig;
import jfc.model.entity.Product;
import jfc.repository.IProductRepository;
import jfc.services.Impl.ProductServiceImpl;

@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
//@Import(TestConfig.class)
@SpringBootTest(classes = PortalApplication.class)
public class ProductServiceImplTests {

	@InjectMocks
	private ProductServiceImpl cService;

	@Mock
	private IProductRepository cRepository;

	@BeforeEach
	public void setMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@Order(1)
	public void firstTestsHere() {

		Object[] objectMocks = new Object[4];

		/*when(cRepository.getObject(any())).thenReturn();

		/*
		 * Tests here
		 */
	}

}
