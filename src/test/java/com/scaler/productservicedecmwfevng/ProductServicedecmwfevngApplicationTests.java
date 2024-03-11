package com.scaler.productservicedecmwfevng;

import com.scaler.productservicedecmwfevng.controller.ProductController;
import com.scaler.productservicedecmwfevng.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.naming.ldap.PagedResultsControl;

@SpringBootTest
class ProductServicedecmwfevngApplicationTests {

	@Autowired
	private ProductController productController;

	@MockBean
	private ProductService productService;

	@Test
	void contextLoads() {
	}

	@Test
	void testGetAllProducts(){


	}
}
