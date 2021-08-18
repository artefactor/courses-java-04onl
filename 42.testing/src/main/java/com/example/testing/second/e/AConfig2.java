package com.example.testing.second.e;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AConfig2 {

	@Bean
	ANonComponent4 component4() {
		return new ANonComponent4();
	}
}
