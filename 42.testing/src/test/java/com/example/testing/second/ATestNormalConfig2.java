package com.example.testing.second;

import com.example.testing.seventh.g.AService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Configuration
public class ATestNormalConfig2 {

	@Bean
	AService aService() {
		AService mock = mock(AService.class);
		when(mock.getVersion()).thenReturn("ATestNormalConfig2" + 29);
		return mock;
	}
}
