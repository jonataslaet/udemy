package com.github.jonataslaet;

import com.github.jonataslaet.integrationtests.testcontainers.AbstractIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class StartupTests extends AbstractIntegrationTest {

	@Test
	void contextLoads() {
	}

}
