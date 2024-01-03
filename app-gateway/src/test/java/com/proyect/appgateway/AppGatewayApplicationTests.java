package com.proyect.appgateway;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppGatewayApplicationTests {

	@Test
	void contextLoads() {
		AppGatewayApplication myClass = new AppGatewayApplication();
		Assertions.assertThat(myClass).isNotNull();
	}

}
