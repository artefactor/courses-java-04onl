package com.example.testing.third;

import com.example.testing.second.f.ANonComponent5;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ATestNormalConfig {

	@Bean
	ANonComponent5 nonComponent5() {
		return new ANonComponent5();
	}
}
