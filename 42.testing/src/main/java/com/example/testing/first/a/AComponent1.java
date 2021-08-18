package com.example.testing.first.a;

import com.example.testing.first.b.AComponent2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AComponent1 {
	@Autowired
	AComponent2 component2;
}
