package com.project.appmedia;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppMediaApplicationTests {

    @Test
    void contextLoads() {
        AppMediaApplication myClass = new AppMediaApplication();
        Assertions.assertThat(myClass).isNotNull();
    }

}
