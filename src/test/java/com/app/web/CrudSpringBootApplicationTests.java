package com.app.web;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootTest
@EnableJpaRepositories("com.app.web.repositorio")
class CrudSpringBootApplicationTests {

	@Test
	void contextLoads() {
	}

}
