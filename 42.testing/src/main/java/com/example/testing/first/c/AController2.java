package com.example.testing.first.c;

import com.example.testing.seventh.g.AService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AController2 {
	@Autowired
	AService aService;
}
