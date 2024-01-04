package com.proyect.appdiscovery;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppDiscoveryApplicationTests {

	@Test
	void contextLoads() {
		AppDiscoveryApplication myClass=new AppDiscoveryApplication();
		Assertions.assertThat(myClass).isNotNull();
	}

}
