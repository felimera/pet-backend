package com.petproject.appcustomer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppCustomerApplicationTests {

    @Test
    void contextLoads() {
        AppCustomerApplication myClass = new AppCustomerApplication();
        Assertions.assertThat(myClass).isNotNull();
    }

}
