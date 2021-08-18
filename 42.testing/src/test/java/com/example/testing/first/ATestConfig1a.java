package com.example.testing.first;

import com.example.testing.first.a.AComponent1;
import com.example.testing.first.b.AComponent2;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import static org.mockito.Mockito.mock;

@TestConfiguration
public class ATestConfig1a {

	@Bean AComponent1 AComponent1() { return mock(AComponent1.class); }
//	@Bean AComponent2 aComponent2() { return mock(AComponent2.class); }
}
