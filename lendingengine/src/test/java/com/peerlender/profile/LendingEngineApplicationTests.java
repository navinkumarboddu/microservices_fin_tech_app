package com.peerlender.profile;

import liquibase.Liquibase;
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

	@MockBean
	private Liquibase liquibase;

	@Test
	void contextLoads() {
	}
}
