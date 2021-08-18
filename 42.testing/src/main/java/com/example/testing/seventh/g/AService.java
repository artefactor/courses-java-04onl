package com.example.testing.seventh.g;

import org.springframework.stereotype.Service;

@Service
public class AService {
	int version = 5;

	public String getVersion() {
		return "Normal version: " + version;
	}
}
