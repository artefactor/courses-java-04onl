package com.example.testing.second.d;

import com.example.testing.seventh.g.AService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestConfiguration
public class ATestConfig2 {

	@Bean
	AService aService() {
		AService mock = mock(AService.class);
		when(mock.getVersion()).thenReturn("ATestConfig2" + 71);
		return mock;
}}
