package com.example.testing.second;

import com.example.testing.second.d.ANonComponent3;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AConfig1 {

	@Bean
	ANonComponent3 component3() {
		return new ANonComponent3();
	}
}
