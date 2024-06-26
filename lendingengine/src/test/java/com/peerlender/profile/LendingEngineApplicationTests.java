package com.peerlender.profile;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;

@SpringBootTest
@ActiveProfiles("test")
class LendingEngineApplicationTests {
	@MockBean
	private DataSource dataSource;

	@Test
	void contextLoads() {
	}
}
